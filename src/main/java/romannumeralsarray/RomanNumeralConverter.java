package romannumeralsarray;

public class RomanNumeralConverter {
    public static String converts(int decimal) {

        String romanNumeral = "";
        if (decimal >= 5) {
            romanNumeral = "V";
        } else if (decimal == 4) {
            romanNumeral = "IV";
        } else if (decimal >= 1) {
            romanNumeral = "I";
        }
        return romanNumeral;
    }
}
