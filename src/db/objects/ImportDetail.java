package db.objects;

public class ImportDetail {
    private int importID;
    private int productID;
    private int supplierID;
    private int quantity;
    private int discountMoney;
    private int totalPrice;

    public ImportDetail(int importID, int productID, int supplierID, int quantity, int discountMoney, int totalPrice) {
        this.importID = importID;
        this.productID = productID;
        this.supplierID = supplierID;
        this.quantity = quantity;
        this.discountMoney = discountMoney;
        this.totalPrice = totalPrice;
    }
    
    public ImportDetail(String[] fields) {
        importID = Integer.parseInt(fields[0]);
        productID = Integer.parseInt(fields[1]);
        supplierID = Integer.parseInt(fields[2]);
        quantity = Integer.parseInt(fields[3]);
        discountMoney = Integer.parseInt(fields[4]);
        totalPrice = Integer.parseInt(fields[5]);
    }

    public int getImportID() {
        return importID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDiscountMoney() {
        return discountMoney;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "ImportDetail{" + "importID=" + importID + ", productID=" + productID + ", supplierID=" + supplierID + ", quantity=" + quantity + ", discountMoney=" + discountMoney + ", totalPrice=" + totalPrice + '}';
    }

    
    
    
}
