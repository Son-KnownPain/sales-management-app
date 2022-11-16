package controller;

import db.objects.Customer;
import db.objects.Product;
import java.util.ArrayList;
import model.CustomersModel;
import model.ProductsModel;
import view.Sell;

public class SellController {
    public static ArrayList<Customer> getCustomersWithInput(String inputValue) {
        CustomersModel customersModel = new CustomersModel();
        ArrayList<Customer> customers 
                = CustomersModel.takeObject(customersModel.selectWithCondition("CustomerName LIKE '%" + inputValue + "%'"));
        return customers;
    }
    
    public static ArrayList<Product> getProductsWithInput(String value) {
        ProductsModel productsModel = new ProductsModel();
        ArrayList<Product> products 
                = ProductsModel.takeObject(productsModel.selectWithCondition("ProductName LIKE '%" + value + "%'"));
        return products;
    }
}
