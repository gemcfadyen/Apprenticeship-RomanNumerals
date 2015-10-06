package romannumerals;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {
    private Map<Integer, String> decimalToRomanNumeral;

    public RomanNumeralConverter() {
        decimalToRomanNumeral = new HashMap();
        decimalToRomanNumeral.put(1, "I");
        decimalToRomanNumeral.put(5, "V");
        decimalToRomanNumeral.put(10, "X");
        decimalToRomanNumeral.put(50, "L");
        decimalToRomanNumeral.put(100, "C");
        decimalToRomanNumeral.put(500, "D");
        decimalToRomanNumeral.put(1000, "M");
    }

    public String convert(int input) {
        String romanNumeral = decimalToRomanNumeral.get(input);

        if (noDirectTranslationFoundFor(romanNumeral)) {
            int currentDecimal = input;
            String calculatedRomanNumeral = new String();

            while (currentDecimal > 0) {
                int derivedDecimal = findTheKeyLessThanOrEqualTo(currentDecimal);

                currentDecimal = currentDecimal - derivedDecimal;
                calculatedRomanNumeral = calculatedRomanNumeral + decimalToRomanNumeral.get(derivedDecimal);
            }

            romanNumeral = calculatedRomanNumeral;
        }

        return romanNumeral;
    }

    private boolean noDirectTranslationFoundFor(String romanNumeral) {
        return romanNumeral == null;
    }

    private int findTheKeyLessThanOrEqualTo(int decimal) {
        int currentKeyLessThanDecimal = 1;
        for (int key : decimalToRomanNumeral.keySet()) {
            if (key >= currentKeyLessThanDecimal && key <= decimal) {
                currentKeyLessThanDecimal = key;
            }
        }
        return currentKeyLessThanDecimal;
    }
}
