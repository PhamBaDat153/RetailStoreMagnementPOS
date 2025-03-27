/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Project.Panel;

import Project.Database.DatabaseConnector;

import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class InvoicePanel extends javax.swing.JPanel {
    public InvoicePanel() {
        initComponents();
        loadData();
    }
    @SuppressWarnings("unchecked")
    private void loadData() {

        try {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            Statement statement = DatabaseConnector.connectDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sales");
            model.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm dòng mới
            while (resultSet.next()) {
                Vector vector = new Vector();
                vector.add(resultSet.getString(1));
                vector.add(resultSet.getString(2));
                vector.add(resultSet.getString(3));
                vector.add(resultSet.getString(4));
                vector.add(resultSet.getString(5));
                vector.add(resultSet.getString(6));
                vector.add(resultSet.getString(7));
                vector.add(resultSet.getString(8));
                model.addRow(vector);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void searchPara(){
        try (Connection conn = DatabaseConnector.connectDatabase();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM sales WHERE invoice_ID LIKE ? AND customer_name LIKE ? AND status LIKE ?")) {

            String invoiceID = invoiceTextField.getText().trim();
            String customerName = customerNameTextField.getText().trim();
            String status = statusComboBox.getSelectedItem().toString().trim();

            // Nếu ô nhập rỗng, dùng "%" để tìm kiếm tất cả, nếu không thêm % để tìm kiếm 1 phần
            stmt.setString(1, invoiceID.isEmpty() ? "%" : "%" + invoiceID + "%");
            stmt.setString(2, customerName.isEmpty() ? "%" : "%" + customerName + "%");
            stmt.setString(3, status.isEmpty() ? "%" : status);

            ResultSet resultSet = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm dòng mới

            // Lấy số cột từ ResultSetMetaData để duyệt đúng số cột
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                ArrayList<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {  // Đúng số cột
                    rowData.add(resultSet.getObject(i));
                }
                model.addRow(rowData.toArray());
            }

        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi chi tiết để dễ debug
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        invoiceLabel = new javax.swing.JLabel();
        invoiceTextField = new javax.swing.JTextField();
        customerNameLabel = new javax.swing.JLabel();
        customerNameTextField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        refreshButton = new javax.swing.JButton();
        invoiceLabelinfo = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Số hóa đơn", "Mã khách hàng", "Tên khách hàng", "Tổng số lượng SP", "Tổng giá trị", "Trạng thái", "Thừa/Thiếu"
            }
        ));
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        invoiceLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        invoiceLabel.setText("Số hóa đơn:");

        invoiceTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                invoiceTextFieldKeyReleased(evt);
            }
        });

        customerNameLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        customerNameLabel.setText("Tên khách hàng:");

        customerNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerNameTextFieldKeyReleased(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        statusLabel.setText("Trạng thái hóa đơn");

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chưa thanh toán" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        refreshButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\loading-arrow.png")); // NOI18N
        refreshButton.setText("refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        invoiceLabelinfo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        invoiceLabelinfo.setText("Lọc hóa đơn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(invoiceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invoiceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshButton)
                        .addGap(197, 197, 197))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(invoiceLabelinfo)
                        .addGap(1226, 1226, 1226))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(invoiceLabelinfo)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerNameLabel)
                    .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshButton)
                    .addComponent(invoiceLabel))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1188, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(KeyEvent evt) {
    }


    private void customerNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerNameTextFieldKeyReleased
        searchPara();
    }//GEN-LAST:event_customerNameTextFieldKeyReleased

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        searchPara();
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void invoiceTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoiceTextFieldKeyReleased
        searchPara();
    }//GEN-LAST:event_invoiceTextFieldKeyReleased

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        loadData();
    }//GEN-LAST:event_refreshButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JTextField customerNameTextField;
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel invoiceLabel;
    private javax.swing.JLabel invoiceLabelinfo;
    private javax.swing.JTextField invoiceTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
