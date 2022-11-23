package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Test {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.ms");  
        LocalDateTime now = LocalDateTime.now();
        String[] dateTimes = dtf.format(now).split(" ");
        
        System.out.println(dateTimes[1]);
    }
}
