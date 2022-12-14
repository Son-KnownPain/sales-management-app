package view;

import controller.ProductCategoryController;
import db.objects.Category;
import db.objects.Product;
import javax.swing.JOptionPane;
import supports.NumberFormat;
import view.dialog.AddCategoryDialog;
import view.dialog.AddProductDialog;
import view.dialog.ChooseCategoryDialog;
import view.dialog.ChooseProductDialog;
import view.dialog.EditCategoryDialog;
import view.dialog.EditProductDialog;

public class ProductCategoryView extends javax.swing.JPanel {

    private Product currentProduct = null;
    private Category currentCategory = null;

    private final int PRODUCT = 0;
    private final int CATEGORY = 1;
    private int optionChoosing = PRODUCT;

    public ProductCategoryView() {
        initComponents();
    }

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
        this.displayProductInfo();
    }

    private void displayProductInfo() {
        if (currentProduct != null) {
            productNameDisplay.setText(currentProduct.getProductName() + " (ID: " + currentProduct.getProductID() + ")");
            priceDisplay.setText(NumberFormat.getMoneyFormat(currentProduct.getPrice()) + " VNĐ");
            discountDisplay.setText((int) (currentProduct.getDiscount() * 100) + "%");
            quantityInStoreDisplay.setText(currentProduct.getQuantityInStore() + "");
            unitPerQuantityDisplay.setText(currentProduct.getUnitPerQuantity());
            productDescriptionDisplay.setText(currentProduct.getDescription());
            productCategoryDisplay.setText(ProductCategoryController.getCategoryNameByID(currentProduct.getCategoryID()));
        }
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
        displayCategoryInfo();
    }

    private void displayCategoryInfo() {
        if (currentCategory != null) {
            categoryNameDisplay.setText(currentCategory.getCategoryName());
            categoryDescriptionDisplay.setText(currentCategory.getDescription());
            numberOfProductDisplay.setText(ProductCategoryController.getNumProductBelong(currentCategory.getCategoryID()) + "");
        }
    }

    // HANDLE ADD, EDIT METHOD --------
    private void addProduct() {
        AddProductDialog dialog = new AddProductDialog(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void addCategory() {
        AddCategoryDialog dialog = new AddCategoryDialog(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void editProduct() {
        if (currentProduct == null) {
            JOptionPane.showMessageDialog(null, "Please choose a product");
            return;
        }
        EditProductDialog dialog = new EditProductDialog(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setCurrentProduct(currentProduct);
        dialog.setProductCategoryView(this);
        dialog.setVisible(true);
    }

    private void editCategory() {
        if (currentCategory == null) {
            JOptionPane.showMessageDialog(null, "Please choose a category");
            return;
        }
        EditCategoryDialog dialog = new EditCategoryDialog(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setCurrentCategory(currentCategory);
        dialog.setProductCategoryView(this);
        dialog.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        options = new javax.swing.JComboBox<>();
        bestBtn = new javax.swing.JButton();
        chooseCategoryBtn = new javax.swing.JButton();
        quantityInStoreDisplay = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        unitPerQuantityDisplay = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        productDescriptionDisplay = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productNameDisplay = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        priceDisplay = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        productCategoryDisplay = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        discountDisplay = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        categoryNameDisplay = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        categoryDescriptionDisplay = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        numberOfProductDisplay = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        categoryOfProductBtn = new javax.swing.JButton();

        options.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Product", "Category" }));
        options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleChooseOption(evt);
            }
        });

        bestBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bestBtn.setText("Choose product");
        bestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleChooseProduct(evt);
            }
        });

        chooseCategoryBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chooseCategoryBtn.setText("Choose category");
        chooseCategoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleChooseCategory(evt);
            }
        });

        quantityInStoreDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        quantityInStoreDisplay.setText("---");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Unit per quantity:");

        unitPerQuantityDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        unitPerQuantityDisplay.setText("---");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Description:");

        productDescriptionDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productDescriptionDisplay.setText("---");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(90, 90, 90));
        jLabel15.setText("Product Information");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Name:");

        productNameDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productNameDisplay.setText("---");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Price:");

        priceDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceDisplay.setText("---");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Quantity in store:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Category name:");

        productCategoryDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productCategoryDisplay.setText("---");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Discount:");

        discountDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        discountDisplay.setText("---");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(90, 90, 90));
        jLabel17.setText("Action");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Category name: ");

        categoryNameDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryNameDisplay.setText("---");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("Description:");

        categoryDescriptionDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryDescriptionDisplay.setText("---");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("Number of product belong this category:");

        numberOfProductDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        numberOfProductDisplay.setText("---");

        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleAdd(evt);
            }
        });

        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleEdit(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(90, 90, 90));
        jLabel24.setText("Category Information");

        categoryOfProductBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryOfProductBtn.setText("Category of above product");
        categoryOfProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleCategoryAboveProduct(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chooseCategoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(productNameDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(priceDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(discountDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(quantityInStoreDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(unitPerQuantityDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(productDescriptionDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(productCategoryDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(categoryNameDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(categoryDescriptionDisplay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(numberOfProductDisplay))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(categoryOfProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel24))
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseCategoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productNameDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(priceDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(discountDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(quantityInStoreDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(unitPerQuantityDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(productDescriptionDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(productCategoryDisplay))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(categoryNameDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(categoryDescriptionDisplay))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(numberOfProductDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryOfProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void handleChooseProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleChooseProduct
        ChooseProductDialog dialog = new ChooseProductDialog(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setView(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleChooseProduct

    private void handleChooseOption(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleChooseOption
        int index = options.getSelectedIndex();
        switch (index) {
            case 0:
                optionChoosing = PRODUCT;
                break;
            case 1:
                optionChoosing = CATEGORY;
                break;
        }
    }//GEN-LAST:event_handleChooseOption

    private void handleChooseCategory(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleChooseCategory
        ChooseCategoryDialog dialog = new ChooseCategoryDialog(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setProductCategoryView(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_handleChooseCategory

    private void handleCategoryAboveProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleCategoryAboveProduct
        if (currentProduct == null) {
            JOptionPane.showMessageDialog(null, "Please choose a product before");
            return;
        }
        int categoryIDAboveProduct = currentProduct.getCategoryID();
        Category category = ProductCategoryController.getCategoryByID(categoryIDAboveProduct);
        setCurrentCategory(category);
    }//GEN-LAST:event_handleCategoryAboveProduct

    private void handleEdit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleEdit
        switch (optionChoosing) {
            case PRODUCT:
                editProduct();
                break;
            case CATEGORY:
                editCategory();
                break;
            default:
                System.out.println("DEFAULT ADD");
        }
    }//GEN-LAST:event_handleEdit

    private void handleAdd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleAdd
        switch (optionChoosing) {
            case PRODUCT:
                addProduct();
                break;
            case CATEGORY:
                addCategory();
                break;
            default:
                System.out.println("DEFAULT ADD");
        }
    }//GEN-LAST:event_handleAdd


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton bestBtn;
    private javax.swing.JLabel categoryDescriptionDisplay;
    private javax.swing.JLabel categoryNameDisplay;
    private javax.swing.JButton categoryOfProductBtn;
    private javax.swing.JButton chooseCategoryBtn;
    private javax.swing.JLabel discountDisplay;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel numberOfProductDisplay;
    private javax.swing.JComboBox<String> options;
    private javax.swing.JLabel priceDisplay;
    private javax.swing.JLabel productCategoryDisplay;
    private javax.swing.JLabel productDescriptionDisplay;
    private javax.swing.JLabel productNameDisplay;
    private javax.swing.JLabel quantityInStoreDisplay;
    private javax.swing.JLabel unitPerQuantityDisplay;
    // End of variables declaration//GEN-END:variables
}
