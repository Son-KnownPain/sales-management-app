package model;

import db.objects.Category;
import db.use.Model;
import java.util.ArrayList;

public class CategoriesModel extends Model {
    public CategoriesModel() {
        super("Categories", 3);
    }
    
    public static ArrayList<Category> takeObject(ArrayList<String[]> listArr) {
        ArrayList<Category> result = new ArrayList<>();
        for (int i = 0; i < listArr.size(); i++) {
            result.add(new Category(listArr.get(i)));
        }
        return result;
    }
}
