package test;

import db.objects.Customer;
import model.CustomersModel;


public class Test {
    public static void main(String[] args) {
        for (Customer a : CustomersModel.takeObject(new CustomersModel().selectWithCondition("CustomerID = 4"))) {
            System.out.println(a);
        }
    }
}
