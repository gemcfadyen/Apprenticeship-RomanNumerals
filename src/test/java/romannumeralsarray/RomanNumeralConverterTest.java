package romannumeralsarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralConverterTest {

    @Test
    public void converts0() {
        assertEquals("", RomanNumeralConverter.converts(0));
    }
}
