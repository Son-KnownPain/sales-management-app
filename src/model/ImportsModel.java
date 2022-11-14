package model;

import db.objects.Import;
import db.use.Model;
import java.util.ArrayList;

public class ImportsModel extends Model {
    public ImportsModel() {
        super("Imports", 4);
    }
    
    public static ArrayList<Import> takeObject(ArrayList<String[]> listArr) {
        ArrayList<Import> result = new ArrayList<>();
        
        for (int i = 0; i < listArr.size(); i++) {
            result.add(new Import(listArr.get(i)));
        }
        return result;
    }
}
