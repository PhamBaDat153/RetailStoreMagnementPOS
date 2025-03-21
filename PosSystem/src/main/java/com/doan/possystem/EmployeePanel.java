/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.doan.possystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.zip.Deflater;

/**
 *
 * @author phamb
 */
public class EmployeePanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerPanel
     */
    public EmployeePanel() {
        initComponents();
        loadTable();
    }

    public void loadTable(){
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            Statement statement = Database.myCon().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employee");

            //Kiểm tra xem nếu trong csdl còn dữ liệu thì thêm vào bảng
            while (rs.next()){
                model.addRow(new Object[]{rs.getString("ID"),rs.getString("name"),rs.getString("SDT"),rs.getString("position")});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emp_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emp_name = new javax.swing.JTextField();
        emp_sdt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        emp_position = new javax.swing.JTextField();
        emp_Search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "SDT", "Chức vụ"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("Thông tin nhân viên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã ID:");

        emp_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_IDActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên:");

        emp_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_nameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("SDT:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosSystem\\src\\main\\resources\\image\\save.png")); // NOI18N
        jButton1.setText("Lưu");
        jButton1.setIconTextGap(5);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosSystem\\src\\main\\resources\\image\\search x30.png")); // NOI18N
        jButton2.setText("Tìm");
        jButton2.setIconTextGap(5);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosSystem\\src\\main\\resources\\image\\update.png")); // NOI18N
        jButton3.setText("Cập nhật");
        jButton3.setIconTextGap(5);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosSystem\\src\\main\\resources\\image\\delete.png")); // NOI18N
        jButton4.setText("Xóa");
        jButton4.setIconTextGap(5);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Chức vụ:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emp_ID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(emp_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emp_position, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emp_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emp_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emp_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        emp_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_SearchActionPerformed(evt);
            }

            private void emp_SearchActionPerformed(ActionEvent evt) {
            }
        });
        emp_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emp_SearchKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Lọc tên nhân viên:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emp_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(emp_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void emp_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Thêm nhân viên mới vào csdl
        String name = emp_name.getText();
        String sdt = emp_sdt.getText();
        String position = emp_position.getText();

        try {
            // Kiểm tra người dùng đã nhập dữ liệu chưa
            if (name.equals("") || sdt.equals("") || position.equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên, SDT và chức vụ");
                return;
            }
            if (sdt.length() != 10) {
                JOptionPane.showMessageDialog(null, "SDT phải bao gồm 10 số");
                return;
            }

            Statement statement = Database.myCon().createStatement();
            statement.executeUpdate("INSERT INTO employee(name,SDT,position) VALUES ('"+name+"','"+sdt+"','"+position+"')");
            JOptionPane.showMessageDialog(null, "Thêm nhân viên "+name+" với SDT: "+sdt+" thành công");

        }catch (Exception e){
            System.out.println(e);
        }
        // Reload table mỗi khi thực hiện hành động mới
        loadTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Tìm kiếm nhân viên
        String search = emp_ID.getText();

        try {
            // Kiểm tra người dùng đã nhập dữ liệu chưa
            if (search.equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập ID nhân viên để tìm kiếm");
                return;
            }

            Statement statement = Database.myCon().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employee WHERE ID LIKE '%"+search+"%'");

            if (rs.next()) {
                emp_name.setText(rs.getString("name"));
                emp_sdt.setText(rs.getString("SDT"));
                emp_position.setText(rs.getString("position"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void emp_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_IDActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Cập nhật thông tin nhân viên
        String name = emp_name.getText();
        String sdt = emp_sdt.getText();
        String id = emp_ID.getText();
        String position = emp_position.getText();

        try {

            // Kiểm tra người dùng đã nhập dữ liệu chưa
            if (name.equals("") || sdt.equals("") || position.equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên, SDT và chức vụ");
                return;
            }
            if (sdt.length() != 10) {
                JOptionPane.showMessageDialog(null, "SDT phải bao gồm 10 số");
                return;
            }
            else if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập ID nhân viên để cập nhật");
                return;
            }

            Statement statement = Database.myCon().createStatement();
            statement.executeUpdate("UPDATE employee SET name = '"+name+"', SDT = '"+sdt+"', position = '"+position+"' WHERE ID = '"+id+"'");
            JOptionPane.showMessageDialog(null, "Câp nhật nhân viên với ID: "+id+" thành công");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Reload table mỗi khi thực hiện hành động mới
        loadTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Xóa nhân viên
        String id = emp_ID.getText();

        try {
            // Kiểm tra người dùng đã nhập dữ liệu chưa
            if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập ID nhân viên để xóa");
            }

            Statement statement = Database.myCon().createStatement();
            statement.executeUpdate("DELETE FROM employee WHERE ID = '"+id+"'");
            JOptionPane.showMessageDialog(null, "Xóa nhân viên với ID: "+id+" thành công");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Reload table mỗi khi thực hiện hành động mới
        loadTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Nhấp chuột vào bảng để chuyển dữ liệu sang textfields
        int row = jTable1.getSelectedRow();
        String id = jTable1.getModel().getValueAt(row, 0).toString();
        String name = jTable1.getModel().getValueAt(row, 1).toString();
        String sdt = jTable1.getModel().getValueAt(row, 2).toString();
        emp_ID.setText(id);
        emp_name.setText(name);
        emp_sdt.setText(sdt);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void emp_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emp_SearchKeyReleased
        //tìm kiếm thông tin nhân viên thông qua Bảng
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            Statement statement = Database.myCon().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employee WHERE name LIKE '%"+emp_Search.getText()+"%'");
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("name");
                String sdt = rs.getString("SDT");
                String position = rs.getString("position");
                model.addRow(new Object[]{id, name, sdt});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_emp_SearchKeyReleased

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emp_ID;
    private javax.swing.JTextField emp_Search;
    private javax.swing.JTextField emp_name;
    private javax.swing.JTextField emp_position;
    private javax.swing.JTextField emp_sdt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
