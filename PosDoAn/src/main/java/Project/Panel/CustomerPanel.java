
package Project.Panel;
public class CustomerPanel extends javax.swing.JPanel {
    public CustomerPanel() {
        initComponents();
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
        customerIDLabel = new javax.swing.JLabel();
        searchTxtField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        infomationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel.setText("Tên:");

        telephoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        telephoneNumberLabel.setText("SĐT:");

        nameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtFieldActionPerformed(evt);
            }
        });

        telephoneNumberTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneNumberTxtFieldActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\save.png")); // NOI18N
        saveButton.setText("Lưu");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
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
        informationLabel.setText("Thông tin khách hàng");

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
                    .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneNumberLabel)
                    .addComponent(telephoneNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Khách hàng", "Tên", "Số điên thoai"
            }
        ));
        jScrollPane1.setViewportView(dataTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchLabel1.setText("Tìm kiếm thông tin khách hàng");

        customerIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customerIDLabel.setText("ID Khách hàng:");

        searchTxtField.setText("nhâp ID khách để hiện thông tin");
        searchTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtFieldActionPerformed(evt);
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
                        .addComponent(customerIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchTxtField))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerIDLabel)
                    .addComponent(searchTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infomationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
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

    private void nameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtFieldActionPerformed

    private void telephoneNumberTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneNumberTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneNumberTxtFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void searchTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel customerIDLabel;
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
    private javax.swing.JLabel searchLabel1;
    private javax.swing.JTextField searchTxtField;
    private javax.swing.JLabel telephoneNumberLabel;
    private javax.swing.JTextField telephoneNumberTxtField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
