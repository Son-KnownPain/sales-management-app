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
import supports.Gift;

public class SellController {
    
    
    
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
        VoucherOfCustomerModel voucherOfCustomerModel = new VoucherOfCustomerModel();;
        
        // Get current date time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.ms");  
        LocalDateTime now = LocalDateTime.now();
        String[] dateTimes = dtf.format(now).split(" ");
        
        // Voucher Code
        String voucherCode = voucher == null ? "NULL" : "'" + voucher.getVoucherCode() + "'";
        
        // Update voucher quantity, default TRUE
        boolean updateVoucherResult = true;
        if (isVoucherOfCustomer && voucher != null) {
            String condition = String.format("VoucherCode = %s AND CustomerID = %d", voucherCode, customer.getCustomerID());
            updateVoucherResult = voucherOfCustomerModel.update("Quantity = Quantity - 1", condition);
        } else if (voucher != null) {
            VouchersModel vouchersModel = new VouchersModel();
            String condition = String.format("VoucherCode = %s AND CustomerID = %d", voucherCode, customer.getCustomerID());
            updateVoucherResult = vouchersModel.update("Quantity = Quantity - 1", condition);
        }
        
        // Sells
        String sellInsertValue =
                String.format(
                        "%d, '%s', '%s', %s", 
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
                        ((int) (currentProduct.getPrice() - currentProduct.getDiscount()*currentProduct.getPrice()) * products.get(productID))
                );
            
            // Insert 1 or many details
            boolean updateSellDetailResult = sellDetailsModel.insertOne(sellDetailInsertValue);
            // Update QuantityInStore
            boolean updateQuantityInStoreResult = productsModel.updateByID("QuantityInStore = QuantityInStore - " + products.get(productID), productID);
            
            if (!updateSellDetailResult || !updateQuantityInStoreResult) {
                return false;
            }
        }
        
        
        // Update BuyPoint
        CustomersModel customersModel = new CustomersModel();
        int buyPointIncrease = priceToPay / 1000;
        boolean updateBuyPointResult = customersModel.updateByID("BuyPoint = BuyPoint + " + buyPointIncrease, customer.getCustomerID());
        
        // Gift BuyPoint
        boolean giftResult = true;
        final int MILESTONE = Gift.getMilestone(customer.getBuyPoint(), customer.getBuyPoint() + buyPointIncrease);
        switch (MILESTONE) {
            case Gift.MILESTONE_1:
                giftResult = voucherOfCustomerModel.insertOne(String.format(
                        "'%s', %d, %d", 
                        Gift.GIFTCODE_1, 
                        customer.getCustomerID(), 
                        1
                ));
                break;
            case Gift.MILESTONE_2:
                giftResult = voucherOfCustomerModel.insertOne(String.format(
                        "'%s', %d, %d", 
                        Gift.GIFTCODE_2, 
                        customer.getCustomerID(), 
                        1
                ));
                break;
            case Gift.MILESTONE_3:
                giftResult = voucherOfCustomerModel.insertOne(String.format(
                        "'%s', %d, %d", 
                        Gift.GIFTCODE_3, 
                        customer.getCustomerID(), 
                        1
                ));
                break;
            case Gift.MILESTONE_4:
                giftResult = voucherOfCustomerModel.insertOne(String.format(
                        "'%s', %d, %d", 
                        Gift.GIFTCODE_4, 
                        customer.getCustomerID(), 
                        1
                ));
                break;
            case Gift.MILESTONE_5:
                giftResult = voucherOfCustomerModel.insertOne(String.format(
                        "'%s', %d, %d", 
                        Gift.GIFTCODE_5, 
                        customer.getCustomerID(), 
                        1
                ));
                break;
            case Gift.MILESTONE_6:
                giftResult = voucherOfCustomerModel.insertOne(String.format(
                        "'%s', %d, %d", 
                        Gift.GIFTCODE_6, 
                        customer.getCustomerID(), 
                        1
                ));
                break;
            case Gift.MILESTONE_7:
                giftResult = voucherOfCustomerModel.insertOne(String.format(
                        "'%s', %d, %d", 
                        Gift.GIFTCODE_7, 
                        customer.getCustomerID(), 
                        1
                ));
                break;
            case Gift.MILESTONE_8:
                giftResult = voucherOfCustomerModel.insertOne(String.format(
                        "'%s', %d, %d", 
                        Gift.GIFTCODE_8, 
                        customer.getCustomerID(), 
                        1
                ));
                break;
            default:
                // Do nothing
                break;
        }
        
        return !(!sellInsertResult || !updateVoucherResult || !updateBuyPointResult || !giftResult);
    }
}
