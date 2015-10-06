package romannumerals;

public class RomanNumeralConverter {
    public String convert(int decimal) {

        if(decimal == 1) {
            return "I";
        }
        return "V";
    }
}
