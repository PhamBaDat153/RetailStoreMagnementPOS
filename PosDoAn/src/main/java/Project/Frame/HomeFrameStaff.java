
package Project.Frame;

import Project.Function.JpanelLoader;
import Project.Panel.*;

import java.sql.SQLException;

public class HomeFrameStaff extends javax.swing.JFrame {

    public JpanelLoader jPanelLoader = new JpanelLoader();

    public HomeFrameStaff() {
        initComponents();
        this.setExtendedState(HomeFrameStaff.MAXIMIZED_BOTH);
        this.setTitle("GreenStore POS");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homeFrameButtonGroup = new javax.swing.ButtonGroup();
        buttonHolderPanel = new javax.swing.JPanel();
        customerPanelLoadButton = new javax.swing.JToggleButton();
        SupplierPanelLoadButton = new javax.swing.JToggleButton();
        ProductPanelLoadButton = new javax.swing.JToggleButton();
        SalesPanelLoadButton = new javax.swing.JToggleButton();
        InvoicePanelLoadButton = new javax.swing.JToggleButton();
        panelLoaderPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonHolderPanel.setBackground(new java.awt.Color(58, 71, 80));

        customerPanelLoadButton.setBackground(new java.awt.Color(238, 238, 238));
        homeFrameButtonGroup.add(customerPanelLoadButton);
        customerPanelLoadButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customerPanelLoadButton.setForeground(new java.awt.Color(48, 56, 65));
        customerPanelLoadButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\customer.png")); // NOI18N
        customerPanelLoadButton.setText("Khách hàng");
        customerPanelLoadButton.setAlignmentY(0.0F);
        customerPanelLoadButton.setFocusable(false);
        customerPanelLoadButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        customerPanelLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerPanelLoadButtonActionPerformed(evt);
            }
        });

        SupplierPanelLoadButton.setBackground(new java.awt.Color(238, 238, 238));
        homeFrameButtonGroup.add(SupplierPanelLoadButton);
        SupplierPanelLoadButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SupplierPanelLoadButton.setForeground(new java.awt.Color(48, 56, 65));
        SupplierPanelLoadButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\supplier.png")); // NOI18N
        SupplierPanelLoadButton.setText("Nhà cung ứng");
        SupplierPanelLoadButton.setAlignmentY(0.0F);
        SupplierPanelLoadButton.setFocusable(false);
        SupplierPanelLoadButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SupplierPanelLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierPanelLoadButtonActionPerformed(evt);
            }
        });

        ProductPanelLoadButton.setBackground(new java.awt.Color(238, 238, 238));
        homeFrameButtonGroup.add(ProductPanelLoadButton);
        ProductPanelLoadButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ProductPanelLoadButton.setForeground(new java.awt.Color(48, 56, 65));
        ProductPanelLoadButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\product.png")); // NOI18N
        ProductPanelLoadButton.setText("Sản phẩm");
        ProductPanelLoadButton.setAlignmentY(0.0F);
        ProductPanelLoadButton.setFocusable(false);
        ProductPanelLoadButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ProductPanelLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductPanelLoadButtonActionPerformed(evt);
            }
        });

        SalesPanelLoadButton.setBackground(new java.awt.Color(238, 238, 238));
        homeFrameButtonGroup.add(SalesPanelLoadButton);
        SalesPanelLoadButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SalesPanelLoadButton.setForeground(new java.awt.Color(48, 56, 65));
        SalesPanelLoadButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\sales_menu.png")); // NOI18N
        SalesPanelLoadButton.setText("Giỏ hàng");
        SalesPanelLoadButton.setAlignmentY(0.0F);
        SalesPanelLoadButton.setFocusable(false);
        SalesPanelLoadButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SalesPanelLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesPanelLoadButtonActionPerformed(evt);
            }
        });

        InvoicePanelLoadButton.setBackground(new java.awt.Color(238, 238, 238));
        homeFrameButtonGroup.add(InvoicePanelLoadButton);
        InvoicePanelLoadButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InvoicePanelLoadButton.setForeground(new java.awt.Color(48, 56, 65));
        InvoicePanelLoadButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\phamb\\OneDrive\\Documents\\GitHub\\RetailStoreMagnementPOS\\PosDoAn\\src\\main\\resources\\Images\\invo.png")); // NOI18N
        InvoicePanelLoadButton.setText("Hóa đơn");
        InvoicePanelLoadButton.setAlignmentY(0.0F);
        InvoicePanelLoadButton.setFocusable(false);
        InvoicePanelLoadButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InvoicePanelLoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    InvoicePanelLoadButtonActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout buttonHolderPanelLayout = new javax.swing.GroupLayout(buttonHolderPanel);
        buttonHolderPanel.setLayout(buttonHolderPanelLayout);
        buttonHolderPanelLayout.setHorizontalGroup(
            buttonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonHolderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SupplierPanelLoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerPanelLoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProductPanelLoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SalesPanelLoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InvoicePanelLoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonHolderPanelLayout.setVerticalGroup(
            buttonHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonHolderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerPanelLoadButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SupplierPanelLoadButton)
                .addGap(7, 7, 7)
                .addComponent(InvoicePanelLoadButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProductPanelLoadButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SalesPanelLoadButton)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        panelLoaderPanel.setBackground(new java.awt.Color(58, 71, 80));

        javax.swing.GroupLayout panelLoaderPanelLayout = new javax.swing.GroupLayout(panelLoaderPanel);
        panelLoaderPanel.setLayout(panelLoaderPanelLayout);
        panelLoaderPanelLayout.setHorizontalGroup(
            panelLoaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        panelLoaderPanelLayout.setVerticalGroup(
            panelLoaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 173, 181));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(238, 238, 238));
        jLabel2.setText("GreenStore Pos system");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(238, 238, 238));
        jLabel1.setText("GreenStore Pos system");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelLoaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(343, 343, 343)
                    .addComponent(jLabel1)
                    .addContainerGap(343, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLoaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(212, 212, 212)
                    .addComponent(jLabel1)
                    .addContainerGap(213, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProductPanelLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductPanelLoadButtonActionPerformed
        // đưa trang sản phẩm lên HomeFrame
        ProductPanel productPanel = new ProductPanel();
        jPanelLoader.load(panelLoaderPanel,productPanel);
    }//GEN-LAST:event_ProductPanelLoadButtonActionPerformed

    private void customerPanelLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerPanelLoadButtonActionPerformed
        // đưa trang khách hàng lên HomeFrame
        CustomerPanel customerPanel = new CustomerPanel();
        jPanelLoader.load(panelLoaderPanel,customerPanel);
    }//GEN-LAST:event_customerPanelLoadButtonActionPerformed

    private void SupplierPanelLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierPanelLoadButtonActionPerformed
        // đưa trang nhà cung ứng lên Homeframe
        SupplierPanel supplierPanel = new SupplierPanel();
        jPanelLoader.load(panelLoaderPanel,supplierPanel);
    }//GEN-LAST:event_SupplierPanelLoadButtonActionPerformed

    private void SalesPanelLoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesPanelLoadButtonActionPerformed
        // đưa trang giỏ hàng lên HomeFrame
        SalesPanel salesPanel = new SalesPanel();
        jPanelLoader.load(panelLoaderPanel,salesPanel);
    }//GEN-LAST:event_SalesPanelLoadButtonActionPerformed

    private void InvoicePanelLoadButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_InvoicePanelLoadButtonActionPerformed
        // đưa trang hóa đơn lên HomeFrame
        InvoicePanel invoicePanel = new InvoicePanel();
        jPanelLoader.load(panelLoaderPanel,invoicePanel);
    }//GEN-LAST:event_InvoicePanelLoadButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton InvoicePanelLoadButton;
    private javax.swing.JToggleButton ProductPanelLoadButton;
    private javax.swing.JToggleButton SalesPanelLoadButton;
    private javax.swing.JToggleButton SupplierPanelLoadButton;
    private javax.swing.JPanel buttonHolderPanel;
    private javax.swing.JToggleButton customerPanelLoadButton;
    private javax.swing.ButtonGroup homeFrameButtonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelLoaderPanel;
    // End of variables declaration//GEN-END:variables
}
