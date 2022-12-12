package controller;

import db.objects.Customer;
import db.objects.Voucher;
import db.objects.VoucherOfCustomer;
import java.util.ArrayList;
import model.CustomersModel;
import model.VoucherOfCustomerModel;
import model.VouchersModel;

public class CustomerController {
    public static boolean editCustomer(Customer customerEdited) {
        CustomersModel customersModel = new CustomersModel();
        boolean result = customersModel.updateByID(
                String.format(
                        "CustomerName = '%s', Phone = '%s', Address = '%s'",
                        customerEdited.getCustomerName(),
                        customerEdited.getPhone(),
                        customerEdited.getAddress()
                ), 
                customerEdited.getCustomerID()
        );
        return result;
    }
    
    public static boolean addCustomer(String name, String phone, String address) {
        CustomersModel customersModel = new CustomersModel();
        boolean result = customersModel.insertOne(String.format(
                "'%s', '%s', '%s', %d",
                name,
                phone,
                address,
                0
                
        ));
        return result;
    }
    
    public static ArrayList<String[]> getVoucherOfCustomer(int id) {
        VoucherOfCustomerModel voucherOfCustomerModel = new VoucherOfCustomerModel();
        String query = "SELECT VOC.VoucherCode, VOC.Quantity, V.VoucherValue  FROM VoucherOfCustomer AS VOC JOIN Vouchers AS V ON V.VoucherCode = VOC.VoucherCode WHERE CustomerID = " + id + " AND VOC.Quantity > 0";
        return voucherOfCustomerModel.run(3, query);
    }
    
    public static ArrayList<Voucher> getVoucherByEvent(String eventName) {
        VouchersModel vouchersModel = new VouchersModel();
        return VouchersModel.takeObject(vouchersModel.selectWithCondition("EventName LIKE '%" + eventName + "%'"));
    }
    
    public static boolean donateVoucher(Customer customer, Voucher voucher, int quantity) {
        VoucherOfCustomerModel vocm = new VoucherOfCustomerModel();
        ArrayList<VoucherOfCustomer> voucherOfCustomer 
                =  VoucherOfCustomerModel.takeObject(
                        vocm.selectWithCondition("CustomerID = " + customer.getCustomerID() + " AND VoucherCode = '" + voucher.getVoucherCode() + "'")
                );
        if (voucherOfCustomer.isEmpty()) {
            return vocm.insertOne(String.format("'%s', %d, %d", voucher.getVoucherCode(), customer.getCustomerID(), quantity));
        } else {
            return vocm.update("Quantity = " + quantity, "CustomerID = " + customer.getCustomerID());
        }
    }
    
    public static ArrayList<Customer> getBestCustomers() {
        CustomersModel customersModel = new CustomersModel();
        return CustomersModel.takeObject(customersModel.selectTop(10, "ORDER BY BuyPoint DESC"));
    }
}
