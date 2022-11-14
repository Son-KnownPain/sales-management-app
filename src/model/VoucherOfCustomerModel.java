package model;

import db.objects.VoucherOfCustomer;
import db.use.Model;
import java.util.ArrayList;

public class VoucherOfCustomerModel extends Model {
    public VoucherOfCustomerModel() {
        super("VoucherOfCustomer", 3);
    }
    
    public static ArrayList<VoucherOfCustomer> takeObject(ArrayList<String[]> listArr) {
        ArrayList<VoucherOfCustomer> result = new ArrayList<>();
        
        for (int i = 0; i < listArr.size(); i++) {
            result.add(new VoucherOfCustomer(listArr.get(i)));
        }
        return result;
    }
}
