
package Project.Panel;

import Project.Database.DatabaseConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.*;

public class EmployeePanel extends javax.swing.JPanel {
    public EmployeePanel() {
        initComponents();
        loadTable();
    }

    // Hàm tạo ID mới
    private String generateNewId(Connection conn) throws SQLException {
        String sql = "SELECT CONCAT('NV', LPAD(COALESCE(MAX(CAST(SUBSTRING(employee_ID, 3) AS UNSIGNED)), 0) + 1, 7, '0')) FROM employee";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.next() ? rs.getString(1) : "NV0000001";
        }
    }

    //Hàm load table
    private void loadTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            model.setRowCount(0);
            Statement statement = DatabaseConnector.connectDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getString("employee_ID"),
                        resultSet.getString("employee_name"),
                        resultSet.getString("telephone_number"),
                        resultSet.getString("position"),
                        resultSet.getString("password")

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
        passwordTxtField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        PositionLabel = new javax.swing.JLabel();
        positionComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        searchLabel1 = new javax.swing.JLabel();
        supplierIDLabel = new javax.swing.JLabel();
        searchByIDTxtField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        searchByNameTxtField = new javax.swing.JTextField();
        customerNameSearchLabel = new javax.swing.JLabel();

        infomationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\save.png")); // NOI18N
        saveButton.setText("Lưu");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    saveButtonActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\delete.png")); // NOI18N
        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\update.png")); // NOI18N
        updateButton.setText("Cập nhât");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        informationLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        informationLabel.setText("Thông tin nhà cung ứng");


        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordLabel.setText("MK:");

        PositionLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PositionLabel.setText("Vị trí:");

        positionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Tạp vụ", "Thu ngân" }));

        javax.swing.GroupLayout infomationPanelLayout = new javax.swing.GroupLayout(infomationPanel);
        infomationPanel.setLayout(infomationPanelLayout);
        infomationPanelLayout.setHorizontalGroup(
            infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infomationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infomationPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infomationPanelLayout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infomationPanelLayout.createSequentialGroup()
                                .addComponent(PositionLabel)
                                .addGap(18, 18, 18)
                                .addComponent(positionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infomationPanelLayout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(infomationPanelLayout.createSequentialGroup()
                                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteButton))
                                    .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(infomationPanelLayout.createSequentialGroup()
                                .addComponent(telephoneNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telephoneNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(informationLabel))
                .addContainerGap(8, Short.MAX_VALUE))
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
                .addGap(14, 14, 14)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PositionLabel)
                    .addComponent(positionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID nhân viên", "Tên", "Số điên thoại", "Vị trí", "Mật khẩu"
            }
        ));
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchLabel1.setText("Tìm kiếm thông tin nhân viên");

        supplierIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        supplierIDLabel.setText("ID Nhân viên:");

        searchByIDTxtField.setText("nhâp ID nhân viên để hiện thông tin");
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

        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\search x30.png")); // NOI18N
        searchButton.setText("Tìm");
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

        searchByNameTxtField.setText("nhâp tên nhân viên để lọc thông tin");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
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
        String password = passwordTxtField.getText().trim();
        String position = positionComboBox.getSelectedItem().toString().trim();

        // Kiểm tra dữ liệu đầu vào
        if (name.isEmpty() || telephoneNumber.isEmpty() || password.isEmpty()) {
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
            String sql = "INSERT INTO employee (employee_ID, employee_name, telephone_number, password, position) VALUES (?, ?, ?, ?, ?)";

            // Tạo customer_ID mới
            String newId = generateNewId(conn);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newId);
            pstmt.setString(2, name);
            pstmt.setString(3, telephoneNumber);
            pstmt.setString(4, password);
            pstmt.setString(5, position);

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");

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
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhân viên để tìm kiếm");
            return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = DatabaseConnector.connectDatabase();

            // Sử dụng PreparedStatement để tránh SQL injection
            String sql = "SELECT * FROM employee WHERE employee_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                nameTxtField.setText(resultSet.getString("employee_ID"));
                telephoneNumberTxtField.setText(resultSet.getString("telephone_number"));
                positionComboBox.setToolTipText(resultSet.getString("position"));
                passwordTxtField.setText(resultSet.getString("password"));
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên với mã: " + id);
                // Xóa các trường nếu không tìm thấy
                nameTxtField.setText("");
                telephoneNumberTxtField.setText("");
                positionComboBox.setToolTipText("");
                passwordTxtField.setText("");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm nhân viên: " + e.getMessage());
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
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên cần xóa",
                    "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Xác nhận trước khi xóa
        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa nhân viên " + Id + "?",
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
            String checkSql = "SELECT employee_name FROM employee WHERE employee_ID = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, Id);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với mã: " + Id,
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String customerName = rs.getString("employee_name");

            // Thực hiện xóa
            String deleteSql = "DELETE FROM employee WHERE employee_ID = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, Id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Đã xóa thành công nhân viên: " + customerName,
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
                // Clear các trường nhập liệu sau khi xóa
                searchByIDTxtField.setText("");
                nameTxtField.setText("");
                telephoneNumberTxtField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Không thể xóa nhân viên",
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            // Kiểm tra nếu có ràng buộc khóa ngoại
            if (e.getMessage().contains("a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(this, "Không thể xóa vì nhân viên đã có dữ liệu liên quan",
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
        // Cập nhật thông tin nhân viên
        String Id = searchByIDTxtField.getText().trim();
        String name = nameTxtField.getText().trim();
        String phone = telephoneNumberTxtField.getText().trim();
        String position = positionComboBox.getSelectedItem().toString().trim();
        String password = passwordTxtField.getText().trim();

// Kiểm tra dữ liệu
        if (Id.isEmpty() || name.isEmpty() || phone.isEmpty() || password.isEmpty()) {
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

            // Kiểm tra tồn tại nhân viên
            String checkSql = "SELECT 1 FROM employee WHERE employee_ID = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, Id);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với mã: " + Id,
                        "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cập nhật thông tin
            String updateSql = "UPDATE employee SET employee_name = ?, telephone_number = ?, position = ?, password = ? WHERE employee_ID = ?";
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, position);  // Đã sửa từ vị trí 4 về 3
            pstmt.setString(4, password);  // Đã sửa từ vị trí 5 về 4
            pstmt.setString(5, Id);        // Đã sửa từ vị trí 3 về 5

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
            positionComboBox.setSelectedItem(dataTable.getValueAt(row, 3).toString());
            passwordTxtField.setText(dataTable.getValueAt(row, 4).toString());
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
            ResultSet resultSet = statement.executeQuery("SELECT employee_ID, employee_name, telephone_number, position, password FROM employee WHERE employee_name LIKE '%" + searchByNameTxtField.getText() + "%'");
            model.setRowCount(0);
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("employee_ID"), resultSet.getString("employee_name"), resultSet.getString("telephone_number"), resultSet.getString("position"), resultSet.getString("password")});
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_searchByNameTxtFieldKeyReleased




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PositionLabel;
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
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTxtField;
    private javax.swing.JComboBox<String> positionComboBox;
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
