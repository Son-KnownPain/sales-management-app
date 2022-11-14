package model;

import db.objects.Sell;
import db.use.Model;
import java.util.ArrayList;

public class SellsModel extends Model {
    public SellsModel() {
        super("Sells", 5);
    }
    
    public static ArrayList<Sell> takeObject(ArrayList<String[]> listArr) {
        ArrayList<Sell> result = new ArrayList<>();
        for (int i = 0; i < listArr.size(); i++) {
            result.add(new Sell(listArr.get(i)));
        }
        return result;
    }
}
