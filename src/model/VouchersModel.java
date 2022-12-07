package model;

import db.objects.Voucher;
import db.use.Model;
import java.util.ArrayList;

public class VouchersModel extends Model {
    public VouchersModel() {
        super("Vouchers", 6);
    }
    
    public static ArrayList<Voucher> takeObject(ArrayList<String[]> listArr) {
        ArrayList<Voucher> result = new ArrayList<>();
        
        for (int i = 0; i < listArr.size(); i++) {
            result.add(new Voucher(listArr.get(i)));
        }
        return result;
    }

    public boolean updateByID(String format) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
