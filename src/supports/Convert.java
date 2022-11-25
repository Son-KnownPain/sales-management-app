package supports;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Convert {
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
