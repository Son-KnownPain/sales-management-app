package test;

import java.time.LocalDate;
import supports.MoneyFormat;



public class Test {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate aWeekAgo = now.minusDays(6);
        System.out.println(aWeekAgo);
    }
}
