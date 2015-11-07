package romannumeralsarray;

public class RomanNumeralConverter {
    public static String converts(int decimal) {
        String[] numerals = new String[] {"V", "IV", "I"};
        int[] decimals = new int[] {5, 4, 1};

        String romanNumeral = "";

        if (decimal >= decimals[0]) {
            romanNumeral = numerals[0];
        } else if (decimal == decimals[1]) {
            romanNumeral = numerals[1];
        } else if (decimal >= decimals[2]) {
            romanNumeral = numerals[2];
        }
        return romanNumeral;
    }
}
