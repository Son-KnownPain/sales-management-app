package controller;

import db.objects.Supplier;
import model.SuppliersModel;

public class SupplierController {

    public static boolean editSupplier(Supplier supplier) {
        SuppliersModel suppliersModel = new SuppliersModel();
        return suppliersModel.updateByID(
                String.format(
                        "CompanyName = '%s', Address = '%s', Phone = '%s', Email = '%s', PostalCode = '%s'",
                        supplier.getCompanyName(),
                        supplier.getAddress(),
                        supplier.getPhone(),
                        supplier.getEmail(),
                        supplier.getPostalCode()
                ),
                supplier.getSupplierID()
        );
    }
    
    public static boolean addSupplier(String name, String address, String phone, String email, String postalCode){
        SuppliersModel suppliersModel = new SuppliersModel();
         boolean result = suppliersModel.insertOne(String.format(
                "'%s', '%s', '%s', '%s', '%s'",
                name,
                address,
                phone,
                email,
                postalCode
                
        ));
        return result;
    }
}
