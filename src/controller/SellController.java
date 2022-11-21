package controller;

import db.objects.Customer;
import db.objects.Product;
import db.objects.Supplier;
import java.util.ArrayList;
import model.CustomersModel;
import model.ProductsModel;
import model.SuppliersModel;
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
    
    public static ArrayList<Supplier> getSupplierWithInput(String value){
        SuppliersModel suppliersModel = new SuppliersModel();
        ArrayList<Supplier> suppliers = SuppliersModel.takeObject(suppliersModel.selectWithCondition("CompanyName LIKE '%" + value + " %'"));
        
        return suppliers;
        
    }
    
    public static ArrayList<Product> getProductsWithInput2(String value) {
        ProductsModel productsModel = new ProductsModel();
        ArrayList<Product> products 
                = ProductsModel.takeObject(productsModel.selectWithCondition("ProductName LIKE '%" + value + "%'"));
        return products;
    }
}
