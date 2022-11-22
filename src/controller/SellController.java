package controller;

import db.objects.Customer;
import db.objects.Product;
import db.objects.Voucher;
import db.objects.VoucherOfCustomer;
import db.objects.Supplier;

import java.util.ArrayList;

import model.VoucherOfCustomerModel;
import model.VouchersModel;
import model.CustomersModel;
import model.ProductsModel;
import model.SuppliersModel;

public class SellController {
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
    
    public static ArrayList<Product> getProductsWithInput(String value) {
        ProductsModel productsModel = new ProductsModel();
        ArrayList<Product> products 
                = ProductsModel.takeObject(productsModel.selectWithCondition("ProductName LIKE '%" + value + "%'"));
        return products;
    }
    

    public static Product getProductByID(int id) {
        ArrayList<Product> listProduct = ProductsModel.takeObject(new ProductsModel().selectWithCondition("ProductID = " + id));
        Product result = null;
        if (!listProduct.isEmpty()) {
            result = listProduct.get(0);
        }
        return result;
    }
    
    public static Voucher getVoucher(String voucherCode) {
        ArrayList<Voucher> vouchers = 
                VouchersModel.takeObject(new VouchersModel().selectWithCondition("VoucherCode = '" + voucherCode + "'"));
        if (!vouchers.isEmpty()) {
            return vouchers.get(0);
        }
        return null;
    }
    
    public static ArrayList<VoucherOfCustomer> getVouchersOfCustomer(Customer customer) {
        return VoucherOfCustomerModel.takeObject(new VoucherOfCustomerModel().selectWithCondition("CustomerID = " + customer.getCustomerID()));
    }
    
    
}
