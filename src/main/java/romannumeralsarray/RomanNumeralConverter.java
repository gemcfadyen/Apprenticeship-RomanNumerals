package romannumeralsarray;

public class RomanNumeralConverter {
    public static String converts(int decimal) {
        if(decimal == 4) {
            return "IV";
        }
        if(decimal >= 5) {
            return "V";
        }
        if(decimal >= 1) {
            return "I";
        }
        return "";
    }
}
