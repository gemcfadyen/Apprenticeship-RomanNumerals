package romannumeralsUsingMap;

import org.junit.Before;
import org.junit.Test;
import romannumeralsmap.RomanNumeralConverter;

import static org.junit.Assert.assertEquals;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter;

    @Before
    public void setup() {
        converter = new RomanNumeralConverter();
    }

    @Test
    public void convertsDecimalsWithMatchingRomanNumerals() {
        assertEquals(converter.convert(1), "I");
        assertEquals(converter.convert(5), "V");
        assertEquals(converter.convert(10), "X");
        assertEquals(converter.convert(50), "L");
        assertEquals(converter.convert(100), "C");
        assertEquals(converter.convert(500), "D");
        assertEquals(converter.convert(1000), "M");
    }

    @Test
    public void convertsDecimalByAppendingRomanNumerals() {
        assertEquals(converter.convert(2), "II");
        assertEquals(converter.convert(3), "III");
        assertEquals(converter.convert(7), "VII");
        assertEquals(converter.convert(11), "XI");
        assertEquals(converter.convert(20), "XX");
        assertEquals(converter.convert(2008), "MMVIII");
    }

    @Test
    public void convertsDecimalsRequiringSubtractionLogic() {
        assertEquals(converter.convert(4), "IV");
        assertEquals(converter.convert(9), "IX");
        assertEquals(converter.convert(90), "XC");
        assertEquals(converter.convert(900), "CM");
        assertEquals(converter.convert(990), "CMXC");
        assertEquals(converter.convert(1990), "MCMXC");
        assertEquals(converter.convert(3999), "MMMCMXCIX");
    }

}