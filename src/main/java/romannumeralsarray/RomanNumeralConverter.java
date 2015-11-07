package romannumeralsarray;

public class RomanNumeralConverter {
    public static String converts(int decimal) {

        if (decimal >= 5) {
            return "V";
        } else if (decimal == 4) {
            return "IV";
        } else if (decimal >= 1) {
            return "I";
        }
        return "";
    }
}
