package test;

import db.objects.Supplier;
import java.time.LocalDate;
import java.util.ArrayList;
import model.SuppliersModel;
import supports.MoneyFormat;




public class Test {
    public static void main(String[] args) {
        SuppliersModel suppliersModel = new SuppliersModel();
        ArrayList<String[]> arraylist = suppliersModel.selectAll();
        ArrayList<Supplier> list = SuppliersModel.takeObject(arraylist);
        for (Supplier supplier : list) {
            System.out.println(supplier.getSupplierID());
            
        }
        
    }
}
