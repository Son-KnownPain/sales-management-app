package supports;

import java.util.Calendar;

public class Validation {

    // Index 0: boolean result validate, index 1: String message
    public static Object[] isDate(String pattern) {
        Object[] result = new Object[2];
        String[] date = pattern.split("[/]");

        String day = date[0];
        String month = date[1];
        String year = date[2];

        int monthNum = Integer.parseInt(month);
        int dayNum = Integer.parseInt(day);
        int yearNum = Integer.parseInt(year);
        int validDayOfMonth = 0;
        switch (monthNum) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                validDayOfMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                validDayOfMonth = 30;
                break;
            case 2:
                if (isLeapYear(yearNum)) {
                    validDayOfMonth = 29;
                } else {
                    validDayOfMonth = 28;
                }
                break;
        }
        
        if (monthNum < 1 || monthNum > 12) {
            result[0] = false;
            result[1] = "Month must be greater than 0 and less than 13";
            return result;
        }

        if (dayNum < 1 || dayNum > validDayOfMonth) {
            result[0] = false;
            result[1] = "Day of month must be greater than 0 and less than " + (validDayOfMonth + 1);
            return result;
        }

        if (yearNum < 1) {
            result[0] = false;
            result[1] = "Year must be greater than 0";
            return result;
        }

        result[0] = true;
        result[1] = "";
        return result;
    }

    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }
}
