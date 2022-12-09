package supports;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberFormat {
    public static String getMoneyFormat(String value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
        
        return decimalFormat.format(Integer.parseInt(value));
    }
    
    public static String getMoneyFormat(float value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##", symbols);
        
        return decimalFormat.format(value);
    }
    
    public static String getMoneyFormat(int value) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
        
        return decimalFormat.format(value);
    }
    
    public static String getKMAfter(int value) {
        if (value >= 1000 && value < 1000000) {
            int newValue = value / 1000;
            return getMoneyFormat(newValue) + "K";
        } else if (value >= 1000000) {
            return getMoneyFormat((float) value / 1000000) + "M";
        }
        return value + "";
    }
    
    public static String getHMSTime(String time) {
        String[] timeDivision = time.split("[:]");
        return timeDivision[0] + "h " + timeDivision[1] + "p " + timeDivision[2] + "s";
    }
}
