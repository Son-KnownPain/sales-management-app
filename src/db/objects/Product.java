package db.objects;

public class Product {
    private int productID;
    private int categoryID;
    private String productName;
    private int price;
    private String description;
    private float discount;
    private int quantityInStore;
    private String unitPerQuantity;

    public Product(int productID, int categoryID, String productName, int price, String description, float discount, int quantityInStore, String unitPerQuantity) {
        this.productID = productID;
        this.categoryID = categoryID;
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
        productName = fields[2];
        price = Integer.parseInt(fields[3]);
        description = fields[4];
        discount = Float.parseFloat(fields[5]);
        quantityInStore = Integer.parseInt(fields[6]);
        unitPerQuantity = fields[7];
    }

    public int getProductID() {
        return productID;
    }

    public int getCategoryID() {
        return categoryID;
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
        return "Product{" + "productID=" + productID + ", categoryID=" + categoryID + ", productName=" + productName + ", price=" + price + ", description=" + description + ", discount=" + discount + ", quantityInStore=" + quantityInStore + ", unitPerQuantity=" + unitPerQuantity + '}';
    }

    public Object getSupplierID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
