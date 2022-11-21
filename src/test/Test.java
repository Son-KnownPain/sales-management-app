package test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class Test {
    public static void main(String[] args) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
        
        System.out.println(decimalFormat.format(12300000));
    }
}
