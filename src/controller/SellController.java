package controller;

import db.objects.Customer;
import db.objects.Product;
import db.objects.Sell;
import db.objects.VoucherOfCustomer;
import db.objects.Voucher;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.HashMap;

import model.VoucherOfCustomerModel;
import model.VouchersModel;
import model.CustomersModel;
import model.ProductsModel;
import model.SellDetailsModel;
import model.SellsModel;

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
    
    public static boolean sellOne(Customer customer, Voucher voucher, HashMap<Integer, Integer> products, boolean isVoucherOfCustomer, int priceToPay) {
        // Insert 1 Sell -> OK
        // Insert 1 or mony SellDetail -> OK
        // Update QuantityInStore in Product -> OK
        // Update Quantity of Voucher or VoucherOfCustomer
        // Update BuyPoint
        
        // Validate
        if (customer == null || products.isEmpty()) {
            return false;
        }
        
        // Get Models
        SellsModel sellsModel = new SellsModel();
        ProductsModel productsModel = new ProductsModel();
        
        // Get current date time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.ms");  
        LocalDateTime now = LocalDateTime.now();
        String[] dateTimes = dtf.format(now).split(" ");
        
        // Voucher Code
        String voucherCode = voucher == null ? "null" : voucher.getVoucherCode();
        
        // Sells
        String sellInsertValue =
                String.format(
                        "%d, '%s', '%s', '%s'", 
                        customer.getCustomerID(),
                        dateTimes[0],
                        dateTimes[1],
                        voucherCode
                );
        boolean sellInsertResult = sellsModel.insertOne(sellInsertValue);
        
        
        // SellDetails
        
        Sell currentSell = SellsModel.takeObject(sellsModel.select("ORDER BY SellID DESC")).get(0);
        
        SellDetailsModel sellDetailsModel = new SellDetailsModel();
        
        for (int productID : products.keySet()) {
            Product currentProduct = ProductsModel.takeObject(productsModel.selectWithCondition("ProductID = " + productID)).get(0);
            
            String sellDetailInsertValue =
                String.format(
                        "%d, %d, %d, %d",
                        currentSell.getSellID(),
                        productID,
                        products.get(productID),
                        currentProduct.getPrice() * products.get(productID)
                );
            
            // Insert 1 or many details
            boolean updateSellDetailResult = sellDetailsModel.insertOne(sellDetailInsertValue);
            // Update QuantityInStore
            boolean updateQuantityInStoreResult = productsModel.updateByID("QuantityInStore = QuantityInStore - " + products.get(productID), productID);
            
            if (!updateSellDetailResult || !updateQuantityInStoreResult) {
                return false;
            }
        }
        
        // Update voucher quantity, default TRUE
        boolean updateVoucherResult = true;
        if (isVoucherOfCustomer && voucher != null) {
            VoucherOfCustomerModel voucherOfCustomerModel = new VoucherOfCustomerModel();
            updateVoucherResult = voucherOfCustomerModel.update("Quantity = Quantity - 1", "VoucherCode = '" + voucherCode + "'");
        } else if (voucher != null) {
            VouchersModel vouchersModel = new VouchersModel();
            updateVoucherResult = vouchersModel.update("Quantity = Quantity - 1", "VoucherCode = " + voucherCode);
        }
        
        // Update BuyPoint
        CustomersModel customersModel = new CustomersModel();
        int buyPointIncrease = priceToPay / 1000;
        boolean updateBuyPointResult = customersModel.updateByID("BuyPoint = BuyPoint + " + buyPointIncrease, customer.getCustomerID());
        
        return !(!sellInsertResult || !updateVoucherResult || !updateBuyPointResult);
    }
}
