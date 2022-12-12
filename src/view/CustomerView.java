package view;

import controller.CustomerController;
import controller.GeneralController;
import db.objects.Customer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import supports.NumberFormat;
import view.dialog.BestCustomerDialog;
import view.dialog.CustomersDialog;
import view.dialog.DonateVoucherDialog;
import view.dialog.EditCustomerDialog;
import view.dialog.VoucherOfCustomerDialog;

public class CustomerView extends javax.swing.JPanel {

    private Customer currentCustomer = null;

    public CustomerView() {
        initComponents();
    }

    public void setCurrentCustomer(Customer customer) {
        currentCustomer = customer;
        displayCustomerInformation();
    }

    private void displayCustomerInformation() {
        idDisplay.setText(currentCustomer.getCustomerID() + "");
        nameDisplay.setText(currentCustomer.getCustomerName());
        phoneDisplay.setText(currentCustomer.getPhone());
        addressDisplay.setText(currentCustomer.getAddress());
        buyPointDislpay.setText(NumberFormat.getMoneyFormat(currentCustomer.getBuyPoint()));
    }

    private void clearAddInput() {
        nameInput.setText("");
        phoneInput.setText("");
        addressInput.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idDisplay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameDisplay = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phoneDisplay = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addressDisplay = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        buyPointDislpay = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        phoneInput = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        addressInput = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        customerInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Search Customers");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleEnterCustomer(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleShowEditDialog(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(90, 90, 90));
        jLabel1.setText("Private:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("ID:");

        idDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idDisplay.setText("---");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Name:");

        nameDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameDisplay.setText("---");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Phone: ");

        phoneDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phoneDisplay.setText("---");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Address: ");

        addressDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addressDisplay.setText("---");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Buy point:");

        buyPointDislpay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buyPointDislpay.setText("---");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(90, 90, 90));
        jLabel12.setText("Add customer:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Name:");

        nameInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        phoneInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Phone:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Address:");

        addressInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleAddCustomer(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(90, 90, 90));
        jLabel15.setText("Customer information: ");

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setText("View vouchers");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleViewVoucher(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setText("Best customer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleShowBestCustomer(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setText("Donate voucher");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleShowDonateVoucher(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(idDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(nameDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(phoneDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(addressDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(buyPointDislpay))))
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16)
                                                    .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel13))
                                                        .addGap(48, 48, 48)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel14)
                                                            .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(customerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel12))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customerInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(phoneDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(addressDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(buyPointDislpay))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void handleEnterCustomer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleEnterCustomer
        String customerInputValue = customerInput.getText();
        if (customerInputValue.trim().isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter customer name or phone!", "Message", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        ArrayList<Customer> customersList = GeneralController.getCustomersWithInput(customerInputValue);
        CustomersDialog dialog = new CustomersDialog(new javax.swing.JFrame(), true);
        dialog.renderResult(customerInputValue, customersList, this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleEnterCustomer

    private void handleShowEditDialog(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleShowEditDialog
        if (currentCustomer == null) {
            JOptionPane.showMessageDialog(null, "Please choose customer to edit");
            return;
        }
        EditCustomerDialog editDialog = new EditCustomerDialog(new javax.swing.JFrame(), true);
        editDialog.setCustomerBeEdit(currentCustomer);
        editDialog.setCustomerView(this);
        editDialog.setLocationRelativeTo(null);
        editDialog.setVisible(true);
    }//GEN-LAST:event_handleShowEditDialog

    private void handleAddCustomer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleAddCustomer
        String nameValue = nameInput.getText();
        String phoneValue = phoneInput.getText();
        String addressValue = addressInput.getText();

        if (nameValue.trim().isBlank() || phoneValue.trim().isBlank() || addressValue.trim().isBlank()) {
            JOptionPane.showMessageDialog(null, "Inputs can not be empty");
            return;
        }
        if (!phoneValue.matches("[0-9]{10}")) {
            JOptionPane.showMessageDialog(null, "Phone only accept ten numbers");
            return;
        }

        boolean result = CustomerController.addCustomer(nameValue, phoneValue, addressValue);
        if (result) {
            JOptionPane.showMessageDialog(null, "Add customer successfully");
            clearAddInput();
        } else {
            JOptionPane.showMessageDialog(null, "Add fail !!");
        }
    }//GEN-LAST:event_handleAddCustomer

    private void handleViewVoucher(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleViewVoucher
        if (currentCustomer == null) {
            JOptionPane.showMessageDialog(null, "Please choose customer");
            return;
        }
        ArrayList<String[]> data = CustomerController.getVoucherOfCustomer(currentCustomer.getCustomerID());
        VoucherOfCustomerDialog dialog = new VoucherOfCustomerDialog(new javax.swing.JFrame(), true);
        dialog.renderTable(data);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleViewVoucher

    private void handleShowDonateVoucher(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleShowDonateVoucher
        if (currentCustomer == null) {
            JOptionPane.showMessageDialog(null, "Please choose customer");
            return;
        }
        DonateVoucherDialog dialog = new DonateVoucherDialog(new javax.swing.JFrame(), true);
        dialog.setCustomerBeDonated(currentCustomer);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleShowDonateVoucher

    private void handleShowBestCustomer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleShowBestCustomer
        BestCustomerDialog dialog = new BestCustomerDialog(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleShowBestCustomer


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressDisplay;
    private javax.swing.JTextField addressInput;
    private javax.swing.JLabel buyPointDislpay;
    private javax.swing.JTextField customerInput;
    private javax.swing.JLabel idDisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nameDisplay;
    private javax.swing.JTextField nameInput;
    private javax.swing.JLabel phoneDisplay;
    private javax.swing.JTextField phoneInput;
    // End of variables declaration//GEN-END:variables
}
