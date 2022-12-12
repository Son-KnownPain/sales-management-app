package controller;

import db.objects.SellDetail;
import java.time.LocalDate;
import java.util.ArrayList;
import model.ImportDetailsModel;
import model.ImportsModel;
import model.SellDetailsModel;
import model.SellsModel;

public class HistoryController {

    public static ArrayList<String[]> getHistorySell(LocalDate startDate, LocalDate endDate, int startPrice, int endPrice) {
        SellsModel sellsModel = new SellsModel();
        String query = String.format("SELECT TOP 200  "
                + "S.SellID, (SELECT CustomerName FROM Customers WHERE CustomerID = S.CustomerID) AS CustomerName,  "
                + "S.SellDate, S.SellTime, SUM(SD.TotalPrice) AS PriceToPay, "
                + "(SELECT VoucherValue FROM Vouchers WHERE VoucherCode = S.VoucherCode) AS DiscountValue, COUNT(SD.SellID) AS NumberOfProduct "
                + "FROM Sells AS S JOIN SellDetails AS SD ON S.SellID = SD.SellID "
                + "WHERE SellDate >= '%s' AND SellDate <= '%s' "
                + "GROUP BY S.SellID, S.SellDate, S.SellTime, S.CustomerID, S.VoucherCode "
                + "HAVING SUM(SD.TotalPrice) >= %d  AND SUM(SD.TotalPrice) <= %d "
                + "ORDER BY SellID DESC",
                startDate.toString(),
                endDate.toString(),
                startPrice,
                endPrice
        );
        return sellsModel.run(7, query);
    }

    public static ArrayList<String[]> getHistoryImport(LocalDate startDate, LocalDate endDate, int startPrice, int endPrice) {
        ImportsModel importsModel = new ImportsModel();
        String query = String.format(
                "SELECT TOP 200 I.ImportID, ImportDate, ImportTime, SUM(ID.TotalPrice) AS PriceToPay, "
                + "SUM(ID.DiscountMoney) AS DiscountValue, COUNT(ID.ImportID) AS NumberOfProduct  "
                + "FROM Imports AS I JOIN ImportDetails AS ID ON I.ImportID = ID.ImportID "
                + "WHERE ImportDate >= '%s' AND ImportDate <= '%s' "
                + "GROUP BY I.ImportID, ImportDate, ImportTime "
                + "HAVING SUM(ID.TotalPrice) >= %d  AND SUM(ID.TotalPrice) <= %d "
                + "ORDER BY ImportID DESC ",
                startDate.toString(),
                endDate.toString(),
                startPrice,
                endPrice
        );
        return importsModel.run(6, query);
    }
    
    public static ArrayList<String[]> getSellDetailsByID(int id) {
        SellDetailsModel sellDetailsModel = new SellDetailsModel();
        return sellDetailsModel.selectTop(
                "(SELECT ProductName FROM Products WHERE ProductID = SellDetails.ProductID), TotalPrice, ProductQuantity, (SELECT UnitPerQuantity FROM Products WHERE ProductID = SellDetails.ProductID)",
                4,
                "WHERE SellID = " + id
        );
    }
    
    public static ArrayList<String[]> getImportDetailByID(int id) {
        ImportDetailsModel importDetailsModel = new ImportDetailsModel();
        return importDetailsModel.selectTop(
                "(SELECT ProductName FROM Products WHERE ProductID = ImportDetails.ProductID), (SELECT CompanyName FROM Suppliers WHERE SupplierID = ImportDetails.SupplierID),Quantity, TotalPrice, DiscountMoney", 
                5, 
                "WHERE ImportID = " + id
        );
    }
}
