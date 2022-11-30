package view;

import controller.SellController;

import db.objects.Customer;
import db.objects.Product;
import db.objects.Voucher;
import db.objects.VoucherOfCustomer;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import static javax.swing.JOptionPane.showMessageDialog;
import supports.Convert;

import supports.MoneyFormat;

import view.dialog.CustomersDialog;
import view.dialog.OrderSell;
import view.dialog.ProductsDialog;
import view.dialog.QuantityDialog;

public class SellView extends javax.swing.JPanel {

    private Customer currentCustomer = null;
    private Product currentProduct = null;
    private Voucher currentVoucher = null;

    // HashMap save the id and quantity of the selected product and if you 
    //choose the same product as last time, you will check if there is enough in 
    //stock to get it and if it is not enough, it will not be taken
    HashMap<Integer, Integer> selectedProduct = new HashMap<>();

    // Chỗ các biến tính toán tiền thanh toán
    private int initialPrice = 0;
    private int voucherValue = 0;
    private int priceToPay = 0;

    // Có phải là voucher riêng của khách hàng không
    private boolean isVoucherOfCustomer = false;

    public SellView() {
        initComponents();
    }
    

    public void renderRowTable(int quantity) {
        int quantityOfProductExist = 0;
        boolean isContainsKey = false;
        if (selectedProduct.containsKey(currentProduct.getProductID())) {
            quantityOfProductExist = selectedProduct.get(currentProduct.getProductID());
            isContainsKey = true;
        }
        if ((quantity + quantityOfProductExist) > currentProduct.getQuantityInStore()) {
            showMessageDialog(null, "The quantity entered cannot be greater than the quantity in the store", "Message", JOptionPane.PLAIN_MESSAGE);
            currentProduct = null;
            return;
        } else if (!isContainsKey) {
            selectedProduct.put(currentProduct.getProductID(), quantity);
            DefaultTableModel defaultTableModel = (DefaultTableModel) productsTable.getModel();
            Object[] data = {currentProduct.getProductName(), MoneyFormat.getMoneyFormat(currentProduct.getPrice() * quantity), quantity, currentProduct.getUnitPerQuantity()};
            defaultTableModel.addRow(data);
            setInitialPrice(currentProduct.getPrice() * quantity);
        } else {
            int row = 0;
            for (int keyID : selectedProduct.keySet()) {
                if (keyID == currentProduct.getProductID()) {
                    break;
                }
                row++;
            }
            int newQuantity = quantity + quantityOfProductExist;
            selectedProduct.put(currentProduct.getProductID(), newQuantity);
            productsTable.setValueAt(newQuantity * currentProduct.getPrice(), row, 1);
            productsTable.setValueAt(newQuantity, row, 2);
            setInitialPrice(currentProduct.getPrice() * quantity);
        }

        currentProduct = null;
       
    }

    private void renderVoucherOfCustomer() {
        optionsVoucher.removeAllItems();
        optionsVoucher.addItem("Choose Voucher");
        ArrayList<VoucherOfCustomer> listVoucherOfCustomer = SellController.getVouchersOfCustomer(currentCustomer);
        for (VoucherOfCustomer voucherOfCustomer : listVoucherOfCustomer) {
            if (voucherOfCustomer.getQuantity() <= 0) {
                continue;
            }
            optionsVoucher.addItem(voucherOfCustomer.getVoucherCode());
           
        }
    }

    // Set current object method
    public void setCurrentCustomer(Customer customer) {
        this.currentCustomer = customer;
        if (currentCustomer == null) {
            customerNameDisplay.setText("");
            phoneDisplay.setText("");
            return;
        }
        customerNameDisplay.setText(currentCustomer.getCustomerName());
        phoneDisplay.setText(currentCustomer.getPhone());
        renderVoucherOfCustomer();
    }

    public void setCurrentProduct(Product product) {
        this.currentProduct = product;
    }

    private void setCurrentVoucher(Voucher voucher) {
        this.currentVoucher = voucher;
        
        LocalDate now = LocalDate.now();
        LocalDate createDate;
        LocalDate expiryDate;
        
        
        
        if (voucher == null) {
            voucherCodeDisplay.setText("No Voucher");
            return;
        } else {
            createDate = Convert.toLocalDate(currentVoucher.getCreateDate());
            expiryDate = Convert.toLocalDate(currentVoucher.getExpiryDate());
        }
        if (now.compareTo(createDate) >= 0 && now.compareTo(expiryDate) <= 0) {
            voucherCodeDisplay.setText(currentVoucher.getVoucherCode());
            setVoucherValue(currentVoucher.getVoucherValue());
        } else {
            if (now.compareTo(createDate) < 0) {
                showMessageDialog(null, "Voucher can only be used on " + createDate.toString(), "Voucher Invalid Message", JOptionPane.PLAIN_MESSAGE);
            }
            if (now.compareTo(expiryDate) > 0) {
                showMessageDialog(null, "Voucher has expired", "Voucher Invalid Message", JOptionPane.PLAIN_MESSAGE);
            }
            this.currentVoucher = null;
        }
    }

    private void setInitialPrice(int value) {
        initialPrice += value;
        priceToPay = initialPrice - voucherValue;
        changeAndDisplayPrice();
    }

    private void setVoucherValue(int value) {
        voucherValue = value;
        priceToPay = initialPrice - voucherValue;
        changeAndDisplayPrice();
    }

    private void changeAndDisplayPrice() {
        initialPriceDisplay.setText(MoneyFormat.getMoneyFormat(initialPrice) + " VNĐ");
        voucherValueDisplay.setText(MoneyFormat.getMoneyFormat(voucherValue) + " VNĐ");
        priceToPayDisplay.setText(priceToPay < 0 ? 0 + " VNĐ" : MoneyFormat.getMoneyFormat(priceToPay) + " VNĐ");
    }

    // Get
    private int getProductIDByIndex(int index) {
        int i = 0;
        for (int keyID : selectedProduct.keySet()) {
            if (i == index) {
                return keyID;
            }
            i++;
        }
        return -1;
    }

    // Clear all information
    private void clearAllInformation() {
        setCurrentCustomer(null);
        setCurrentVoucher(null);
        initialPrice = 0;
        setVoucherValue(0);
        optionsVoucher.removeAllItems();
        optionsVoucher.addItem("Choose Voucher");

        DefaultTableModel producDefaultTableModel = (DefaultTableModel) productsTable.getModel();
        producDefaultTableModel.setRowCount(0);
        selectedProduct.clear();
        customerChooseInput.setText("");
        productIDInput.setText("");
        productNameInput.setText("");
        voucherCodeInput.setText("");
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
        optionsVoucher = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        customerChooseInput = new javax.swing.JTextField();
        customerChooseOkBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
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
        sellConfirmBtn1 = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        privareVoucherCancelBtn = new javax.swing.JButton();
        voucherCodeDisplay = new javax.swing.JLabel();

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
        jLabel7.setText("Voucher:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Private Voucher");

        optionsVoucher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Voucher" }));
        optionsVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleChooseVoucherOfCustomer(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Initial Price:");

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

        deleteBtn.setBackground(new java.awt.Color(255, 102, 51));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleDeleteProduct(evt);
            }
        });

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
                false, false, false, false
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
        voucherCodeOkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleApplyVoucher(evt);
            }
        });

        sellConfirmBtn1.setBackground(new java.awt.Color(0, 255, 255));
        sellConfirmBtn1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sellConfirmBtn1.setText("Sell");
        sellConfirmBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleSell(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(255, 153, 51));
        clearBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleClearForm(evt);
            }
        });

        privareVoucherCancelBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        privareVoucherCancelBtn.setText("Cancel");
        privareVoucherCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleCancelVoucher(evt);
            }
        });

        voucherCodeDisplay.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        voucherCodeDisplay.setForeground(new java.awt.Color(250, 30, 214));
        voucherCodeDisplay.setText("No Voucher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(customerChooseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(customerChooseOkBtn)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customerNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
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
                        .addGap(94, 94, 94))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(voucherCodeDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(voucherCodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(voucherCodeOkBtn))
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(optionsVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(privareVoucherCancelBtn)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(initialPriceDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(voucherValueDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceToPayDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBtn)
                                .addGap(18, 18, 18)
                                .addComponent(clearBtn)
                                .addGap(109, 109, 109))))))
            .addComponent(jScrollPane1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(622, Short.MAX_VALUE)
                    .addComponent(sellConfirmBtn1)
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addComponent(customerChooseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(customerNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(phoneDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(customerChooseOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(productIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(productIDOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productNameOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(voucherCodeDisplay))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voucherCodeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(voucherCodeOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(optionsVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(privareVoucherCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(initialPriceDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voucherValueDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(priceToPayDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteBtn)
                            .addComponent(clearBtn))
                        .addGap(17, 17, 17))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(593, Short.MAX_VALUE)
                    .addComponent(sellConfirmBtn1)
                    .addGap(16, 16, 16)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnchoosedialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchoosedialogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnchoosedialogActionPerformed

    private void handleChooseCustomer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleChooseCustomer
        if (customerChooseInput.getText().equals("")) {
            return;
        }
        String inputValue = customerChooseInput.getText();
        ArrayList<Customer> customers = SellController.getCustomersWithInput(inputValue);
        CustomersDialog dialog = new CustomersDialog(new javax.swing.JFrame(), true);
        dialog.renderResult(inputValue, customers, this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleChooseCustomer

    private void handleProductIDQuery(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleProductIDQuery
        if (productIDInput.getText().equals("")) {
            return;
        } else if (!productIDInput.getText().matches("[0-9]+")) {
            showMessageDialog(null, "Please enter number", "Invalid value message", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        int productIDEntered = Integer.parseInt(productIDInput.getText());
        currentProduct = SellController.getProductByID(productIDEntered);

        if (currentProduct == null) {
            showMessageDialog(null, "ID does not exist", "Message", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        QuantityDialog dialog = new QuantityDialog(new javax.swing.JFrame(), true);
        dialog.getSell(this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }//GEN-LAST:event_handleProductIDQuery

    private void productNameOkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameOkBtnActionPerformed
        if (productNameInput.getText().equals("")) {
            return;
        }
        String value = productNameInput.getText();
        ArrayList<Product> products = SellController.getProductsWithInput(value);
        ProductsDialog dialog = new ProductsDialog(new javax.swing.JFrame(), true);
        dialog.renderProduct(value, products, this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);


    }//GEN-LAST:event_productNameOkBtnActionPerformed


    private void handleApplyVoucher(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleApplyVoucher
        String voucherCode = voucherCodeInput.getText();
        Voucher voucher = SellController.getVoucher(voucherCode);
        if (voucher == null) {
            showMessageDialog(null, "Voucher code is incorrect", "Message", JOptionPane.PLAIN_MESSAGE);
        } else if (voucher.getQuantity() > 0) {
            setCurrentVoucher(voucher);
            isVoucherOfCustomer = false;
        } else {
            showMessageDialog(null, "Quantity is out", "Message", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_handleApplyVoucher

    private void handleCancelVoucher(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleCancelVoucher
        setCurrentVoucher(null);
        setVoucherValue(0);
    }//GEN-LAST:event_handleCancelVoucher

    private void handleDeleteProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleDeleteProduct
        int viewIndex = productsTable.getSelectedRow();

        if (viewIndex != -1) {
            //  Xóa dữ liệu lưu trữ quantity ở HashMap và set lại giá tiền
            int productID = getProductIDByIndex(viewIndex);
            selectedProduct.remove(productID);
            setInitialPrice(-Integer.parseInt(String.join("", (productsTable.getValueAt(viewIndex, 1) + "").split("[.]"))));

            int modelIndex = productsTable.convertColumnIndexToModel(viewIndex);
            DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
            model.removeRow(modelIndex);
        }
    }//GEN-LAST:event_handleDeleteProduct

    private void handleClearForm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleClearForm
        clearAllInformation();
    }//GEN-LAST:event_handleClearForm

    private void handleChooseVoucherOfCustomer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleChooseVoucherOfCustomer
        String voucherCodeSelecting = (String) optionsVoucher.getSelectedItem();
        if (voucherCodeSelecting == null || voucherCodeSelecting.equals("Choose Voucher")) {
            return;
        }
        isVoucherOfCustomer = true;
        Voucher voucher = SellController.getVoucher(voucherCodeSelecting);
        setCurrentVoucher(voucher);
    }//GEN-LAST:event_handleChooseVoucherOfCustomer

    private void handleSell(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleSell
        if (currentCustomer == null || selectedProduct.isEmpty()) {
            return;
        }
        boolean sellResult = SellController.sellOne(currentCustomer, currentVoucher, selectedProduct, isVoucherOfCustomer, priceToPay);
        if (sellResult) {
            OrderSell dialog = new OrderSell(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setInformation(
                    currentCustomer.getCustomerName(), 
                    currentCustomer.getPhone(), 
                    voucherValue, 
                    initialPrice, 
                    priceToPay,
                    currentCustomer.getBuyPoint()
            );
            dialog.setVisible(true);
            clearAllInformation();
        } else {
            showMessageDialog(null, "Fail to sell", "Message", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_handleSell


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncanceldialog;
    private javax.swing.JButton btnchoosedialog;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField customerChooseInput;
    private javax.swing.JButton customerChooseOkBtn;
    private javax.swing.JLabel customerNameDisplay;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel initialPriceDisplay;
    private javax.swing.JDialog jDialog2;
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
    private javax.swing.JComboBox<String> optionsVoucher;
    private javax.swing.JLabel phoneDisplay;
    private javax.swing.JLabel priceToPayDisplay;
    private javax.swing.JButton privareVoucherCancelBtn;
    private javax.swing.JTextField productIDInput;
    private javax.swing.JButton productIDOkBtn;
    private javax.swing.JTextField productNameInput;
    private javax.swing.JButton productNameOkBtn;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton sellConfirmBtn1;
    private javax.swing.JLabel voucherCodeDisplay;
    private javax.swing.JTextField voucherCodeInput;
    private javax.swing.JButton voucherCodeOkBtn;
    private javax.swing.JLabel voucherValueDisplay;
    // End of variables declaration//GEN-END:variables
}
