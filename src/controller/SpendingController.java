package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ImportsModel;
import model.SellsModel;

public class SpendingController {

    public static ArrayList<Date> getDateOfSpending() {

        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<Date> result = new ArrayList<>();

        try {
            SellsModel sellsModel = new SellsModel();
            String minDateSellString = sellsModel.run(1, "SELECT MIN(SellDate) FROM Sells").get(0)[0];
            String maxDateSellString = sellsModel.run(1, "SELECT MAX(SellDate) FROM Sells").get(0)[0];

            ImportsModel importsModel = new ImportsModel();
            String minDateImportString = importsModel.run(1, "SELECT MIN(ImportDate) FROM Imports").get(0)[0];
            String maxDateImportString = importsModel.run(1, "SELECT MAX(ImportDate) FROM Imports").get(0)[0];

            Date minDateSell = dateParser.parse(minDateSellString);
            Date maxDateSell = dateParser.parse(maxDateSellString);

            Date minDateImport = dateParser.parse(minDateImportString);
            Date maxDateImport = dateParser.parse(maxDateImportString);

            result.add(minDateSell);
            result.add(maxDateSell);
            result.add(minDateImport);
            result.add(maxDateImport);

        } catch (ParseException ex) {
            Logger.getLogger(SpendingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static int getSalesMoney(LocalDate startDate, LocalDate endDate) {
        SellsModel sellsModel = new SellsModel();
        String query = String.format(
                "SELECT SUM(SD.TotalPrice) AS SalesMoney "
                + "FROM Sells AS S JOIN SellDetails AS SD ON S.SellID = SD.SellID "
                + "WHERE SellDate >= '%s' AND SellDate <= '%s' ",
                startDate.toString(),
                endDate.toString()
        );
        int result = 0;
        try {
            result = Integer.parseInt(sellsModel.run(1, query).get(0)[0]);
        } catch (Exception e) {
            // When can not get
        }
        return result;
    }

    public static int getImportCost(LocalDate startDate, LocalDate endDate) {
        ImportsModel importsModel = new ImportsModel();
        String query = String.format(
                "SELECT SUM(ID.TotalPrice) - SUM(DiscountMoney) AS PriceToPay "
                + "FROM Imports AS I JOIN ImportDetails AS ID ON I.ImportID = ID.ImportID "
                + "WHERE ImportDate >= '%s' AND ImportDate <= '%s' ",
                startDate.toString(),
                endDate.toString()
        );
        int result = 0;
        try {
            result = Integer.parseInt(importsModel.run(1, query).get(0)[0]);
        } catch (Exception e) {
        }
        return result;
    }

    public static int getVoucherCost(LocalDate startDate, LocalDate endDate) {
        SellsModel sellsModel = new SellsModel();
        String query = String.format(
                "SELECT SUM(V.VoucherValue) AS TotalVoucherValue "
                + "FROM Sells AS S JOIN SellDetails AS SD ON S.SellID = SD.SellID "
                + "JOIN Vouchers AS V ON V.VoucherCode = S.VoucherCode "
                + "WHERE S.VoucherCode IS NOT NULL AND SellDate >= '%s' AND SellDate <= '%s' ",
                startDate.toString(),
                endDate.toString()
        );
        int result = 0;
        try {
            result = Integer.parseInt(sellsModel.run(1, query).get(0)[0]);
        } catch (Exception e) {
        }
        return result;
    }
}
