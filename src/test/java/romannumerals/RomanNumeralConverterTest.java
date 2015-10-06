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

    @Test
    public void converts100ToC() {
        assertEquals(converter.convert(100), "C");
    }

    @Test
    public void converts500ToD() {
        assertEquals(converter.convert(500), "D");
    }

    @Test
    public void converts1000ToM() {
        assertEquals(converter.convert(1000), "M");
    }
}