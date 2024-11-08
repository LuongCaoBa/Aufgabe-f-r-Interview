package string_analyzer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Map;

public class StringAnalyzerTest {

    @Test
    public void testValidInput1() {
        Map<String, Integer> result = StringAnalyzer.analyzeString("Hello123");
        assertEquals(Integer.valueOf(2), result.get("Vokale"));
        assertEquals(Integer.valueOf(3), result.get("Konsonanten"));
        assertEquals(Integer.valueOf(3), result.get("Ziffern"));
    }

    @Test
    public void testValidInput2() {
        Map<String, Integer> result = StringAnalyzer.analyzeString("Al0");
        assertEquals(Integer.valueOf(1), result.get("Vokale"));
        assertEquals(Integer.valueOf(1), result.get("Konsonanten"));
        assertEquals(Integer.valueOf(1), result.get("Ziffern"));
    }

    @Test
    public void testOnlyLetters() {
        Map<String, Integer> result = StringAnalyzer.analyzeString("World");
        assertEquals(Integer.valueOf(1), result.get("Vokale"));
        assertEquals(Integer.valueOf(4), result.get("Konsonanten"));
        assertEquals(Integer.valueOf(0), result.get("Ziffern"));
    }

    @Test
    public void testOnlyDigits() {
        Map<String, Integer> result = StringAnalyzer.analyzeString("12345");
        assertEquals(Integer.valueOf(0), result.get("Vokale"));
        assertEquals(Integer.valueOf(0), result.get("Konsonanten"));
        assertEquals(Integer.valueOf(5), result.get("Ziffern"));
    }

    @Test
    public void testShortString() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringAnalyzer.analyzeString("Hi");
        });
    }


    @Test
    public void testInvalidCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringAnalyzer.analyzeString("Test!");
        });
    }

    @Test
    public void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringAnalyzer.analyzeString("");
        });
    }

    @Test
    public void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringAnalyzer.analyzeString(null);
        });
    }
}