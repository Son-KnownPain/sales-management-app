package db.objects;

public class ImportDetail {
    private int importID;
    private int productID;
    private int quantity;
    private int discountMoney;
    private int totalPrice;

    public ImportDetail(int importID, int productID, int quantity, int discountMoney, int totalPrice) {
        this.importID = importID;
        this.productID = productID;
        this.quantity = quantity;
        this.discountMoney = discountMoney;
        this.totalPrice = totalPrice;
    }
    
    public ImportDetail(String[] fields) {
        importID = Integer.parseInt(fields[0]);
        productID = Integer.parseInt(fields[1]);
        quantity = Integer.parseInt(fields[2]);
        discountMoney = Integer.parseInt(fields[3]);
        totalPrice = Integer.parseInt(fields[4]);
    }

    public int getImportID() {
        return importID;
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
        return "ImportDetail{" + "importID=" + importID + ", productID=" + productID + ", quantity=" + quantity + ", discountMoney=" + discountMoney + ", totalPrice=" + totalPrice + '}';
    }
    
    
}
