package view;

import db.objects.Supplier;
import javax.swing.JOptionPane;
import view.dialog.EditSupplierDialog;
import view.dialog.SupplierDialog;

public class SupplierView extends javax.swing.JPanel {
    private Supplier currentSupplier = null;

    public SupplierView() {
        initComponents();
    }
    
    public void setCurrentSupplier(Supplier supplier) {
        this.currentSupplier = supplier;
        displaySupplierInformation();
    }
    
    private void displaySupplierInformation() {
        if (currentSupplier != null) {
            idDisplay.setText(currentSupplier.getSupplierID() + "");
            companyNameDisplay.setText(currentSupplier.getCompanyName());
            addressDisplay.setText(currentSupplier.getAddress());
            phoneDisplay.setText(currentSupplier.getPhone());
            emailDisplay.setText(currentSupplier.getEmail());
            postalCodeDisplay.setText(currentSupplier.getPostalCode());
        }
    }

    // -----------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        idDisplay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        companyNameDisplay = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addressDisplay = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        phoneDisplay = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        chooseSupplierBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        emailDisplay = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        postalCodeDisplay = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        postalCodeInput = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        addressInput = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        companyNameInput = new javax.swing.JTextField();
        phoneInput = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("ID:");

        idDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idDisplay.setText("---");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Company name:");

        companyNameDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        companyNameDisplay.setText("---");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Address:");

        addressDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addressDisplay.setText("---");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Phone: ");

        phoneDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phoneDisplay.setText("---");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Email:");

        chooseSupplierBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chooseSupplierBtn.setText("Choose supplier");
        chooseSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleChooseSupplier(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleEditSupplier(evt);
            }
        });

        emailDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailDisplay.setText("---");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(90, 90, 90));
        jLabel15.setText("Supplier information: ");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("Postal code:");

        postalCodeDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        postalCodeDisplay.setText("---");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Email:");

        emailInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        postalCodeInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Postal code:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Address:");

        addressInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(90, 90, 90));
        jLabel12.setText("Add supplier:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Company name:");

        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleAddSupplier(evt);
            }
        });

        companyNameInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        phoneInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Phone:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chooseSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12)
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
                                        .addComponent(companyNameDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(addressDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(phoneDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(emailDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(postalCodeDisplay))
                                    .addComponent(jLabel19)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(companyNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(addressInput, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel16))
                                                .addGap(41, 41, 41)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel17)
                                                    .addComponent(postalCodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(companyNameDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(addressDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(phoneDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(emailDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(postalCodeDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalCodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(addressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void handleChooseSupplier(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleChooseSupplier
        SupplierDialog dialog = new SupplierDialog(new javax.swing.JFrame(), true);
        dialog.setSupplierView(this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleChooseSupplier

    private void handleAddSupplier(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleAddSupplier
        
    }//GEN-LAST:event_handleAddSupplier

    private void handleEditSupplier(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleEditSupplier
        if (currentSupplier == null) {
            JOptionPane.showMessageDialog(null, "Plase choose supplier");
            return;
        }
        EditSupplierDialog dialog = new EditSupplierDialog(new javax.swing.JFrame(), true);
        dialog.setCurrentSupplier(currentSupplier);
        dialog.setSupplierView(this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleEditSupplier


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel addressDisplay;
    private javax.swing.JTextField addressInput;
    private javax.swing.JButton chooseSupplierBtn;
    private javax.swing.JLabel companyNameDisplay;
    private javax.swing.JTextField companyNameInput;
    private javax.swing.JLabel emailDisplay;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel idDisplay;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel phoneDisplay;
    private javax.swing.JTextField phoneInput;
    private javax.swing.JLabel postalCodeDisplay;
    private javax.swing.JTextField postalCodeInput;
    // End of variables declaration//GEN-END:variables
}
