package db.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sell {
    private int sellID;
    private int customerID;
    private Date sellDateTime;
    private String voucherCode;
    // sellDateTime is converted from SellDate and SellTime;
    
    // Sells have 5 columns

    public Sell(int sellID, int customerID, Date sellDateTime, String voucherCode) {
        this.sellID = sellID;
        this.customerID = customerID;
        this.sellDateTime = sellDateTime;
        this.voucherCode = voucherCode;
    }
    
    public Sell(String[] fields) {
        sellID = Integer.parseInt(fields[0]);
        customerID = Integer.parseInt(fields[1]);
        try {
            sellDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fields[2] + " " + fields[3].split("[.]")[0]);
        } catch (ParseException ex) {
            Logger.getLogger(Sell.class.getName()).log(Level.SEVERE, null, ex);
        }
        voucherCode = fields[4];
    }

    public int getSellID() {
        return sellID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Date getSellDateTime() {
        return sellDateTime;
    }

    public String getVoucherValue() {
        return voucherCode;
    }

    @Override
    public String toString() {
        return "Sell{" + "sellID=" + sellID + ", customerID=" + customerID + ", sellDateTime=" + sellDateTime.toString() + ", voucherCode=" + voucherCode + '}';
    }
    
    
}
