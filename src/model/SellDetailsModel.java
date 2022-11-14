package model;

import db.objects.SellDetail;
import db.use.Model;
import java.util.ArrayList;

public class SellDetailsModel extends Model {
    public SellDetailsModel() {
        super("SellDetails", 4);
    }
    
    public static ArrayList<SellDetail> takeObject(ArrayList<String[]> listArr) {
        ArrayList<SellDetail> result = new ArrayList<>();
        
        for (int i = 0; i < listArr.size(); i++) {
            result.add(new SellDetail(listArr.get(i)));
        }
        return result;
    }
}
