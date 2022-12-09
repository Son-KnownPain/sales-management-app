/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.VoucherController;
import db.objects.Customer;
import db.objects.Voucher;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import supports.NumberFormat;
import view.dialog.EditSupplierDialog;
import view.dialog.EditVoucherDialog;
import view.dialog.VoucherDialog;

/**
 *
 * @author PC HP
 */
public class VoucherView extends javax.swing.JPanel {

    private Voucher currentVoucher = null;

    /**
     * Creates new form VoucherView
     */
    public VoucherView() {
        initComponents();
    }

    
    public void setCurrentVoucher(Voucher voucher) {
        currentVoucher = voucher;
        displayVoucherInformation();
    }

    private void displayVoucherInformation() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        voucherCodeDisplay.setText(currentVoucher.getVoucherCode() + "");
        valueDisplay.setText(NumberFormat.getMoneyFormat(currentVoucher.getVoucherValue()));
        eventNameDisplay.setText(currentVoucher.getEventName());
        quantityDisplay.setText(NumberFormat.getMoneyFormat(currentVoucher.getQuantity()));
        dateDisplay.setText(formatter.format(currentVoucher.getCreateDate()) + "  - ");
        exprityDate.setText(formatter.format(currentVoucher.getExpiryDate()));
    }
    
    private void clearAddVoucher() {
        voucherCodeInput.setText("");
        valueInput.setText("");
        eventNameInput.setText("");
        quantityInput.setText("");
        createDateInput.setText("");
        expiryDateInput.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        voucherInput = new javax.swing.JTextField();
        chooseVoucherBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        dateDisplay = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        voucherCodeInput = new javax.swing.JTextField();
        valueInput = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        voucherCodeDisplay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        valueDisplay = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        eventNameDisplay = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        quantityDisplay = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        eventNameInput = new javax.swing.JTextField();
        quantityInput = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        createDateInput = new javax.swing.JTextField();
        expiryDateInput = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        exprityDate = new javax.swing.JLabel();

        voucherInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        chooseVoucherBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chooseVoucherBtn.setText("Choose voucher");
        chooseVoucherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseVoucherBtnActionPerformed(evt);
            }
        });

        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        dateDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateDisplay.setText("---");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(90, 90, 90));
        jLabel12.setText("Add voucher:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Voucher code:");

        voucherCodeInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        valueInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Value:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(90, 90, 90));
        jLabel15.setText("Voucher information: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Voucher code:");

        voucherCodeDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        voucherCodeDisplay.setText("---");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Value:");

        valueDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        valueDisplay.setText("---");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Event name:");

        eventNameDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eventNameDisplay.setText("---");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Quantity:");

        quantityDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        quantityDisplay.setText("---");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Date:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Event name:");

        eventNameInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        quantityInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Quantity:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Expiry date:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Create date:");

        createDateInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        expiryDateInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        exprityDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
                                        .addComponent(voucherCodeDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(valueDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(eventNameDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantityDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(dateDisplay)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(exprityDate, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel15))
                        .addGap(0, 417, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(voucherInput, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chooseVoucherBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(eventNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(voucherCodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(valueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(createDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(expiryDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18)))
                                    .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(voucherInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chooseVoucherBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(voucherCodeDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(valueDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(eventNameDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(quantityDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dateDisplay)
                    .addComponent(exprityDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voucherCodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(expiryDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chooseVoucherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseVoucherBtnActionPerformed
        if (voucherInput.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "can not be left blank", "Invalid value message", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        String valueInput = voucherInput.getText();
        ArrayList<Voucher> voucher = VoucherController.getVoucherWithInuput(valueInput);
        VoucherDialog dialog = new VoucherDialog(new javax.swing.JFrame(), true);
        dialog.renderVoucher(valueInput, voucher, this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_chooseVoucherBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
       if (currentVoucher == null) {
            JOptionPane.showMessageDialog(null, "Plase choose voucher");
            return;
        }
        
        EditVoucherDialog dialog = new EditVoucherDialog(new javax.swing.JFrame(), true);
        dialog.setCurrentVoucher(currentVoucher);
        dialog.setVoucherView(this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        dialog.setVisible(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String vCode = voucherCodeInput.getText();
        String vValue = valueInput.getText();
        String vEventName = eventNameInput.getText();
        String vQuantity = quantityInput.getText();
        String vCreateDate = createDateInput.getText();
        String vExpiryDate = expiryDateInput.getText();
        
        if(vCode.trim().isBlank() || vValue.trim().isBlank() || vEventName.trim().isBlank() || vQuantity.trim().isBlank() || vCreateDate.trim().isBlank() || vExpiryDate.trim().isBlank()){
            JOptionPane.showMessageDialog(null, "Inputs can not be empty");
            return;
        }
        
        if(!vCreateDate.matches("^(\\d{4})-(\\d{2})-(\\d{2})$") || !vExpiryDate.matches("^(\\d{4})-(\\d{2})-(\\d{2})$")){
            JOptionPane.showMessageDialog(null, "Enter the correct format yyyy-MM-dd");
            return;
        }
        
        boolean result = VoucherController.addVoucher(vCode, vValue, vEventName, vQuantity, vCreateDate, vExpiryDate);
        if(result){
            JOptionPane.showMessageDialog(null, "Add voucher successfully");
            clearAddVoucher();
        }
        else{
            JOptionPane.showMessageDialog(null, "Add failed, please check the information again !!");
        }
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton chooseVoucherBtn;
    private javax.swing.JTextField createDateInput;
    private javax.swing.JLabel dateDisplay;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel eventNameDisplay;
    private javax.swing.JTextField eventNameInput;
    private javax.swing.JTextField expiryDateInput;
    private javax.swing.JLabel exprityDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel quantityDisplay;
    private javax.swing.JTextField quantityInput;
    private javax.swing.JLabel valueDisplay;
    private javax.swing.JTextField valueInput;
    private javax.swing.JLabel voucherCodeDisplay;
    private javax.swing.JTextField voucherCodeInput;
    private javax.swing.JTextField voucherInput;
    // End of variables declaration//GEN-END:variables
}
