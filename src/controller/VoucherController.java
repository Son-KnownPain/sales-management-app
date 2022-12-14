/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.objects.Voucher;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        VouchersModel vouchersModel = new VouchersModel();

        boolean result = vouchersModel.update(
                String.format(
                "EventName = '%s', Quantity = %d, CreateDate = '%s', ExpiryDate = '%s'",
                voucher.getEventName(), 
                voucher.getQuantity(),
                format.format(voucher.getCreateDate()), 
                format.format(voucher.getExpiryDate())
            ),
            "VoucherCode = '" + voucher.getVoucherCode() + "'"
       );
         return result;
    }

    public static boolean addVoucher(String vCode, int vValue, String vEventName, int vQuantity, LocalDate vCreateDate, LocalDate vExpiryDate) {
        VouchersModel vouchersModel = new VouchersModel();
        boolean result = vouchersModel.insertOne(String.format(
                "'%s', %d, '%s', %d, '%s', '%s'",
                vCode,
                vValue,
                vEventName,
                vQuantity,
                vCreateDate.toString(), 
                vExpiryDate.toString()
        ));
        return result;
    }
    
}
