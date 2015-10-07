package romannumerals;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralConverter {
    private Map<Integer, String> decimalToRomanNumeral;

    public RomanNumeralConverter() {
        initialiseStandardConversions();
    }

    public String convert(int input) {
        String romanNumeral = directConversionOf(input);
        if (!valid(romanNumeral)) {
            romanNumeral = deriveRomanNumeralsFrom(input);
        }

        return romanNumeral;
    }

    private void initialiseStandardConversions() {
        decimalToRomanNumeral = new HashMap<>();
        decimalToRomanNumeral.put(1, "I");
        decimalToRomanNumeral.put(4, "IV");
        decimalToRomanNumeral.put(5, "V");
        decimalToRomanNumeral.put(9, "IX");
        decimalToRomanNumeral.put(10, "X");
        decimalToRomanNumeral.put(40, "XL");
        decimalToRomanNumeral.put(50, "L");
        decimalToRomanNumeral.put(90, "XC");
        decimalToRomanNumeral.put(100, "C");
        decimalToRomanNumeral.put(400, "CD");
        decimalToRomanNumeral.put(500, "D");
        decimalToRomanNumeral.put(900, "CM");
        decimalToRomanNumeral.put(1000, "M");
    }

    private int calculateRemainingDecimal(int currentDecimal, int decimalInUnitForm) {
        return currentDecimal - decimalInUnitForm;
    }

    private String directConversionOf(int currentDecimal) {
        return decimalToRomanNumeral.get(currentDecimal);
    }

    private String deriveRomanNumeralsFrom(int currentDecimal) {
        String calculatedRomanNumeral = "";
        while (currentDecimal > 0) {
            int derivedDecimal = findNearestConversionLessThan(currentDecimal);
            currentDecimal = calculateRemainingDecimal(currentDecimal, derivedDecimal);
            calculatedRomanNumeral = append(calculatedRomanNumeral, decimalToRomanNumeral.get(derivedDecimal));
        }
        return calculatedRomanNumeral;
    }

    private boolean valid(String romanNumeral) {
        return romanNumeral != null;
    }

    private String append(String numeral, String numeralToAppend) {
        return numeral + numeralToAppend;
    }

    private int findNearestConversionLessThan(int input) {
        int currentKeyLessThanDecimal = 1;
        for (int key : decimalToRomanNumeral.keySet()) {
            if (key > currentKeyLessThanDecimal && key <= input) {
                currentKeyLessThanDecimal = key;
            }
        }
        return currentKeyLessThanDecimal;
    }
}
