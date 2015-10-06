package romannumerals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter converter;

    @Before
    public void setup() {
        converter = new RomanNumeralConverter();
    }

    @Test
    public void converts1ToI() {
        assertEquals(converter.convert(1), "I");
    }

    @Test
    public void converts5ToV() {
        assertEquals(converter.convert(5), "V");
    }

    @Test
    public void converts10ToX() {
        assertEquals(converter.convert(10), "X");
    }

    @Test
    public void converts50ToL() {
        assertEquals(converter.convert(50), "L");
    }
}