package model;

import db.objects.ImportDetail;
import db.use.Model;
import java.util.ArrayList;

public class ImportDetailsModel extends Model {
    public ImportDetailsModel() {
        super("ImportDetails", 6);
    }
    
    public static ArrayList<ImportDetail> takeObject(ArrayList<String[]> listArr) {
        ArrayList<ImportDetail> result = new ArrayList<>();
        
        for (int i = 0; i < listArr.size(); i++) {
            result.add(new ImportDetail(listArr.get(i)));
        }
        return result;
    }
}
