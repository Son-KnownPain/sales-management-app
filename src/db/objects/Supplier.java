package db.objects;

public class Supplier {
    private int supplierID;
    private String companyName;
    private String address;
    private String phone;
    private String email;
    private String postalCode;

    public Supplier(int supplierID, String companyName, String address, String phone, String email, String postalCode) {
        this.supplierID = supplierID;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.postalCode = postalCode;
    }
    
    public Supplier(String[] fields) {
        supplierID = Integer.parseInt(fields[0]);
        companyName = fields[1];
        address = fields[2];
        phone = fields[3];
        email = fields[4];
        postalCode = fields[5];
    }

    public int getSupplierID() {
        return supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplierID=" + supplierID + ", companyName=" + companyName + ", address=" + address + ", phone=" + phone + ", email=" + email + ", postalCode=" + postalCode + '}';
    }
    
    
}
