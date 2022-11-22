package controller;

import db.objects.Supplier;
import java.util.ArrayList;
import model.SuppliersModel;

public class ImportController {
    
    
    public static ArrayList<Supplier> getSupplierWithInput(String value){
        SuppliersModel suppliersModel = new SuppliersModel();
        ArrayList<Supplier> suppliers = SuppliersModel.takeObject(suppliersModel.selectWithCondition("CompanyName LIKE '%" + value + "%'"));
        
        return suppliers;
        
    }
}
