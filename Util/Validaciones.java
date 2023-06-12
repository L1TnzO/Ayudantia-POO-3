package Util;

public class Validaciones {
    public static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean estaEnRango(int num, int min, int max) {
        return num >= min && num <= max;
    }
}

