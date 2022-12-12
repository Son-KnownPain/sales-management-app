package test;

import model.VoucherOfCustomerModel;

public class Test {
    public static void main(String[] args) {
        new VoucherOfCustomerModel().update("Quantity = Quantity - 1", String.format("VoucherCode = '%s' AND CustomerID = %d", "TTBCV0001-V1", 2));
    }
}
