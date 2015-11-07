package romannumeralsarray;

public class RomanNumeralConverter {
    public static String converts(int decimal) {
        String[] numerals = new String[] {"V", "IV", "I"};
        int[] decimals = new int[] {5, 4, 1};

        String romanNumeral = "";

        for(int i = 0; i < decimals.length; i++) {
            if (decimal >= decimals[i]) {
                romanNumeral = numerals[i];
                decimal -= decimals[i];
            }
        }
        return romanNumeral;
    }
}
