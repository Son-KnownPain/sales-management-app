package view;

import controller.GeneralController;
import controller.ImportController;
import db.objects.Product;
import db.objects.Supplier;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import model.ProductsModel;
import supports.NumberFormat;
import view.dialog.EditProductImportDailog;
import view.dialog.ProductsDialog;
import view.dialog.QuantityDialog;

public class ImportView extends javax.swing.JPanel {

    private Product currentProduct = null;
    private int currentQuantity = 0;
    private Supplier currentSupplier = null;
    private int currentTotalPrice = 0;
    private int currentDiscount = 0;

    private int initialPrice = 0;
    private int totalDiscount = 0;
    private int priceToPay = 0;

    public ImportView() {
        initComponents();
    }
    
    /**
     * 1. productIds để chứa các productID theo thứ tự
     * 2. selectedProduct là lưu trữ số lượng sản phẩm theo id sản phẩm
     * 3. supplierOfProduct là lưu trữ id nhà cung cấp theo id sản phẩm
     * 4. discount tương tự là lưu discount của mỗi sản phẩm
     * 5. totalPrice tương tự
     */

    // ArrayList chứa product id
    ArrayList<Integer> productIds = new ArrayList<>();

    // Lưu các sản phẩm đã hiển thị trên table rồi
    HashMap<Integer, Integer> selectedProduct = new HashMap<>();

    // Lưu nhà cung cấp của 1 sản phẩm (productID, supplierID)
    HashMap<Integer, Integer> supplierOfProduct = new HashMap<>();

    // Lưu discount của 1 sản phảm (productID, giá trị discount)
    HashMap<Integer, Integer> discountsOfProduct = new HashMap<>();

    // Lưu tổng giá của 1 sản phẩm (productID, giá)
    HashMap<Integer, Integer> totalPriceOfProduct = new HashMap<>();

    public boolean setCurrProduct(Product product) {
        currentProduct = product;
        boolean isSelectedProduct = selectedProduct.containsKey(currentProduct.getProductID());
        if (isSelectedProduct) {
            currentProduct = null;
        }
        return isSelectedProduct;
    }

    public void setCurrentQuantity(int quantity) {
        this.currentQuantity = quantity;
    }

    public void setCurrentSupplier(Supplier supplier) {
        currentSupplier = supplier;
    }

    public void setCurrentTotalPrice(int currentTotalPrice) {
        this.currentTotalPrice = currentTotalPrice;
    }

    public void setDiscountValue(int value) {
        this.currentDiscount = value;
        supplierOfProduct.put(currentProduct.getProductID(), currentSupplier.getSupplierID());
        totalPriceOfProduct.put(currentProduct.getProductID(), currentTotalPrice);
        discountsOfProduct.put(currentProduct.getProductID(), value);
        renderRowTableImport();
    }

    public void renderRowTableImport() {

        int quantityOfProductExist = 0;
        boolean isContainsKey = false;

        if (selectedProduct.containsKey(currentProduct.getProductID())) {
            quantityOfProductExist = selectedProduct.get(currentProduct.getProductID());
            isContainsKey = true;
        }
        if (!isContainsKey) {
            selectedProduct.put(currentProduct.getProductID(), currentQuantity);
            DefaultTableModel defaultTableModel = (DefaultTableModel) productTableImport.getModel();
            Object[] data = {currentProduct.getProductName(), NumberFormat.getKMAfter(currentTotalPrice), currentQuantity, currentProduct.getUnitPerQuantity()};
            defaultTableModel.addRow(data);
            productIds.add(currentProduct.getProductID());
            setInitialPrice(currentTotalPrice);
            setVoucherValue(currentDiscount);
            currentProduct = null;

        } else {
            int row = 0;
            row = productIds.indexOf(currentProduct.getProductID());
            int newQuantity = currentQuantity + quantityOfProductExist;
            selectedProduct.put(currentProduct.getProductID(), newQuantity);
            productTableImport.setValueAt(newQuantity * currentProduct.getPrice(), row, 1);
            productTableImport.setValueAt(newQuantity, row, 2);
            setInitialPrice(currentTotalPrice);
            setVoucherValue(currentDiscount);
        }

        currentDiscount = 0;
        currentTotalPrice = 0;
        currentProduct = null;
        currentQuantity = 0;
        currentSupplier = null;
    }

    private int getProductIDByIndex(int index) {
        int i = 0;
        for (int key : productIds) {
            if (i == index) {
                return key;
            }
            i++;
        }
        return -1;
    }

    private void setInitialPrice(int value) {
        initialPrice += value;
        priceToPay = initialPrice - totalDiscount;
        changeAndDisplayPrice();
    }

    private void setVoucherValue(int value) {
        totalDiscount += value;
        priceToPay = initialPrice - totalDiscount;
        changeAndDisplayPrice();
    }

    private void changeAndDisplayPrice() {
        initialPriceDisplay.setText(NumberFormat.getMoneyFormat(initialPrice) + " VNĐ");
        totalDiscountDisplay.setText(NumberFormat.getMoneyFormat(totalDiscount) + " VNĐ");
        priceToPayDisplay.setText(NumberFormat.getMoneyFormat(priceToPay) + " VNĐ");
    }

    private void clear() {
        initialPrice = 0;
        totalDiscount = 0;
        priceToPay = 0;
        changeAndDisplayPrice();

        DefaultTableModel producDefaultTableModel = (DefaultTableModel) productTableImport.getModel();
        producDefaultTableModel.setRowCount(0);

        productIds.clear();
        selectedProduct.clear();
        supplierOfProduct.clear();
        discountsOfProduct.clear();
        totalPriceOfProduct.clear();

        productIDInput.setText("");
        productNameInput.setText("");

        supplierNameDisplay.setText("---");
        supplierIDDisplay.setText("---");
        supplierPhoneDisplay.setText("---");

        informationDiscountDisplay.setText("0 VNĐ");
        informationPriceSellingDisplay.setText("0 VNĐ");
        informationTotalDisplay.setText("0 VNĐ");

        currentDiscount = 0;
        currentTotalPrice = 0;
        currentProduct = null;
        currentQuantity = 0;
        currentSupplier = null;
    }

    private void delete() {
        int viewIndex = productTableImport.getSelectedRow();

        if (viewIndex != -1) {
            //  Xóa dữ liệu lưu trữ quantity ở HashMap và set lại giá tiền
            int productID = getProductIDByIndex(viewIndex);

            setInitialPrice(-totalPriceOfProduct.get(productID));
            setVoucherValue(discountsOfProduct.get(productID));

            productIds.remove(viewIndex);
            selectedProduct.remove(productID);
            supplierOfProduct.remove(productID);
            discountsOfProduct.remove(productID);
            totalPriceOfProduct.remove(productID);

            int modelIndex = productTableImport.convertColumnIndexToModel(viewIndex);
            DefaultTableModel model = (DefaultTableModel) productTableImport.getModel();
            model.removeRow(modelIndex);
        }
    }
    
    public void editOne(int productID, int supplierID, int quantity, int price, int discountValue) {
        int viewIndex = productIds.indexOf(productID);
        
        productTableImport.setValueAt(NumberFormat.getKMAfter(price), viewIndex, 1);
        productTableImport.setValueAt(NumberFormat.getKMAfter(quantity), viewIndex, 2);
        
        setInitialPrice(price - totalPriceOfProduct.get(productID));
        setVoucherValue(discountValue - discountsOfProduct.get(productID));
        
        selectedProduct.put(productID, quantity);
        supplierOfProduct.put(productID, supplierID);
        discountsOfProduct.put(productID, discountValue);
        totalPriceOfProduct.put(productID, price);
        
        displayInfoOfProduct(productID);
    }
    
    private void displayInfoOfProduct(int productID) {
        Supplier supplier = ImportController.getSupplierByID(supplierOfProduct.get(productID));
        supplierIDDisplay.setText(supplier.getSupplierID() + "");
        supplierNameDisplay.setText(supplier.getCompanyName());
        supplierPhoneDisplay.setText(supplier.getPhone());
        informationDiscountDisplay.setText(NumberFormat.getMoneyFormat(discountsOfProduct.get(productID)) + " VNĐ");
        informationTotalDisplay.setText(NumberFormat.getMoneyFormat(totalPriceOfProduct.get(productID)) + " VNĐ");
        Product product = GeneralController.getProductByID(productID);
        informationPriceSellingDisplay.setText(NumberFormat.getMoneyFormat(product.getPrice()) + " VNĐ");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productIDBtnOk = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        productIDInput = new javax.swing.JTextField();
        productNameBtnOk = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        productNameInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTableImport = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        initialPriceDisplay = new javax.swing.JLabel();
        totalDiscountDisplay = new javax.swing.JLabel();
        priceToPayDisplay = new javax.swing.JLabel();
        Comfirmbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        supplierIDDisplay = new javax.swing.JLabel();
        supplierNameDisplay = new javax.swing.JLabel();
        supplierPhoneDisplay = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        informationDiscountDisplay = new javax.swing.JLabel();
        informationTotalDisplay = new javax.swing.JLabel();
        informationPriceSellingDisplay = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        productIDBtnOk.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productIDBtnOk.setText("OK");
        productIDBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIDBtnOkActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Product ID:");

        productNameBtnOk.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productNameBtnOk.setText("OK");
        productNameBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameBtnOkActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Product Name:");

        productTableImport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "UnitPerQuantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTableImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleSelectRow(evt);
            }
        });
        jScrollPane1.setViewportView(productTableImport);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Total discount:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Initial price:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Price to pay:");

        initialPriceDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        initialPriceDisplay.setText("0 VNÐ");

        totalDiscountDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalDiscountDisplay.setText("0 VNÐ");

        priceToPayDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceToPayDisplay.setText("0 VNÐ");

        Comfirmbtn.setBackground(new java.awt.Color(0, 255, 255));
        Comfirmbtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Comfirmbtn.setText("Comfirm");
        Comfirmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleConfirm(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(90, 90, 90));
        jLabel5.setText("Supplier");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Name:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("ID:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Phone:");

        supplierIDDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        supplierIDDisplay.setText("---");

        supplierNameDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        supplierNameDisplay.setText("---");

        supplierPhoneDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        supplierPhoneDisplay.setText("---");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(90, 90, 90));
        jLabel6.setText("Information");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Total price import: ");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("Discount:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("Price selling:");

        informationDiscountDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        informationDiscountDisplay.setText("0 VNĐ");

        informationTotalDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        informationTotalDisplay.setText("0 VNĐ");

        informationPriceSellingDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        informationPriceSellingDisplay.setText("0 VNĐ");

        clearBtn.setBackground(new java.awt.Color(237, 172, 46));
        clearBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(46, 237, 145));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleShowEditBox(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(237, 92, 46));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleDeleteAProduct(evt);
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(productIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(productIDBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(productNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(productNameBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(62, 62, 62))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addGap(18, 18, 18)
                                                .addComponent(informationPriceSellingDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(18, 18, 18)
                                                .addComponent(informationDiscountDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Comfirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(informationTotalDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(supplierPhoneDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(supplierIDDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(supplierNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(initialPriceDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceToPayDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalDiscountDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productIDBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productNameBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierIDDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierNameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierPhoneDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(initialPriceDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(totalDiscountDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(priceToPayDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Comfirmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informationDiscountDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informationTotalDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(informationPriceSellingDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(77, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void productIDBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIDBtnOkActionPerformed

        if (productIDInput.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Input can not empty", "Invalid value message", JOptionPane.PLAIN_MESSAGE);
            return;
        } else if (!productIDInput.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Please enter number", "Invalid value message", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        int productIDEnter = Integer.parseInt(productIDInput.getText());
        Product product;
        try {
            product = ProductsModel.takeObject(new ProductsModel().selectWithCondition("ProductID = " + productIDEnter)).get(0);
            boolean isSelectedProduct = setCurrProduct(product);
            if (isSelectedProduct) {
                showMessageDialog(null, "The product has been added, please press the edit button to edit it");
                return;
            }
        } catch (Exception ex) {
            // Do nothing
        }

        if (currentProduct == null) {
            showMessageDialog(null, "ID does not exist", "Message", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        QuantityDialog dialog = new QuantityDialog(new javax.swing.JFrame(), true);
        dialog.setTitle(currentProduct.getProductName() + ", price: " + NumberFormat.getKMAfter(currentProduct.getPrice()) + "/1");
        dialog.setImportViewAndProduct(this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_productIDBtnOkActionPerformed

    private void productNameBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameBtnOkActionPerformed
        // TODO add your handling code here:
        if (productNameInput.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter characters, do not leave empty", "Invalid value message", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        String value = productNameInput.getText();
        ArrayList<Product> sProducts = GeneralController.getProductsWithInput(value);

        ProductsDialog dialog = new ProductsDialog(new javax.swing.JFrame(), true);
        dialog.renderProduct(value, sProducts, this);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_productNameBtnOkActionPerformed

    private void handleSelectRow(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handleSelectRow
        int i = productTableImport.getSelectedRow();
        int productID = getProductIDByIndex(i);
        displayInfoOfProduct(productID);
    }//GEN-LAST:event_handleSelectRow

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        clear();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void handleDeleteAProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleDeleteAProduct
        delete();
    }//GEN-LAST:event_handleDeleteAProduct

    private void handleShowEditBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleShowEditBox
        int viewIndex = productTableImport.getSelectedRow();

        if (viewIndex != -1) {
            int productID = getProductIDByIndex(viewIndex);
            EditProductImportDailog dialog = new EditProductImportDailog(new javax.swing.JFrame(), true);
            dialog.setImportView(this);
            dialog.setAllAttribute(
                    productID, 
                    supplierOfProduct.get(productID), 
                    selectedProduct.get(productID), 
                    totalPriceOfProduct.get(productID), 
                    discountsOfProduct.get(productID)
            );
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_handleShowEditBox

    private void handleConfirm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleConfirm
        boolean confirmResult = ImportController.confirmImport(productIds, selectedProduct, supplierOfProduct, discountsOfProduct, totalPriceOfProduct);
        if (confirmResult) {
            showMessageDialog(null, "Successfully import goods");
        } else {
            showMessageDialog(null, "Fail to import goods");
        }
    }//GEN-LAST:event_handleConfirm


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comfirmbtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel informationDiscountDisplay;
    private javax.swing.JLabel informationPriceSellingDisplay;
    private javax.swing.JLabel informationTotalDisplay;
    private javax.swing.JLabel initialPriceDisplay;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel priceToPayDisplay;
    private javax.swing.JButton productIDBtnOk;
    private javax.swing.JTextField productIDInput;
    private javax.swing.JButton productNameBtnOk;
    private javax.swing.JTextField productNameInput;
    private javax.swing.JTable productTableImport;
    private javax.swing.JLabel supplierIDDisplay;
    private javax.swing.JLabel supplierNameDisplay;
    private javax.swing.JLabel supplierPhoneDisplay;
    private javax.swing.JLabel totalDiscountDisplay;
    // End of variables declaration//GEN-END:variables
}
