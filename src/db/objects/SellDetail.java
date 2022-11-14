package db.objects;

public class SellDetail {
    private int sellID;
    private int productID;
    private int productQuantity;
    private int totalPrice;

    public SellDetail(int sellID, int productID, int productQuantity, int totalPrice) {
        this.sellID = sellID;
        this.productID = productID;
        this.productQuantity = productQuantity;
        this.totalPrice = totalPrice;
    }
    
    public SellDetail(String[] fields) {
        sellID = Integer.parseInt(fields[0]);
        productID = Integer.parseInt(fields[1]);
        productQuantity = Integer.parseInt(fields[2]);
        totalPrice = Integer.parseInt(fields[3]);
    }

    public int getSellID() {
        return sellID;
    }

    public int getProductID() {
        return productID;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "SellDetail{" + "sellID=" + sellID + ", productID=" + productID + ", productQuantity=" + productQuantity + ", totalPrice=" + totalPrice + '}';
    }
    
    
}
