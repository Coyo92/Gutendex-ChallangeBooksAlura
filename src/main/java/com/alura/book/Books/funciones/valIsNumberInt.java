package com.alura.book.Books.funciones;

public class valIsNumberInt {

    public static boolean isNumberDouble(String n) {
        try {
            Double.parseDouble(n);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean isNumberInt(String n) {
        try {
            Integer.parseInt (n);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
