package db.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Import {
    private int importID;
    private int supplierID;
    private Date importDateTime;

    public Import(int importID, int supplierID, Date importDateTime) {
        this.importID = importID;
        this.supplierID = supplierID;
        this.importDateTime = importDateTime;
    }
    
    public Import(String[] fields) {
        importID = Integer.parseInt(fields[0]);
        supplierID = Integer.parseInt(fields[1]);
        try {
            importDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(fields[2] + " " + fields[3].split("[.]")[0]);
        } catch (ParseException ex) {
            Logger.getLogger(Import.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getImportID() {
        return importID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public Date getImportDateTime() {
        return importDateTime;
    }

    @Override
    public String toString() {
        return "Imports{" + "importID=" + importID + ", supplierID=" + supplierID + ", importDateTime=" + new SimpleDateFormat("hh:mm:ss dd/MM/yyyy").format(importDateTime) + '}';
    }
    
    
}
