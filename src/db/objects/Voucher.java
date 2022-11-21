package db.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Voucher {
    private String voucherCode;
    private int voucherValue;
    private String eventName;
    private int quantity;
    private Date createDate;
    private Date expiryDate;

    public Voucher(String voucherCode, int voucherValue, String eventName, int quantity, Date createDate, Date expiryDate) {
        this.voucherCode = voucherCode;
        this.voucherValue = voucherValue;
        this.eventName = eventName;
        this.quantity = quantity;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
    }
    
    public Voucher(String[] fields) {
        voucherCode = fields[0];
        voucherValue = Integer.parseInt(fields[1]);
        eventName = fields[2];
        quantity = Integer.parseInt(fields[3]);
        try {
            createDate = new SimpleDateFormat("yyyy-MM-dd").parse(fields[4]);
            expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(fields[5]);
        } catch (ParseException ex) {
            Logger.getLogger(Voucher.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public String getEventName() {
        return eventName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Voucher{" + "voucherCode=" + voucherCode + ", voucherValue=" + voucherValue + ", eventName=" + eventName + ", quantity=" + quantity + ", createDate=" + createDate + ", expiryDate=" + expiryDate + '}';
    }

    
    
    
}
