package romannumeralsarray;

public class RomanNumeralConverter {
    public static String converts(int decimal) {
        String[] numerals = new String[] {"V"};
        int[] decimals = new int[] {5};

        String romanNumeral = "";

        if (decimal >= decimals[0]) {
            romanNumeral = numerals[0];
        } else if (decimal == 4) {
            romanNumeral = "IV";
        } else if (decimal >= 1) {
            romanNumeral = "I";
        }
        return romanNumeral;
    }
}
