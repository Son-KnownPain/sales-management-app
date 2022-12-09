package test;

import supports.Validation;

public class Test {
    public static void main(String[] args) {
        Object[] s = Validation.isDate("29/2/2024");
        System.out.println("1: " + s[0] + ", 2: " + s[1]);
        
        System.out.println("Is leap year: " + Validation.isLeapYear(2024));
    }
}
