package romannumeralsarray;

public class RomanNumeralConverter {
    public static String converts(int decimal) {
        String[] numerals = new String[] {"V", "IV"};
        int[] decimals = new int[] {5, 4};

        String romanNumeral = "";

        if (decimal >= decimals[0]) {
            romanNumeral = numerals[0];
        } else if (decimal == decimals[1]) {
            romanNumeral = numerals[1];
        } else if (decimal >= 1) {
            romanNumeral = "I";
        }
        return romanNumeral;
    }
}
