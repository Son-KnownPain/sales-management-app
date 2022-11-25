package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Test {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDate now = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate date;
        date = LocalDate.parse("2022-11-26");
        
        System.out.println(date.toString());
        
    }
}
