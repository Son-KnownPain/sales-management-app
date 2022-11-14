package db.objects;


public class Customer {
    private int customerID;
    private String customerName;
    private String phone;
    private String address;
    private int buyPoint;

    public Customer(int customerID, String customerName, String phone, String address, int buyPoint) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
        this.buyPoint = buyPoint;
    }
    
    public Customer(String[] fields) {
        this.customerID = Integer.parseInt(fields[0]);
        this.customerName = fields[1];
        this.phone = fields[2];
        this.address = fields[3];
        this.buyPoint = Integer.parseInt(fields[4]);
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getBuyPoint() {
        return buyPoint;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", customerName=" + customerName + ", phone=" + phone + ", address=" + address + ", buyPoint=" + buyPoint + '}';
    }
    
    
}
