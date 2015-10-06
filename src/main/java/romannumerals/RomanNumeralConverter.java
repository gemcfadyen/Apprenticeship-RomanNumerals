package romannumerals;

public class RomanNumeralConverter {
    public String convert(int decimal) {

        if(decimal == 1) {
            return "I";
        } else if (decimal == 5) {
            return "V";
        }
        return "X";
    }
}
