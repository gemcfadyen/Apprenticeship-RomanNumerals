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

    /**
     * while !- 0
     * do direct lookup
     * do special cases
     * do usual
     */

    private String findDirectConversionIfAvailable(int input) {
        String romanNumeral = decimalToRomanNumeral.get(input);
        if (noDirectTranslationFoundFor(romanNumeral)) {
            romanNumeral = "";
        }
        return romanNumeral;
    }

    public String convert(int input) {
        int currentDecimal = input;
        String romanNumeral = decimalToRomanNumeral.get(currentDecimal);

        if (noDirectTranslationFoundFor(romanNumeral)) {
            String calculatedRomanNumeral = new String();

            while (currentDecimal > 0) {

                int currentDecimalInUnitForm = determineNumberAsItsUnit(currentDecimal);
                System.out.println("Number in its unit is: " + currentDecimalInUnitForm);
                String subtractionResult = applySubtractionRule(currentDecimalInUnitForm);
                if (subtractionResult != "") {
                    calculatedRomanNumeral = calculatedRomanNumeral + subtractionResult;
                    currentDecimal = currentDecimal - currentDecimalInUnitForm;
                    if (currentDecimal == 0) {
                        return calculatedRomanNumeral;
                    }
                } else {

                    int derivedDecimal = findTheKeyLessThanOrEqualTo(currentDecimal);
                    currentDecimal = currentDecimal - derivedDecimal;
                    calculatedRomanNumeral = calculatedRomanNumeral + decimalToRomanNumeral.get(derivedDecimal);
                }
            }

            romanNumeral = calculatedRomanNumeral;
        }

        return romanNumeral;
    }


    private void initialiseStandardConversions() {
        decimalToRomanNumeral = new HashMap();
        decimalToRomanNumeral.put(1, "I");
        decimalToRomanNumeral.put(5, "V");
        decimalToRomanNumeral.put(10, "X");
        decimalToRomanNumeral.put(50, "L");
        decimalToRomanNumeral.put(100, "C");
        decimalToRomanNumeral.put(500, "D");
        decimalToRomanNumeral.put(1000, "M");
    }

    private void initialiseDataForSubtractionRules() {
        subtractionRules = new HashMap();
        subtractionRules.put(1, asList(5, 10));
        subtractionRules.put(10, asList(50, 100));
        subtractionRules.put(100, asList(500, 1000));
    }
    
    private String applySubtractionRule(int inputInUnitForm) {

        for (Map.Entry<Integer, List<Integer>> subtractionEntry : subtractionRules.entrySet()) {
            List<Integer> validSubtractionEntries = subtractionEntry.getValue();
            for (Integer valid : validSubtractionEntries) {
                if (valid - subtractionEntry.getKey() == inputInUnitForm) {
                    System.out.println("Subtraction rule applied " + decimalToRomanNumeral.get(subtractionEntry.getKey()) + decimalToRomanNumeral.get(valid));
                    return decimalToRomanNumeral.get(subtractionEntry.getKey()) + decimalToRomanNumeral.get(valid);
                }
            }
        }
        return "";

    }

    private int determineNumberAsItsUnit(int currentDecimal) {
        Integer input = Integer.valueOf(currentDecimal);

        String representationOfInput = String.valueOf(input);

        int lengthOfInput = representationOfInput.length();
        if (lengthOfInput == 2) {
            System.out.println("Tens...");
            return 10 * Integer.valueOf(String.valueOf(representationOfInput.charAt(0)));
        } else if (lengthOfInput == 3) {
            System.out.println("Hundreds...");
            return 100 * Integer.valueOf(String.valueOf(representationOfInput.charAt(0)));
        } else if (lengthOfInput == 4) {
            System.out.println("Thousands...");
            return 1000 * Integer.valueOf(String.valueOf(representationOfInput.charAt(0)));
        } else {
            System.out.println("Not Applicable for rounding to unit...");
            return currentDecimal;
        }
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
