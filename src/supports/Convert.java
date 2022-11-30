package supports;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Convert {
    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    public static Date toDate(String input) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(input);
        } catch (ParseException ex) {
            Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int toInt(String money) {
        String[] moneys = money.split("[.]");
        return Integer.parseInt(String.join("", moneys));
    }
}
