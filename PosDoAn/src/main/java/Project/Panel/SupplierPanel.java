
package Project.Panel;

import Project.Database.DatabaseConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.*;

public class SupplierPanel extends javax.swing.JPanel {
    public SupplierPanel() {
        initComponents();
        loadTable();
    }

    // Hàm tạo ID mới
    private String generateNewId(Connection conn) throws SQLException {
        String sql = "SELECT CONCAT('NCU', LPAD(COALESCE(MAX(CAST(SUBSTRING(supplier_ID, 3) AS UNSIGNED)), 0) + 1, 7, '0')) FROM supplier";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.next() ? rs.getString(1) : "NCU0000001";
        }
    }

    //Hàm load table
    private void loadTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            model.setRowCount(0);
            Statement statement = DatabaseConnector.connectDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM supplier");
            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getString("supplier_ID"),
                        resultSet.getString("supplier_name"),
                        resultSet.getString("telephone_number")
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
        telephoneNumberLabel = new javax.swing.JLabel();
        nameTxtField = new javax.swing.JTextField();
        telephoneNumberTxtField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        informationLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        searchLabel1 = new javax.swing.JLabel();
        supplierIDLabel = new javax.swing.JLabel();
        searchByIDTxtField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchByNameTxtField = new javax.swing.JTextField();
        customerNameSearchLabel = new javax.swing.JLabel();

        basePanel.setBackground(new java.awt.Color(58, 71, 80));

        infomationPanel.setBackground(new java.awt.Color(238, 238, 238));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel.setText("Tên:");

        telephoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        telephoneNumberLabel.setText("SĐT:");

        nameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtFieldActionPerformed(evt);
            }

            private void nameTxtFieldActionPerformed(ActionEvent evt) {
            }
        });

        telephoneNumberTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneNumberTxtFieldActionPerformed(evt);
            }

            private void telephoneNumberTxtFieldActionPerformed(ActionEvent evt) {
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
        informationLabel.setText("Thông tin nhà cung ứng");

        javax.swing.GroupLayout infomationPanelLayout = new javax.swing.GroupLayout(infomationPanel);
        infomationPanel.setLayout(infomationPanelLayout);
        infomationPanelLayout.setHorizontalGroup(
            infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infomationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationLabel)
                    .addGroup(infomationPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infomationPanelLayout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infomationPanelLayout.createSequentialGroup()
                                .addComponent(telephoneNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(infomationPanelLayout.createSequentialGroup()
                                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteButton))
                                    .addComponent(telephoneNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infomationPanelLayout.setVerticalGroup(
            infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infomationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneNumberLabel)
                    .addComponent(telephoneNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        dataTable.setBackground(new java.awt.Color(238, 238, 238));
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID nhà cung ứng", "Tên", "Số điên thoại"
            }
        ));
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataTable);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        searchLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchLabel1.setText("Tìm kiếm thông tin nhà cung ứng");

        supplierIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        supplierIDLabel.setText("ID NCU:");

        searchByIDTxtField.setText("nhâp ID nhà cung ứng để hiện thông tin");
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
                    .addComponent(searchLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(supplierIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchByIDTxtField))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierIDLabel)
                    .addComponent(searchByIDTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        searchByNameTxtField.setText("nhâp tên nhà cung ứng để lọc thông tin");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addComponent(customerNameSearchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchByNameTxtField)))
                .addContainerGap())
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchByNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerNameSearchLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infomationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        // Lưu thông tin vào csdl
        String name = nameTxtField.getText().trim();
        String telephoneNumber = telephoneNumberTxtField.getText().trim();

        // Kiểm tra dữ liệu đầu vào
        if (name.isEmpty() || telephoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return;
        }
        else if (telephoneNumber.length() != 10) {
            JOptionPane.showMessageDialog(this, "SĐT phải bao gồm 10 chữ số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        else if(!telephoneNumber.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại chỉ được chứa chữ số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Connection conn = null;
        Statement statement = null;

        try {
            conn = DatabaseConnector.connectDatabase();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "INSERT INTO supplier (supplier_ID, supplier_name, telephone_number) VALUES (?, ?, ?)";

            // Tạo customer_ID mới
            String newId = generateNewId(conn);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newId);
            pstmt.setString(2, name);
            pstmt.setString(3, telephoneNumber);

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm nhà cung ứng thành công");

        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("telephone_number")) {
                JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại trong hệ thống");
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhà cung ứng: " + e.getMessage());
            }
            e.printStackTrace();
        } finally {
            // Đóng kết nối và statement
            try {
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        loadTable();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // Tìm kiếm thông tin dựa vào ID
        String id = searchByIDTxtField.getText().trim();

        // Kiểm tra dữ liệu đầu vào
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhà cung ứng để tìm kiếm");
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = DatabaseConnector.connectDatabase();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * FROM supplier WHERE supplier_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                nameTxtField.setText(resultSet.getString("supplier_name"));
                telephoneNumberTxtField.setText(resultSet.getString("telephone_number"));
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung ứng với mã: " + id);
                // Xóa các trường nếu không tìm thấy
                nameTxtField.setText("");
                telephoneNumberTxtField.setText("");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm nhà cung ứng: " + e.getMessage());
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
            JOptionPane.showMessageDialog(this, "Vui lòng nhập nhà cung ứng hàng cần xóa",
                    "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Xác nhận trước khi xóa
        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa nhà cung ứng " + Id + "?",
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
            String checkSql = "SELECT supplier_name FROM supplier WHERE supplier_ID = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, Id);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung ứng với mã: " + Id,
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String customerName = rs.getString("customer_name");

            // Thực hiện xóa
            String deleteSql = "DELETE FROM supplier WHERE supplier_ID = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, Id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Đã xóa thành công nhà cung ứng: " + customerName,
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
                // Clear các trường nhập liệu sau khi xóa
                searchByIDTxtField.setText("");
                nameTxtField.setText("");
                telephoneNumberTxtField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Không thể xóa nhà cung ứng",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            // Kiểm tra nếu có ràng buộc khóa ngoại
            if (e.getMessage().contains("a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(this, "Không thể xóa vì nhà cung ứng đã có dữ liệu liên quan",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa nhà cung ứng: " + e.getMessage(),
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
            //Cập nhật thông tin.
            // Lấy thông tin từ các trường nhập liệu
            String Id = searchByIDTxtField.getText().trim();
            String name = nameTxtField.getText().trim();
            String phone = telephoneNumberTxtField.getText().trim();

            // Kiểm tra dữ liệu
            if (Id.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
           else if (phone.length() != 10) {
               JOptionPane.showMessageDialog(this, "SĐT phải bao gồm 10 chữ số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
               return;
           }

            else if(!phone.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại chỉ được chứa chữ số", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = DatabaseConnector.connectDatabase();

                // Kiểm tra xem nhà cung ứng có tồn tại không
                String checkSql = "SELECT 1 FROM supplier WHERE supplier_ID = ?";
                pstmt = conn.prepareStatement(checkSql);
                pstmt.setString(1, Id);
                ResultSet rs = pstmt.executeQuery();

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung ứng với mã: " + Id,
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Cập nhật thông tin
                String updateSql = "UPDATE supplier SET supplier_name = ?, telephone_number = ? WHERE supplier_ID = ?";
                pstmt = conn.prepareStatement(updateSql);
                pstmt.setString(1, name);
                pstmt.setString(2, phone);
                pstmt.setString(3, Id);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công!",
                            "Thành công", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể cập nhật thông tin",
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("telephone_number")) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại trong hệ thống",
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật: " + e.getMessage(),
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
            telephoneNumberTxtField.setText(dataTable.getValueAt(row, 2).toString());
        }
    }//GEN-LAST:event_dataTableMouseClicked

    private void searchByNameTxtFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchByNameTxtFieldMouseClicked
       // xóa chữ khi nhấp vào
        searchByNameTxtField.setText("");
    }//GEN-LAST:event_searchByNameTxtFieldMouseClicked

    private void searchByNameTxtFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchByNameTxtFieldKeyReleased
        // nhập tên nhà cung ứng để lọc bảng
        try {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            Statement statement = DatabaseConnector.connectDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT supplier_ID, supplier_name, telephone_number FROM supplier WHERE supplier_name LIKE '%" + searchByNameTxtField.getText() + "%'");
            model.setRowCount(0);
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("supplier_ID"), resultSet.getString("supplier_name"), resultSet.getString("telephone_number")});
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_searchByNameTxtFieldKeyReleased




    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchByIDTxtField;
    private javax.swing.JTextField searchByNameTxtField;
    private javax.swing.JLabel searchLabel1;
    private javax.swing.JLabel supplierIDLabel;
    private javax.swing.JLabel telephoneNumberLabel;
    private javax.swing.JTextField telephoneNumberTxtField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
