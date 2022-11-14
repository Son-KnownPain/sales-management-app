package db.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Voucher {
    private int voucherID;
    private String voucherCode;
    private int voucherValue;
    private int quantity;
    private Date createDate;
    private Date expiryDate;

    public Voucher(int voucherID, String voucherCode, int voucherValue, int quantity, Date createDate, Date expiryDate) {
        this.voucherID = voucherID;
        this.voucherCode = voucherCode;
        this.voucherValue = voucherValue;
        this.quantity = quantity;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
    }
    
    public Voucher(String[] fields) {
        voucherID = Integer.parseInt(fields[0]);
        voucherCode = fields[1];
        voucherValue = Integer.parseInt(fields[2]);
        quantity = Integer.parseInt(fields[3]);
        try {
            createDate = new SimpleDateFormat("yyyy-MM-dd").parse(fields[4]);
            expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(fields[5]);
        } catch (ParseException ex) {
            Logger.getLogger(Voucher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getVoucherID() {
        return voucherID;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public int getVoucherValue() {
        return voucherValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Voucher{" + "voucherID=" + voucherID + ", voucherCode=" + voucherCode + ", voucherValue=" + voucherValue + ", quantity=" + quantity + ", createDate=" + new SimpleDateFormat("dd/MM/yyyy").format(createDate) + ", expiryDate=" + new SimpleDateFormat("dd/MM/yyyy").format(expiryDate) + '}';
    }
    
    
}
