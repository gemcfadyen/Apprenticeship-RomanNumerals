package romannumerals;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralConverterTest {

    @Test
    public void converts1ToI() {
        RomanNumeralConverter converter = new RomanNumeralConverter();
        assertEquals(converter.convert(1), "I");
    }

}