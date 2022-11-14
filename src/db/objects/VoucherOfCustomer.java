package db.objects;

public class VoucherOfCustomer {
    private int voucherID;
    private int customerID;
    private int quantity;

    public VoucherOfCustomer(int voucherID, int customerID, int quantity) {
        this.voucherID = voucherID;
        this.customerID = customerID;
        this.quantity = quantity;
    }
    
    public VoucherOfCustomer(String[] fields) {
        voucherID = Integer.parseInt(fields[0]);
        customerID = Integer.parseInt(fields[1]);
        quantity = Integer.parseInt(fields[2]);
    }

    public int getVoucherID() {
        return voucherID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "VoucherOfCustomer{" + "voucherID=" + voucherID + ", customerID=" + customerID + ", quantity=" + quantity + '}';
    }
    
    
}
