/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Project.Panel;

import Project.Database.DatabaseConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Stack;
import java.util.Vector;

public class SalesPanel extends javax.swing.JPanel {
    public SalesPanel() {
        initComponents();
        load_data();
        try (Connection conn = DatabaseConnector.connectDatabase();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT value FROM extra WHERE extra_ID = 1")) {

            if (rs.next()) {
                String value = rs.getString("value");
                System.out.println("Giá trị lấy được: " + value);
                System.out.println(value);
                invoiceNumberLabel.setText(value);
            } else {
                System.out.println("Không tìm thấy dữ liệu!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getCustomerID(String customerName) {
        String customerID = "";

        String sql = "SELECT customer_ID FROM customer WHERE customer_name = ?";

        try (Connection conn = DatabaseConnector.connectDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customerName);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    customerID = rs.getString("customer_ID");
                }
            }

        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy Customer ID: " + e.getMessage());
            e.printStackTrace();
        }

        return customerID;
    }


    private void send_to_sales_database() {
        try (Connection conn = DatabaseConnector.connectDatabase()) {
            String sql = "INSERT INTO sales (invoice_ID, customer_ID, customer_name, total_quantity, total_bill, status, change_or_lack) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                String invoiceID = invoiceNumberLabel.getText();
                String customerName = customerNameComboBox.getSelectedItem().toString();
                String customerID = getCustomerID(customerName);

                if (customerID.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy ID khách hàng!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int totalQuantity = totalQuantityNumberLabel.getText().isEmpty() ? 0
                        : Integer.parseInt(totalQuantityNumberLabel.getText());

                BigDecimal totalBill = new BigDecimal(parseCurrency(totalAmountNumberLabel.getText()));
                BigDecimal paidAmount = new BigDecimal(parseCurrency(paidAmountTextField.getText()));
                BigDecimal changeOrLack = paidAmount.subtract(totalBill);
                System.out.println(changeOrLack);
                System.out.println(totalBill);
                System.out.println(paidAmount);

                pstmt.setString(1, invoiceID);
                pstmt.setString(2, customerID);
                pstmt.setString(3, customerName);
                pstmt.setInt(4, totalQuantity);
                pstmt.setBigDecimal(5, totalBill);
                pstmt.setString(6, (changeOrLack.compareTo(BigDecimal.ZERO) >= 0) ? "Đã thanh toán" : "Chưa thanh toán");
                pstmt.setBigDecimal(7, changeOrLack);

                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Hóa đơn đã được lưu thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu hóa đơn: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void send_to_cart_database() {
        try (Connection conn = DatabaseConnector.connectDatabase()) {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            int rowCount = model.getRowCount();
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(this, "Không có sản phẩm nào để lưu!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            conn.setAutoCommit(false);

            String sql = "INSERT INTO cart (invoice_ID, product_name, bar_code, quantity, unit_price, total_price) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (int i = 0; i < rowCount; i++) {
                    try {
                        String invoiceNumber = validateString(model.getValueAt(i, 0));
                        String productName = validateString(model.getValueAt(i, 1));
                        String productBarCode = validateString(model.getValueAt(i, 2));
                        int quantity = Integer.parseInt(model.getValueAt(i, 3).toString());

                        if (quantity <= 0) throw new IllegalArgumentException("Số lượng phải > 0");

                        BigDecimal productPrice = new BigDecimal(parseCurrency(model.getValueAt(i, 4).toString()));
                        BigDecimal productTotalPrice = new BigDecimal(parseCurrency(model.getValueAt(i, 5).toString()));

                        pstmt.setString(1, invoiceNumber);
                        pstmt.setString(2, productName);
                        pstmt.setString(3, productBarCode);
                        pstmt.setInt(4, quantity);
                        pstmt.setBigDecimal(5, productPrice);
                        pstmt.setBigDecimal(6, productTotalPrice);

                        pstmt.executeUpdate();

                    } catch (Exception e) {
                        System.err.println("Lỗi dữ liệu dòng " + i + ": " + e.getMessage());
                        // Tiếp tục xử lý các dòng khác thay vì rollback toàn bộ giao dịch
                    }
                }

                conn.commit();
                JOptionPane.showMessageDialog(this, "Đã lưu giỏ hàng thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu giỏ hàng: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private double parseCurrency(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0.0;
        }

        // Loại bỏ ký tự không phải số và dấu '.'
        String cleanValue = value.replaceAll("[^\\d.]", "");

        // Loại bỏ tất cả dấu '.' (dấu phân cách hàng nghìn)
        cleanValue = cleanValue.replace(".", "");

        try {
            return Double.parseDouble(cleanValue);
        } catch (NumberFormatException e) {
            System.err.println("Lỗi parseCurrency: Không thể chuyển đổi giá trị '" + value + "' thành số.");
            return 0.0;
        }
    }

    private String validateString(Object value) {
        if (value == null) {
            return "";
        }
        String str = value.toString().trim();
        // Loại bỏ các ký tự đặc biệt nguy hiểm cho SQL
        return str.replace("'", "''");
    }

    private void calculate_cart_changes() {
        try {
            // 1Lấy và xử lý số tiền khách thanh toán
            String paidText = paidAmountTextField.getText().trim();
            paidText = paidText.replaceAll("[^\\d]", ""); // Chỉ giữ lại số, bỏ dấu chấm

            // Lấy và xử lý tổng tiền giỏ hàng
            String totalText = totalAmountNumberLabel.getText().replaceAll("[^\\d]", ""); // Chỉ giữ lại số

            if (totalText.isEmpty()) {
                changesNumberLabel.setText("0 ₫");
                return;
            }

            //  Chuyển đổi chuỗi sang số
            double paidAmount = Double.parseDouble(paidText);       // Số tiền khách đưa
            double cartTotalPrice = Double.parseDouble(totalText);  // Tổng tiền cần thanh toán

            // Tính toán số tiền thừa/thiếu
            double dueAmount = paidAmount - cartTotalPrice;

            //  Định dạng tiền tệ Việt Nam
            DecimalFormat formatter = new DecimalFormat("#,### ₫");
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("vi", "VN"));
            symbols.setGroupingSeparator('.'); // Đặt dấu phân cách hàng nghìn là dấu '.'
            formatter.setDecimalFormatSymbols(symbols);

            // Hiển thị kết quả
            if (dueAmount >= 0) {
                changesNumberLabel.setText(formatter.format(dueAmount));
                changesNumberLabel.setForeground(Color.GREEN); // Màu xanh nếu dư tiền
            } else {
                changesNumberLabel.setText(formatter.format(Math.abs(dueAmount)) + " (thiếu)");
                changesNumberLabel.setForeground(Color.RED); // Màu đỏ nếu thiếu tiền
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi tính toán: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            changesNumberLabel.setText("0 ₫");
        }

    }

    private void calculate_cart_total_price() {
        //Tính tổng giá trị giỏ hàng
        double total = 0.0;

        for (int i = 0; i < dataTable.getRowCount(); i++) {
            try {
                Object value = dataTable.getValueAt(i, 5);
                if (value != null) {
                    String priceStr = value.toString().trim();

                    // Loại bỏ ký tự "đ" và khoảng trắng, giữ lại số và dấu chấm.
                    priceStr = priceStr.replaceAll("[^\\d.]", "");

                    // Đảm bảo chuỗi không rỗng trước khi xử lý
                    if (!priceStr.isEmpty()) {
                        // Xóa dấu chấm (.) vì nó là dấu phân cách hàng nghìn trong định dạng Việt Nam
                        priceStr = priceStr.replace(".", "");

                        // Chuyển chuỗi thành số
                        double productTotalPrice = Double.parseDouble(priceStr);
                        total += productTotalPrice;
                    }
                }
                totalAmountNumberLabel.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(total));
            } catch (Exception e) {
                System.err.println("Lỗi tính toán dòng " + i + ": " + e.getMessage());
            }
        }

        //Tổng sản phẩm giỏ hàng
        Integer totalQuantity = 0;
        for (int i = 0; i < dataTable.getRowCount(); i++) {
            try {
                Object value = dataTable.getValueAt(i, 3);
                if (value != null) {
                    String quantityStr = value.toString().trim();
                    quantityStr = quantityStr.replaceAll("[^\\d]", "");
                    if (!quantityStr.isEmpty()) {
                        int quantity = Integer.parseInt(quantityStr);
                        totalQuantity += quantity;
                    }
                }
            } catch (Exception e) {
                System.err.println("Lỗi tính toán dòng " + i + ": " + e.getMessage());
            }
        }
        totalQuantityNumberLabel.setText(totalQuantity.toString());

    }

    private void calculate_product_total_price(){
        //Tính toán tổng giá tiền
        try {
            //Kiểm tra số lượng
            String quantityText = quantityTextField.getText().trim();
            if (quantityText.isEmpty()) {
                productTotalPriceNumberLabel.setText(productPriceNumberLabel.getText());
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityText);
                if (quantity <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Số lượng phải là số nguyên dương",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                quantityTextField.setText("1");
                productTotalPriceNumberLabel.setText("0");
                return;
            }

            String priceText = productPriceNumberLabel.getText().replaceAll("[^\\d]", "");

            double price;
            try {
                price = Double.parseDouble(priceText);
                if (price <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                productTotalPriceNumberLabel.setText("0");
                return;
            }

            //tính toán và chỉnh sửa total
            double total = quantity * price;
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            productTotalPriceNumberLabel.setText(currencyFormat.format(total));

        } catch (Exception e) {
            productTotalPriceNumberLabel.setText("0");
        }
    }

    private void load_data(){
        // Load danh sách khách hàng vào combo box
        try (Connection conn = DatabaseConnector.connectDatabase();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT customer_name FROM customer ORDER BY customer_name")) {

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            // Thêm item mặc định
            model.addElement("-- Chọn khách hàng --");

            while (resultSet.next()) {
                String name = resultSet.getString("customer_name");
                model.addElement(name);
            }

            customerNameComboBox.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách khách hàng: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Load danh sách sản phẩm vào combo box
        try (Connection conn = DatabaseConnector.connectDatabase();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT product_name FROM product ORDER BY product_name")) {

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            // Thêm item mặc định
            model.addElement("-- Chọn sản phẩm --");

            while (resultSet.next()) {
                String name = resultSet.getString("product_name");
                model.addElement(name);
            }

            productNameComboBox.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách sản phẩm: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        invoiceLabel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        invoiceNumberLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        customerLabel = new javax.swing.JLabel();
        productLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        productPriceLabel = new javax.swing.JLabel();
        productPriceNumberLabel = new javax.swing.JLabel();
        customerNameComboBox = new javax.swing.JComboBox<>();
        productNameComboBox = new javax.swing.JComboBox<>();
        quantityTextField = new javax.swing.JTextField();
        productTotalPriceLabel = new javax.swing.JLabel();
        productTotalPriceNumberLabel = new javax.swing.JLabel();
        productBarCodeLabel = new javax.swing.JLabel();
        productBarCodeNumberLabel = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        addProductButton = new javax.swing.JButton();
        removeProductButton = new javax.swing.JButton();
        removeAllButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        paidAmountTextField = new javax.swing.JTextField();
        paidAmountLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        totalAmountLabel = new javax.swing.JLabel();
        changesLabel = new javax.swing.JLabel();
        totalAmountNumberLabel = new javax.swing.JLabel();
        changesNumberLabel = new javax.swing.JLabel();
        totalQuantityLabel = new javax.swing.JLabel();
        totalQuantityNumberLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        basePanel.setBackground(new java.awt.Color(58, 71, 80));

        invoiceLabel.setBackground(new java.awt.Color(0, 173, 181));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(238, 238, 238));
        jLabel1.setText("Hóa đơn số:");

        invoiceNumberLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        invoiceNumberLabel.setForeground(new java.awt.Color(238, 238, 238));
        invoiceNumberLabel.setText("00");

        javax.swing.GroupLayout invoiceLabelLayout = new javax.swing.GroupLayout(invoiceLabel);
        invoiceLabel.setLayout(invoiceLabelLayout);
        invoiceLabelLayout.setHorizontalGroup(
            invoiceLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invoiceLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoiceNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        invoiceLabelLayout.setVerticalGroup(
            invoiceLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invoiceLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(invoiceLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(invoiceNumberLabel))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 173, 181));

        customerLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(238, 238, 238));
        customerLabel.setText("Khách hàng:");

        productLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        productLabel.setForeground(new java.awt.Color(238, 238, 238));
        productLabel.setText("Sản phẩm:");

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(238, 238, 238));
        quantityLabel.setText("Số lượng:");

        productPriceLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        productPriceLabel.setForeground(new java.awt.Color(238, 238, 238));
        productPriceLabel.setText("Giá sản phẩm:");

        productPriceNumberLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        productPriceNumberLabel.setForeground(new java.awt.Color(238, 238, 238));
        productPriceNumberLabel.setText("00.00");

        customerNameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        productNameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productNameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameComboBoxActionPerformed(evt);
            }
        });

        quantityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityTextFieldKeyReleased(evt);
            }
        });

        productTotalPriceLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        productTotalPriceLabel.setForeground(new java.awt.Color(238, 238, 238));
        productTotalPriceLabel.setText("Tổng giá sản phẩm:");

        productTotalPriceNumberLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        productTotalPriceNumberLabel.setForeground(new java.awt.Color(238, 238, 238));
        productTotalPriceNumberLabel.setText("00.00");

        productBarCodeLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        productBarCodeLabel.setForeground(new java.awt.Color(238, 238, 238));
        productBarCodeLabel.setText("Mã vạch:");

        productBarCodeNumberLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        productBarCodeNumberLabel.setForeground(new java.awt.Color(238, 238, 238));
        productBarCodeNumberLabel.setText("0000000000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(customerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productLabel)
                .addGap(3, 3, 3)
                .addComponent(productNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(quantityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(productPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productPriceNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productTotalPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productTotalPriceNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(productBarCodeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productBarCodeNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerLabel)
                    .addComponent(productLabel)
                    .addComponent(quantityLabel)
                    .addComponent(productPriceLabel)
                    .addComponent(productPriceNumberLabel)
                    .addComponent(customerNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productTotalPriceLabel)
                    .addComponent(productTotalPriceNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productBarCodeLabel)
                    .addComponent(productBarCodeNumberLabel))
                .addContainerGap())
        );

        tablePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dataTable.setBackground(new java.awt.Color(238, 238, 238));
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Tên sản phẩm", "Mã vạch", "Số lượng", "Giá từng sản phẩm", "Tổng giá sản phẩm"
            }
        ));
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );

        buttonPanel.setBackground(new java.awt.Color(238, 238, 238));

        addProductButton.setBackground(new java.awt.Color(0, 173, 181));
        addProductButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addProductButton.setForeground(new java.awt.Color(238, 238, 238));
        addProductButton.setText("Thêm sản phẩm vào giỏ hàng");
        addProductButton.setFocusable(false);
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        removeProductButton.setBackground(new java.awt.Color(0, 173, 181));
        removeProductButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        removeProductButton.setForeground(new java.awt.Color(238, 238, 238));
        removeProductButton.setText("Bỏ sản phẩm khỏi giỏ hàng");
        removeProductButton.setFocusable(false);
        removeProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeProductButtonActionPerformed(evt);
            }
        });

        removeAllButton.setBackground(new java.awt.Color(0, 173, 181));
        removeAllButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        removeAllButton.setForeground(new java.awt.Color(238, 238, 238));
        removeAllButton.setText("Bỏ toàn bộ");
        removeAllButton.setFocusable(false);
        removeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(removeProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeAllButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(238, 238, 238));

        paidAmountTextField.setText("0");
        paidAmountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidAmountTextFieldKeyReleased(evt);
            }
        });

        paidAmountLabel.setBackground(new java.awt.Color(48, 56, 65));
        paidAmountLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        paidAmountLabel.setText("Số tiền đã thanh toán");

        jPanel1.setBackground(new java.awt.Color(0, 173, 181));
        jPanel1.setForeground(new java.awt.Color(238, 238, 238));

        totalAmountLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        totalAmountLabel.setForeground(new java.awt.Color(238, 238, 238));
        totalAmountLabel.setText("Tổng số tiền:");

        changesLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        changesLabel.setForeground(new java.awt.Color(238, 238, 238));
        changesLabel.setText("Dư/Thiếu:");

        totalAmountNumberLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        totalAmountNumberLabel.setForeground(new java.awt.Color(238, 238, 238));
        totalAmountNumberLabel.setText("00.00");

        changesNumberLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        changesNumberLabel.setForeground(new java.awt.Color(238, 238, 238));
        changesNumberLabel.setText("00.00");

        totalQuantityLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        totalQuantityLabel.setForeground(new java.awt.Color(238, 238, 238));
        totalQuantityLabel.setText("Tổng số lượng:");

        totalQuantityNumberLabel.setBackground(new java.awt.Color(0, 173, 181));
        totalQuantityNumberLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        totalQuantityNumberLabel.setForeground(new java.awt.Color(238, 238, 238));
        totalQuantityNumberLabel.setText("00.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalAmountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalAmountNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(changesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changesNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(totalQuantityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalQuantityNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalAmountLabel)
                    .addComponent(totalAmountNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changesLabel)
                    .addComponent(changesNumberLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalQuantityLabel)
                    .addComponent(totalQuantityNumberLabel))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paidAmountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paidAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paidAmountLabel)
                            .addComponent(paidAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        saveButton.setBackground(new java.awt.Color(238, 238, 238));
        saveButton.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 173, 181));
        saveButton.setText("Lưu");
        saveButton.setFocusable(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(invoiceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(invoiceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                        .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removeProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeProductButtonActionPerformed
        // bỏ 1 sản phẩm khỏi giỏ hàng
        try {
            // Lấy model của bảng
            DefaultTableModel defaultTableModel = (DefaultTableModel) dataTable.getModel();

            // Kiểm tra có dòng nào được chọn không
            int row = dataTable.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this,
                        "Vui lòng chọn sản phẩm cần xóa",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Lấy ID sản phẩm từ dòng được chọn (cột 0)
            String id = dataTable.getValueAt(row, 0).toString();

            // Xác nhận trước khi xóa
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc chắn muốn xóa sản phẩm này?",
                    "Xác nhận xóa",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Xóa dòng khỏi bảng
                defaultTableModel.removeRow(row);
                JOptionPane.showMessageDialog(this,
                        "Đã xóa sản phẩm thành công",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Lỗi khi xóa sản phẩm: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        calculate_cart_total_price();
        calculate_cart_changes();
    }//GEN-LAST:event_removeProductButtonActionPerformed

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        // thêm sản phẩm vào table
        DefaultTableModel defaultTableModel = (DefaultTableModel) dataTable.getModel();
        Vector vector = new Vector();
        vector.add(invoiceNumberLabel.getText());
        vector.add(productNameComboBox.getSelectedItem().toString());
        vector.add(productBarCodeNumberLabel.getText());
        vector.add(quantityTextField.getText());
        vector.add(productPriceNumberLabel.getText());
        vector.add(productTotalPriceNumberLabel.getText());

        defaultTableModel.addRow(vector);
        calculate_cart_total_price();
        calculate_cart_changes();
    }//GEN-LAST:event_addProductButtonActionPerformed

    private void removeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllButtonActionPerformed
        // Reset giỏ hàng
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc chắn muốn xóa toàn bộ giỏ hàng?",
                "Xác nhận reset giỏ hàng",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Lấy model của bảng
                DefaultTableModel defaultTableModel = (DefaultTableModel) dataTable.getModel();

                // Xóa toàn bộ dữ liệu trong bảng
                defaultTableModel.setRowCount(0);
                // Thông báo thành công
                JOptionPane.showMessageDialog(
                        this,
                        "Đã reset giỏ hàng thành công",
                        "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE
                );

                // Focus lại vào ô nhập liệu đầu tiên
                productNameComboBox.requestFocus();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        this,
                        "Lỗi khi reset giỏ hàng: " + e.getMessage(),
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE
                );
                e.printStackTrace();
            }
        }
        calculate_cart_total_price();
        calculate_cart_changes();
        totalAmountNumberLabel.setText("0 đ");
        changesNumberLabel.setText("0 đ");
        totalQuantityNumberLabel.setText("0");

    }//GEN-LAST:event_removeAllButtonActionPerformed

    private void productNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        //Load giá và Mã vạch
        if (productNameComboBox.getSelectedItem() == null) {
            productPriceNumberLabel.setText("0");
            calculate_product_total_price();
            return;
        }

        String productName = productNameComboBox.getSelectedItem().toString().trim();
        if (productName.isEmpty()) {
            productPriceNumberLabel.setText("0");
            calculate_product_total_price();
            return;
        }

        try (Connection conn = DatabaseConnector.connectDatabase();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT price,bar_code FROM product WHERE product_name = ?")) {

            pstmt.setString(1, productName);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    double price = resultSet.getDouble("price");
                    productPriceNumberLabel.setText(String.format("%,.0f đ", price)); // Format with commas
                    String barCode = resultSet.getString("bar_code");
                    if (barCode != null) {
                        productBarCodeNumberLabel.setText(barCode);
                    }
                } else {
                    productPriceNumberLabel.setText("0");
                    JOptionPane.showMessageDialog(this,
                            "Không tìm thấy giá cho sản phẩm: " + productName,
                            "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Lỗi khi tải giá sản phẩm: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            productPriceNumberLabel.setText("0 đ");
        }
        calculate_cart_total_price();
    }                                                   

    private void quantityTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyReleased
        calculate_product_total_price();
    }//GEN-LAST:event_quantityTextFieldKeyReleased

    private void paidAmountTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountTextFieldKeyReleased
        calculate_cart_changes();
    }//GEN-LAST:event_paidAmountTextFieldKeyReleased

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        send_to_cart_database();
        send_to_sales_database();

        try {
            String inID = invoiceNumberLabel.getText();
            Statement statement = DatabaseConnector.connectDatabase().createStatement();

            // Sử dụng executeUpdate() thay vì executeQuery()
            statement.executeUpdate("UPDATE extra SET value = '"+inID+"'  WHERE extra_ID = 1");

            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Load mã hóa đơn trước

        // Tăng giá trị hóa đơn lên 1
        int i = Integer.parseInt(invoiceNumberLabel.getText());
        i++;
        invoiceNumberLabel.setText(String.valueOf(i));

    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductButton;
    private javax.swing.JPanel basePanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel changesLabel;
    private javax.swing.JLabel changesNumberLabel;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JComboBox<String> customerNameComboBox;
    private javax.swing.JTable dataTable;
    private javax.swing.JPanel invoiceLabel;
    private javax.swing.JLabel invoiceNumberLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel paidAmountLabel;
    private javax.swing.JTextField paidAmountTextField;
    private javax.swing.JLabel productBarCodeLabel;
    private javax.swing.JLabel productBarCodeNumberLabel;
    private javax.swing.JLabel productLabel;
    private javax.swing.JComboBox<String> productNameComboBox;
    private javax.swing.JLabel productPriceLabel;
    private javax.swing.JLabel productPriceNumberLabel;
    private javax.swing.JLabel productTotalPriceLabel;
    private javax.swing.JLabel productTotalPriceNumberLabel;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton removeAllButton;
    private javax.swing.JButton removeProductButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel totalAmountLabel;
    private javax.swing.JLabel totalAmountNumberLabel;
    private javax.swing.JLabel totalQuantityLabel;
    private javax.swing.JLabel totalQuantityNumberLabel;
    // End of variables declaration//GEN-END:variables
}
