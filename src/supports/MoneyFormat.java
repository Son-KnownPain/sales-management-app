package supports;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MoneyFormat {
    public static String getMoneyFormat(String value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
        
        return decimalFormat.format(Integer.parseInt(value));
    }
    
    public static String getMoneyFormat(int value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
        
        return decimalFormat.format(value);
    }
}
