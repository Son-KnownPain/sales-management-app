package db.objects;

public class Product {
    private int productID;
    private int categoryID;
    private int supplierID;
    private String productName;
    private int price;
    private String description;
    private float discount;
    private int quantityInStore;
    private String unitPerQuantity;

    public Product(int productID, int categoryID, int supplierID, String productName, int price, String description, float discount, int quantityInStore, String unitPerQuantity) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.supplierID = supplierID;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.quantityInStore = quantityInStore;
        this.unitPerQuantity = unitPerQuantity;
    }
    
    public Product(String[] fields) {
        productID = Integer.parseInt(fields[0]);
        categoryID = Integer.parseInt(fields[1]);
        supplierID = Integer.parseInt(fields[2]);
        productName = fields[3];
        price = Integer.parseInt(fields[4]);
        description = fields[5];
        discount = Float.parseFloat(fields[6]);
        quantityInStore = Integer.parseInt(fields[7]);
        unitPerQuantity = fields[8];
    }

    public int getProductID() {
        return productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public float getDiscount() {
        return discount;
    }

    public int getQuantityInStore() {
        return quantityInStore;
    }

    public String getUnitPerQuantity() {
        return unitPerQuantity;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", categoryID=" + categoryID + ", supplierID=" + supplierID + ", productName=" + productName + ", price=" + price + ", description=" + description + ", discount=" + discount + ", quantityInStore=" + quantityInStore + ", unitPerQuantity=" + unitPerQuantity + '}';
    }
    
    
}
