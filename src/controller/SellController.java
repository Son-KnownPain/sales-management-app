package controller;

import db.objects.Customer;
import java.util.ArrayList;
import model.CustomersModel;
import view.Sell;

public class SellController {
    public static ArrayList<Customer> getCustomersWithInput(String inputValue) {
        CustomersModel customersModel = new CustomersModel();
        ArrayList<Customer> customers 
                = CustomersModel.takeObject(customersModel.selectWithCondition("CustomerName LIKE '%" + inputValue + "%'"));
        return customers;
    }
}
