package db.objects;

public class VoucherOfCustomer {
    private String voucherCode;
    private int customerID;
    private int quantity;

    public VoucherOfCustomer(String voucherCode, int customerID, int quantity) {
        this.voucherCode = voucherCode;
        this.customerID = customerID;
        this.quantity = quantity;
    }
    
    public VoucherOfCustomer(String[] fields) {
        voucherCode = fields[0];
        customerID = Integer.parseInt(fields[1]);
        quantity = Integer.parseInt(fields[2]);
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    @Override
    public String toString() {
        return "VoucherOfCustomer{" + "voucherCode=" + voucherCode + ", customerID=" + customerID + ", quantity=" + quantity + '}';
    }

    
    
    
}
