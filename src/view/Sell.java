package view;

import controller.SellController;
import db.objects.Customer;
import db.objects.Product;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.ProductsModel;
import view.dialog.CustomersDialog;
import view.dialog.ProductsDialog;
import view.dialog.QuantityDialog;


public class Sell extends javax.swing.JPanel {
    private Customer currentCustomer;
    private Product currentProduct;
    
    // Chỗ các biến tính toán tiền thanh toán
    private int initialPrice = 0;
    private int voucherValue = 0;
    private int priceToPay = 0;
    
    public Sell() {
        initComponents();
    }
    
    public void setCurrentCustomer(Customer customer) {
        this.currentCustomer = customer;
        customerNameDisplay.setText(currentCustomer.getCustomerName());
        phoneDisplay.setText(currentCustomer.getPhone());
    }
    
    public void setCurrentProduct(Product product) {
        this.currentProduct = product;
    }
    
    public void renderRowTable(int quantity) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) productsTable.getModel();
        Object[] data = { currentProduct.getProductName(), currentProduct.getPrice() * quantity, quantity, currentProduct.getUnitPerQuantity() };
        defaultTableModel.addRow(data);
        setInitialPrice(currentProduct.getPrice() * quantity);
        currentProduct = null;
    }
    
    private void setInitialPrice(int value) {
        initialPrice += value;
        priceToPay = initialPrice - voucherValue;
        initialPriceDisplay.setText(initialPrice + "");
        priceToPayDisplay.setText(priceToPay + "");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        lblCustomId = new javax.swing.JLabel();
        lblNamedialog = new javax.swing.JLabel();
        lblNamedialog1 = new javax.swing.JLabel();
        lblNamedialog2 = new javax.swing.JLabel();
        btnchoosedialog = new javax.swing.JButton();
        btncanceldialog = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbPrivate = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        customerChooseInput = new javax.swing.JTextField();
        customerChooseOkBtn = new javax.swing.JButton();
        sellConfirmBtn = new javax.swing.JButton();
        customerNameDisplay = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        initialPriceDisplay = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        phoneDisplay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        priceToPayDisplay = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        voucherValueDisplay = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        productIDInput = new javax.swing.JTextField();
        productIDOkBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        productNameInput = new javax.swing.JTextField();
        productNameOkBtn = new javax.swing.JButton();
        voucherCodeInput = new javax.swing.JTextField();
        voucherCodeOkBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        lblCustomId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCustomId.setText("Result for: ");

        lblNamedialog.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNamedialog.setText("Son");

        lblNamedialog1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNamedialog1.setText("Customer ID:");

        lblNamedialog2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnchoosedialog.setBackground(new java.awt.Color(0, 255, 255));
        btnchoosedialog.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnchoosedialog.setText("Choose");
        btnchoosedialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchoosedialogActionPerformed(evt);
            }
        });

        btncanceldialog.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btncanceldialog.setText("Cancel");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ));
        jScrollPane7.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(btncanceldialog)
                .addGap(18, 18, 18)
                .addComponent(btnchoosedialog, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCustomId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNamedialog)
                        .addGap(216, 216, 216)
                        .addComponent(lblNamedialog1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNamedialog2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomId)
                    .addComponent(lblNamedialog)
                    .addComponent(lblNamedialog1)
                    .addComponent(lblNamedialog2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnchoosedialog)
                    .addComponent(btncanceldialog))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Voucher Code:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Private Voucher");

        cbPrivate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose voucher", "5%", "10%", "15%", "20%", "25%", "20%", "30%", "35%", "40%", "45%", "50%" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Initial Price:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setText("SELL");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Voucher Value:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Customer Name: ");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Price To Pay:");

        customerChooseOkBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        customerChooseOkBtn.setText("OK");
        customerChooseOkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleChooseCustomer(evt);
            }
        });

        sellConfirmBtn.setBackground(new java.awt.Color(0, 255, 255));
        sellConfirmBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sellConfirmBtn.setText("Sell");

        customerNameDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Choose Customer: ");

        initialPriceDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        initialPriceDisplay.setText("0 VNĐ");

        phoneDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Phone:");

        priceToPayDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceToPayDisplay.setText("0 VNĐ");

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "UnitPerQuantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productsTable);

        voucherValueDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        voucherValueDisplay.setText("0 VNĐ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Product ID:");

        productIDOkBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productIDOkBtn.setText("OK");
        productIDOkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleProductIDQuery(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Product Name:");

        productNameOkBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productNameOkBtn.setText("OK");
        productNameOkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameOkBtnActionPerformed(evt);
            }
        });

        voucherCodeOkBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        voucherCodeOkBtn.setText("OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerChooseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(customerChooseOkBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(productIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(productIDOkBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(productNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(productNameOkBtn))
                            .addComponent(jLabel6))
                        .addGap(114, 114, 114))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(voucherCodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(voucherCodeOkBtn))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(initialPriceDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(voucherValueDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceToPayDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPrivate, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sellConfirmBtn)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(customerChooseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(customerNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(phoneDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerChooseOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(productIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productNameOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(productIDOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(initialPriceDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voucherValueDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voucherCodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(voucherCodeOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPrivate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(priceToPayDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(sellConfirmBtn)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnchoosedialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchoosedialogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnchoosedialogActionPerformed

    private void handleChooseCustomer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleChooseCustomer
        String inputValue = customerChooseInput.getText();
        ArrayList<Customer> customers = SellController.getCustomersWithInput(inputValue);
        CustomersDialog dialog = new CustomersDialog(new javax.swing.JFrame(), true);
        dialog.renderResult(inputValue, customers, this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleChooseCustomer

    private void handleProductIDQuery(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleProductIDQuery
        int productIDEntered = Integer.parseInt(productIDInput.getText());
        currentProduct = ProductsModel.takeObject(new ProductsModel().selectWithCondition("ProductID = " + productIDEntered)).get(0);
        
        
        QuantityDialog dialog = new QuantityDialog(new javax.swing.JFrame(), true);
        dialog.getSell(this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
    }//GEN-LAST:event_handleProductIDQuery

    private void productNameOkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameOkBtnActionPerformed
        // TODO add your handling code here:
        String value = productNameInput.getText();
        ArrayList<Product> products = SellController.getProductsWithInput(value);
        ProductsDialog dialog = new ProductsDialog(new javax.swing.JFrame(), true);
        dialog.renderProduct(value, products, this);
        dialog.setLocationRelativeTo(null); 
        dialog.setVisible(true);
        
        
    }//GEN-LAST:event_productNameOkBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncanceldialog;
    private javax.swing.JButton btnchoosedialog;
    private javax.swing.JComboBox<String> cbPrivate;
    private javax.swing.JTextField customerChooseInput;
    private javax.swing.JButton customerChooseOkBtn;
    private javax.swing.JLabel customerNameDisplay;
    private javax.swing.JLabel initialPriceDisplay;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCustomId;
    private javax.swing.JLabel lblNamedialog;
    private javax.swing.JLabel lblNamedialog1;
    private javax.swing.JLabel lblNamedialog2;
    private javax.swing.JLabel phoneDisplay;
    private javax.swing.JLabel priceToPayDisplay;
    private javax.swing.JTextField productIDInput;
    private javax.swing.JButton productIDOkBtn;
    private javax.swing.JTextField productNameInput;
    private javax.swing.JButton productNameOkBtn;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton sellConfirmBtn;
    private javax.swing.JTextField voucherCodeInput;
    private javax.swing.JButton voucherCodeOkBtn;
    private javax.swing.JLabel voucherValueDisplay;
    // End of variables declaration//GEN-END:variables
}
