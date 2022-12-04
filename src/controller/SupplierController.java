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
}
