package model;

import db.objects.Product;
import db.use.Model;
import java.util.ArrayList;

public class ProductsModel extends Model {
    public ProductsModel() {
        super("Products", 8);
    }
    
    public static ArrayList<Product> takeObject(ArrayList<String[]> listArr) {
        ArrayList<Product> result = new ArrayList<>();
        
        for (int i = 0; i < listArr.size(); i++) {
            result.add(new Product(listArr.get(i)));
        }
        return result;
    }
}
