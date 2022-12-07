/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.objects.Voucher;
import java.util.ArrayList;
import java.util.Date;
import model.VouchersModel;

/**
 *
 * @author PC HP
 */
public class VoucherController {
    
    public static ArrayList<Voucher> getVoucherWithInuput(String valueInput){
        VouchersModel vouchersModel = new VouchersModel();
        ArrayList<Voucher> arrayList = VouchersModel.takeObject(vouchersModel.selectWithCondition("EventName LIKE '%" + valueInput + "%'"));
        return arrayList;
        
    }
    
    public static boolean editVoucher(Voucher voucher){
        VouchersModel vouchersModel = new VouchersModel();
        return vouchersModel.updateByID(String.format(
                "VoucherCode = '%s', VoucherValue = %s, EventName = '%s', Quantity = %s, CreateDate = '%s', ExpiryDate = '%s'",
                voucher.getVoucherCode(),
                voucher.getVoucherValue(),
                voucher.getEventName(), 
                voucher.getQuantity(),
                voucher.getCreateDate(), 
                voucher.getExpiryDate()
            )
                
       );
    }

    public static boolean addVoucher(String vCode, String vValue, String vEventName, String vQuantity, String vCreateDate, String vExpiryDate) {
        VouchersModel vouchersModel = new VouchersModel();
        boolean result = vouchersModel.insertOne(String.format(
                "'%s', %s, '%s', %s, '%s', '%s'",
                vCode,
                vValue,
                vEventName,
                vQuantity,
                vCreateDate, 
                vExpiryDate
        ));
        return result;
    }
    
}
