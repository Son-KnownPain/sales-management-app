package model;

import db.objects.Customer;
import db.use.Model;
import java.util.ArrayList;


public class CustomersModel extends Model {

    public CustomersModel() {
        super("Customers", 5);
    }
    
    public static ArrayList<Customer> takeObject(ArrayList<String[]> listArr) {
        ArrayList<Customer> result = new ArrayList<>();
        for (int i = 0; i < listArr.size(); i++) {
            result.add(new Customer(listArr.get(i)));
        }
        return result;
    }
}
