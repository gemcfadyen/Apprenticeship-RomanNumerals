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
    }

    public String convert(int decimal) {
        return decimalToRomanNumeral.get(decimal);
    }
}
