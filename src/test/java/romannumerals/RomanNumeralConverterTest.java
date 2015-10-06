package romannumerals;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    @Test
    public void converts1ToI() {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals(converter.convert(1), "I");
    }

    @Test
    public void converts5ToV() {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals(converter.convert(5), "V");
    }

    @Test
    public void converts10ToX() {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals(converter.convert(10), "X");
    }
}