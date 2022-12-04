package controller;

import db.objects.Customer;
import java.util.ArrayList;
import model.CustomersModel;

public class GeneralController {
    public static ArrayList<Customer> getCustomersWithInput(String inputValue) {
        CustomersModel customersModel = new CustomersModel();
        ArrayList<Customer> customers;
        if (inputValue.matches("[A-Za-z\s]+")) {
            customers = CustomersModel.takeObject(customersModel.selectWithCondition("CustomerName LIKE '%" + inputValue + "%'"));
        } else {
            customers = CustomersModel.takeObject(customersModel.selectWithCondition("Phone LIKE '%" + inputValue + "%'"));
        }
        return customers;
    }
}
