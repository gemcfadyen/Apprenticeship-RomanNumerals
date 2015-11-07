package romannumeralsarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralConverterTest {

    @Test
    public void converts0() {
        assertEquals("", RomanNumeralConverter.converts(0));
    }

    @Test
    public void converts1() {
        assertEquals("I", RomanNumeralConverter.converts(1));
    }

    @Test
    public void converts5() {
        assertEquals("V", RomanNumeralConverter.converts(5));
    }

    @Test
    public void converts4() {
        assertEquals("IV", RomanNumeralConverter.converts(4));
    }
}
