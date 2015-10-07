package romannumerals;

import java.util.*;

import static java.util.Arrays.*;

public class RomanNumeralConverter {
    private Map<Integer, String> decimalToRomanNumeral;
    private Map<Integer, List<Integer>> subtractionRules;

    public RomanNumeralConverter() {
        initialiseStandardConversions();
        initialiseDataForSubtractionRules();
    }

    public String convert(int input) {
        int currentDecimal = input;
        String calculatedRomanNumeral = "";

        String romanNumeral = directConversion(currentDecimal);
        if (!converted(romanNumeral)) {

            while (currentDecimal > 0) {

                int decimalInUnitForm = unitFormOf(currentDecimal);
                String convertedNumeral = applySubtractionRulesIfAppropriate(decimalInUnitForm);

                if (!empty(convertedNumeral)) {
                    currentDecimal = calculateRemainingDecimal(currentDecimal, decimalInUnitForm);
                    calculatedRomanNumeral = append(calculatedRomanNumeral, convertedNumeral);
                } else {
                    int derivedDecimal = findNearestConversionLessThan(currentDecimal);
                    currentDecimal = calculateRemainingDecimal(currentDecimal, derivedDecimal);
                    calculatedRomanNumeral = append(calculatedRomanNumeral, decimalToRomanNumeral.get(derivedDecimal));
                }
            }

            romanNumeral = calculatedRomanNumeral;
        }

        return romanNumeral;
    }

    private int calculateRemainingDecimal(int currentDecimal, int decimalInUnitForm) {
        currentDecimal = currentDecimal - decimalInUnitForm;
        return currentDecimal;
    }

    private void initialiseStandardConversions() {
        decimalToRomanNumeral = new HashMap<>();
        decimalToRomanNumeral.put(1, "I");
        decimalToRomanNumeral.put(5, "V");
        decimalToRomanNumeral.put(10, "X");
        decimalToRomanNumeral.put(50, "L");
        decimalToRomanNumeral.put(100, "C");
        decimalToRomanNumeral.put(500, "D");
        decimalToRomanNumeral.put(1000, "M");
    }

    private void initialiseDataForSubtractionRules() {
        subtractionRules = new HashMap<>();
        subtractionRules.put(1, asList(5, 10));
        subtractionRules.put(10, asList(50, 100));
        subtractionRules.put(100, asList(500, 1000));
    }

    private String directConversion(int currentDecimal) {
        return decimalToRomanNumeral.get(currentDecimal);
    }

    private String applySubtractionRulesIfAppropriate(int inputInUnitForm) {

        for (Map.Entry<Integer, List<Integer>> subtractionEntry : subtractionRules.entrySet()) {
            List<Integer> validSubtractionEntries = subtractionEntry.getValue();
            for (Integer valid : validSubtractionEntries) {
                if (valid - subtractionEntry.getKey() == inputInUnitForm) {
                    return directConversion(subtractionEntry.getKey()) + directConversion(valid);
                }
            }
        }
        return "";
    }

    private int unitFormOf(int currentDecimal) {
        String representationOfInput = String.valueOf(currentDecimal);
        int lengthOfInput = representationOfInput.length();
        return getFirstNumber(representationOfInput) * (int)Math.pow(10, lengthOfInput - 1);
    }

    private Integer getFirstNumber(String representationOfInput) {
        return Integer.valueOf(String.valueOf(representationOfInput.charAt(0)));
    }

    private boolean converted(String romanNumeral) {
        return romanNumeral != null;
    }

    private boolean empty(String input) {
        return input == "";
    }

    private String append(String numeral, String appender) {
        return numeral + appender;
    }

    private int findNearestConversionLessThan(int decimal) {
        int currentKeyLessThanDecimal = 1;
        for (int key : decimalToRomanNumeral.keySet()) {
            if (key > currentKeyLessThanDecimal && key <= decimal) {
                currentKeyLessThanDecimal = key;
            }
        }
        return currentKeyLessThanDecimal;
    }
}
