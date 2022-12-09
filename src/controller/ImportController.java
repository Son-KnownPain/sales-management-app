package controller;

import db.objects.Supplier;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import model.ImportDetailsModel;
import model.ImportsModel;
import model.ProductsModel;
import model.SuppliersModel;

public class ImportController {
    
    public static ArrayList<Supplier> getSupplierWithInput(String value){
        SuppliersModel suppliersModel = new SuppliersModel();
        ArrayList<Supplier> suppliers = SuppliersModel.takeObject(suppliersModel.selectWithCondition("CompanyName LIKE '%" + value + "%'"));
        
        return suppliers;
        
    }
    
    public static Supplier getSupplierByID(int id) {
        SuppliersModel suppliersModel = new SuppliersModel();
        ArrayList<Supplier> suppliers = SuppliersModel.takeObject(suppliersModel.selectWithCondition("SupplierID = " + id));
        if (!suppliers.isEmpty()) {
            return suppliers.get(0);
        } else {
            return null;
        }
    }
    
    public static boolean confirmImport(
            ArrayList<Integer> productIds, 
            HashMap<Integer, Integer> selectedProduct, 
            HashMap<Integer, Integer> supplierOfProduct, 
            HashMap<Integer, Integer> discountsOfProduct,
            HashMap<Integer, Integer> totalPriceOfProduct
    ) 
    {
        /**
         * Các bảng: import, import details, products
         * 1. Chèn 1 import
         * 2. Chèn nhiều import details
         * 3. Thêm số lượng vừa mua vào kho QuantityInStore
         */
        
        // Tạo các models
        ImportsModel importsModel = new ImportsModel();
        ImportDetailsModel importDetailsModel = new ImportDetailsModel();
        ProductsModel productsModel = new ProductsModel();
        
        // Thêm record import đầu tiên
        // Tạo các LocalDate date và time
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        
        boolean insertImportResult = importsModel.insertOne(String.format(
                "'%s', '%s'", 
                dateNow.toString(),
                timeNow.toString()
        ));
        if (!insertImportResult) return insertImportResult;
        
        // Thêm record của import details và QuantityInStore của products
        // Lập qua từng product id và insert 1 detail
        for (Integer productId : productIds) {
            boolean resultDetail = importDetailsModel.insertOne(
                    String.format(
                            "(SELECT MAX(ImportID) FROM Imports), %d, %d, %d, %d, %d",
                            productId,
                            supplierOfProduct.get(productId),
                            selectedProduct.get(productId),
                            discountsOfProduct.get(productId),
                            totalPriceOfProduct.get(productId)
                    )
            );
            
            boolean resultQuantityProduct = productsModel.update(
                    "QuantityInStore = QuantityInStore + " + selectedProduct.get(productId), 
                    "ProductID = " + productId
            );
            
            if (!resultDetail || !resultQuantityProduct) {
                return false;
            }
        }
        
        return true;
    }
}
