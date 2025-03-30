
package Project.Panel;

import Project.Database.DatabaseConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ProductPanel extends javax.swing.JPanel {
    public ProductPanel() {
        initComponents();
        loadTable();
    }

    // Hàm tạo ID mới
    private String generateNewId(Connection conn) throws SQLException {
        String sql = "SELECT CONCAT('SP', LPAD(COALESCE(MAX(CAST(SUBSTRING(product_ID, 3) AS UNSIGNED)), 0) + 1, 7, '0')) FROM product";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.next() ? rs.getString(1) : "SP0000001";
        }
    }

    //Hàm load table
    private void loadTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            model.setRowCount(0);
            Statement statement = DatabaseConnector.connectDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getString("product_ID"),
                        resultSet.getString("product_name"),
                        resultSet.getString("bar_code"),
                        resultSet.getString("price"),
                        resultSet.getString("quantity"),
                        resultSet.getString("supplier_ID")

                };
                model.addRow(row);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        infomationPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        barCodeLabel = new javax.swing.JLabel();
        nameTxtField = new javax.swing.JTextField();
        barCodeTxtField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        informationLabel = new javax.swing.JLabel();
        priceTxtField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        quantityTxtField = new javax.swing.JTextField();
        supplierIDTxtField = new javax.swing.JTextField();
        suplplierIDLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        productIDLabel = new javax.swing.JLabel();
        searchByIDTxtField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchByNameTxtField = new javax.swing.JTextField();
        customerNameSearchLabel = new javax.swing.JLabel();

        basePanel.setBackground(new java.awt.Color(48, 56, 65));
        basePanel.setForeground(new java.awt.Color(48, 56, 65));

        infomationPanel.setBackground(new java.awt.Color(238, 238, 238));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(48, 56, 65));
        nameLabel.setText("Tên:");

        barCodeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        barCodeLabel.setForeground(new java.awt.Color(48, 56, 65));
        barCodeLabel.setText("Mã vạch:");

        nameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtFieldActionPerformed(evt);
            }

            private void nameTxtFieldActionPerformed(ActionEvent evt) {
            }
        });

        barCodeTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barCodeTxtFieldActionPerformed(evt);
            }

            private void barCodeTxtFieldActionPerformed(ActionEvent evt) {
            }
        });

        saveButton.setBackground(new java.awt.Color(0, 173, 181));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(238, 238, 238));
        saveButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\save.png")); // NOI18N
        saveButton.setText("Lưu");
        saveButton.setFocusable(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    saveButtonActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        deleteButton.setBackground(new java.awt.Color(0, 173, 181));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(238, 238, 238));
        deleteButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\delete.png")); // NOI18N
        deleteButton.setText("Xóa");
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(0, 173, 181));
        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(238, 238, 238));
        updateButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\update.png")); // NOI18N
        updateButton.setText("Cập nhât");
        updateButton.setFocusable(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        informationLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        informationLabel.setForeground(new java.awt.Color(48, 56, 65));
        informationLabel.setText("Thông tin sản phẩm");

        priceTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTxtFieldActionPerformed(evt);
            }

            private void priceTxtFieldActionPerformed(ActionEvent evt) {
            }
        });

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(48, 56, 65));
        quantityLabel.setText("Số lượng:");

        priceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(48, 56, 65));
        priceLabel.setText("Giá:");

        quantityTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTxtFieldActionPerformed(evt);
            }
        });

        supplierIDTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierIDTxtFieldActionPerformed(evt);
            }
        });

        suplplierIDLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        suplplierIDLabel1.setForeground(new java.awt.Color(48, 56, 65));
        suplplierIDLabel1.setText("ID NCU:");

        javax.swing.GroupLayout infomationPanelLayout = new javax.swing.GroupLayout(infomationPanel);
        infomationPanel.setLayout(infomationPanelLayout);
        infomationPanelLayout.setHorizontalGroup(
            infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infomationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infomationPanelLayout.createSequentialGroup()
                        .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel)
                            .addComponent(priceLabel)
                            .addComponent(barCodeLabel)
                            .addComponent(quantityLabel)
                            .addComponent(suplplierIDLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(barCodeTxtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(quantityTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceTxtField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTxtField)
                            .addComponent(supplierIDTxtField)))
                    .addComponent(informationLabel)
                    .addGroup(infomationPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infomationPanelLayout.setVerticalGroup(
            infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infomationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barCodeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barCodeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel))
                .addGap(16, 16, 16)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suplplierIDLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        dataTable.setBackground(new java.awt.Color(238, 238, 238));
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID sản phẩm", "Tên", "Mã vạch", "Giá", "Số lượng", "ID NCU"
            }
        ));
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataTable);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        searchLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchLabel.setForeground(new java.awt.Color(48, 56, 65));
        searchLabel.setText("Tìm kiếm thông tin sản phẩm");

        productIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productIDLabel.setForeground(new java.awt.Color(48, 56, 65));
        productIDLabel.setText("ID sản phẩm:");

        searchByIDTxtField.setText("nhâp ID sản phẩm để hiện thông tin");
        searchByIDTxtField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchByIDTxtFieldMouseClicked(evt);
            }
        });
        searchByIDTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIDTxtFieldActionPerformed(evt);
            }

            private void searchByIDTxtFieldActionPerformed(ActionEvent evt) {
            }
        });

        searchButton.setBackground(new java.awt.Color(0, 173, 181));
        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(238, 238, 238));
        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\search x30.png")); // NOI18N
        searchButton.setText("Tìm");
        searchButton.setFocusable(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchByIDTxtField))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productIDLabel)
                    .addComponent(searchByIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        searchByNameTxtField.setText("nhâp tên sản phẩm để lọc thông tin");
        searchByNameTxtField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchByNameTxtFieldMouseClicked(evt);
            }
        });
        searchByNameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNameTxtFieldActionPerformed(evt);
            }

            private void searchByNameTxtFieldActionPerformed(ActionEvent evt) {
            }
        });
        searchByNameTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchByNameTxtFieldKeyReleased(evt);
            }
        });

        customerNameSearchLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customerNameSearchLabel.setForeground(new java.awt.Color(238, 238, 238));
        customerNameSearchLabel.setText("Lọc tên :");

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infomationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addComponent(customerNameSearchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchByNameTxtField))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
                .addContainerGap())
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, basePanelLayout.createSequentialGroup()
                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchByNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerNameSearchLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infomationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_saveButtonActionPerformed
        // Lưu thông tin sản phẩm vào csdl
        String name = nameTxtField.getText().trim();
        String barCode = barCodeTxtField.getText().trim();
        String price = priceTxtField.getText().trim();
        String quantity = quantityTxtField.getText().trim();
        String supplier = supplierIDTxtField.getText().trim();

// Kiểm tra dữ liệu đầu vào
        if (name.isEmpty() || barCode.isEmpty() || price.isEmpty() || quantity.isEmpty() || supplier.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return;
        }

// kiểm tra numeric fields
        try {
            double priceValue = Double.parseDouble(price);
            int quantityValue = Integer.parseInt(quantity);
            if (priceValue <= 0 || quantityValue < 0) {
                JOptionPane.showMessageDialog(null, "Giá và số lượng phải là số dương");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá và số lượng phải là số hợp lệ");
            return;
        }

        try (Connection conn = DatabaseConnector.connectDatabase()) {
            // Kiểm tra nhà cung cấp tồn tại
            String checkSupplierSql = "SELECT supplier_ID FROM supplier WHERE supplier_ID = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSupplierSql)) {
                checkStmt.setString(1, supplier);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp với mã: " + supplier);
                        return;
                    }
                }
            }

            // Kiểm tra mã vạch trùng
            String checkBarcodeSql = "SELECT product_ID FROM product WHERE bar_code = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkBarcodeSql)) {
                checkStmt.setString(1, barCode);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Mã vạch đã tồn tại trong hệ thống");
                        return;
                    }
                }
            }

            // Thêm sản phẩm mới
            String insertSql = "INSERT INTO product (product_ID, product_name, bar_code, price, quantity, supplier_ID) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                // Tạo ID mới
                String newId = generateNewId(conn);

                pstmt.setString(1, newId);
                pstmt.setString(2, name);
                pstmt.setString(3, barCode);
                pstmt.setDouble(4, Double.parseDouble(price));
                pstmt.setInt(5, Integer.parseInt(quantity));
                pstmt.setString(6, supplier);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công! Mã SP: " + newId);
                }
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Lỗi: Thông tin sản phẩm bị trùng lặp");
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm sản phẩm: " + e.getMessage());
            }
            e.printStackTrace();
        }
        loadTable();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // Tìm kiếm thông tin dựa vào ID
        String id = searchByIDTxtField.getText().trim();

        // Kiểm tra dữ liệu đầu vào
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sản phẩm để tìm kiếm");
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = DatabaseConnector.connectDatabase();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * FROM product WHERE product_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                nameTxtField.setText(resultSet.getString("product_name"));
                barCodeTxtField.setText(resultSet.getString("bar_code"));
                priceTxtField.setText(resultSet.getString("price"));
                quantityTxtField.setText(resultSet.getString("quantity"));
                supplierIDTxtField.setText(resultSet.getString("supplier_ID"));
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm với mã: " + id);
                // Xóa các trường nếu không tìm thấy
                nameTxtField.setText("");
                barCodeTxtField.setText("");
                priceTxtField.setText("");
                quantityTxtField.setText("");
                supplierIDTxtField.setText("");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm sản phẩm: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // Xóa thông tin
        // Lấy mã cần xóa
        String Id = searchByIDTxtField.getText().trim();

        // Validate dữ liệu
        if (Id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm cần xóa",
                    "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Xác nhận trước khi xóa
        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa sản phẩm " + Id + "?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnector.connectDatabase();

            // Kiểm tra tồn tại khách hàng trước khi xóa
            String checkSql = "SELECT product_name FROM product WHERE product_ID = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, Id);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm với mã: " + Id,
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String customerName = rs.getString("employee_name");

            // Thực hiện xóa
            String deleteSql = "DELETE FROM product WHERE product_ID = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, Id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Đã xóa thành công sản phẩm: " + customerName,
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
                // Clear các trường nhập liệu sau khi xóa
                searchByIDTxtField.setText("");
                nameTxtField.setText("");
                barCodeTxtField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Không thể xóa sản phẩm",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            // Kiểm tra nếu có ràng buộc khóa ngoại
            if (e.getMessage().contains("a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(this, "Không thể xóa vì sản phẩm đã có dữ liệu liên quan",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa nhân viên: " + e.getMessage(),
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        loadTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // Cập nhật thông tin sản phẩm
        String id = searchByIDTxtField.getText().trim();
        String name = nameTxtField.getText().trim();
        String barCode = barCodeTxtField.getText().trim();
        String price = priceTxtField.getText().trim();
        String quantity = quantityTxtField.getText().trim();
        String supplier = supplierIDTxtField.getText().trim();

// Kiểm tra dữ liệu
        if (id.isEmpty() || name.isEmpty() || barCode.isEmpty() || price.isEmpty() || quantity.isEmpty() || supplier.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Validate numeric fields
        try {
            double priceValue = Double.parseDouble(price);
            int quantityValue = Integer.parseInt(quantity);
            if (priceValue <= 0 || quantityValue < 0) {
                JOptionPane.showMessageDialog(this, "Giá và số lượng phải là số dương", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá và số lượng phải là số hợp lệ", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = DatabaseConnector.connectDatabase()) {
            // Kiểm tra sản phẩm tồn tại
            String checkSql = "SELECT product_name FROM product WHERE product_ID = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setString(1, id);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm với mã: " + id,
                                "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // Kiểm tra nhà cung cấp tồn tại
            String checkSupplierSql = "SELECT supplier_ID FROM supplier WHERE supplier_ID = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSupplierSql)) {
                checkStmt.setString(1, supplier);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung cấp với mã: " + supplier,
                                "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // Kiểm tra mã vạch không trùng (trừ sản phẩm hiện tại)
            String checkBarcodeSql = "SELECT product_ID FROM product WHERE bar_code = ? AND product_ID != ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkBarcodeSql)) {
                checkStmt.setString(1, barCode);
                checkStmt.setString(2, id);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Mã vạch đã tồn tại cho sản phẩm khác",
                                "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // Cập nhật thông tin sản phẩm
            String updateSql = "UPDATE product SET " +
                    "product_name = ?, " +
                    "bar_code = ?, " +
                    "price = ?, " +
                    "quantity = ?, " +
                    "supplier_ID = ? " +
                    "WHERE product_ID = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, barCode);
                pstmt.setDouble(3, Double.parseDouble(price));
                pstmt.setInt(4, Integer.parseInt(quantity));
                pstmt.setString(5, supplier);
                pstmt.setString(6, id);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin sản phẩm thành công!",
                            "Thành công", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể cập nhật thông tin",
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật sản phẩm: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        loadTable();
    }//GEN-LAST:event_updateButtonActionPerformed


    private void searchByIDTxtFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchByIDTxtFieldMouseClicked
       // xóa chữ khi nhấp vào
        searchByIDTxtField.setText("");
    }//GEN-LAST:event_searchByIDTxtFieldMouseClicked

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        // đưa dữa liệu vào textFields khi click vào bảng
        int row = dataTable.getSelectedRow();
        if (row >= 0) {
            searchByIDTxtField.setText(dataTable.getValueAt(row, 0).toString());
            nameTxtField.setText(dataTable.getValueAt(row, 1).toString());
            barCodeTxtField.setText(dataTable.getValueAt(row, 2).toString());
            priceTxtField.setText(dataTable.getValueAt(row, 3).toString());
            quantityTxtField.setText(dataTable.getValueAt(row, 4).toString());
            supplierIDTxtField.setText(dataTable.getValueAt(row, 5).toString());
        }
    }//GEN-LAST:event_dataTableMouseClicked

    private void searchByNameTxtFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchByNameTxtFieldMouseClicked
       // xóa chữ khi nhấp vào
        searchByNameTxtField.setText("");
    }//GEN-LAST:event_searchByNameTxtFieldMouseClicked

    private void searchByNameTxtFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchByNameTxtFieldKeyReleased
        // nhập tên để lọc bảng
        try {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            Statement statement = DatabaseConnector.connectDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT product_ID, product_name,bar_code, price, quantity, supplier_ID FROM product WHERE product_name LIKE '%" + searchByNameTxtField.getText() + "%'");
            model.setRowCount(0);
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("product_ID"), resultSet.getString("product_name"), resultSet.getString("bar_code"), resultSet.getString("price"), resultSet.getString("quantity"), resultSet.getString("supplier_ID")});
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_searchByNameTxtFieldKeyReleased

    private void quantityTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtFieldActionPerformed

    private void supplierIDTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierIDTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierIDTxtFieldActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barCodeLabel;
    private javax.swing.JTextField barCodeTxtField;
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel customerNameSearchLabel;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel infomationPanel;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTxtField;
    private javax.swing.JLabel productIDLabel;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTxtField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchByIDTxtField;
    private javax.swing.JTextField searchByNameTxtField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JLabel suplplierIDLabel1;
    private javax.swing.JTextField supplierIDTxtField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
