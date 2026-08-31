import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class WrappersParseTest {
    /** Builds an ArrayList<String> from a String[] so each test reads in one line. */
    private static ArrayList<String> toList(String[] values) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
        return list;
    }

    @DisplayName("parseAndAdd(\"2\", \"3\") -> 5, not 23 (convert first, then add)")
    @Test
    void parseAndAdd_Test01() {
        assertEquals(5, Wrappers.parseAndAdd("2", "3"), "parseAndAdd(\"2\", \"3\") -- 23 means you joined the Strings before parsing");
    }

    @DisplayName("parseAndAdd(\"-4\", \"10\") -> 6 (a negative number in a String)")
    @Test
    void parseAndAdd_Test02() {
        assertEquals(6, Wrappers.parseAndAdd("-4", "10"), "parseAndAdd(\"-4\", \"10\")");
    }

    @DisplayName("parseAndAdd(\"0\", \"0\") -> 0 and parseAndAdd(\"100\", \"250\") -> 350")
    @Test
    void parseAndAdd_Test03() {
        assertEquals(0, Wrappers.parseAndAdd("0", "0"), "parseAndAdd(\"0\", \"0\")");
        assertEquals(350, Wrappers.parseAndAdd("100", "250"), "parseAndAdd(\"100\", \"250\")");
    }

    @DisplayName("parseAndAdd(\"2147483646\", \"1\") -> Integer.MAX_VALUE (the biggest int, no overflow yet)")
    @Test
    void parseAndAdd_Test04() {
        assertEquals(Integer.MAX_VALUE, Wrappers.parseAndAdd("2147483646", "1"), "parseAndAdd(\"2147483646\", \"1\")");
    }

    @DisplayName("parseAverage([\"1\", \"2\", \"3\", \"4\"]) -> 2.5 (not 2 -- the average is a double)")
    @Test
    void parseAverage_Test01() {
        assertEquals(2.5, Wrappers.parseAverage(toList(new String[]{"1", "2", "3", "4"})), 0.0001,
            "parseAverage of 1, 2, 3, 4 -- 2.0 means integer division crept in");
    }

    @DisplayName("parseAverage([\"1.5\", \"2.5\"]) -> 2.0 (decimal Strings need Double.parseDouble)")
    @Test
    void parseAverage_Test02() {
        assertEquals(2.0, Wrappers.parseAverage(toList(new String[]{"1.5", "2.5"})), 0.0001, "parseAverage([\"1.5\", \"2.5\"])");
    }

    @DisplayName("parseAverage([\"90\", \"85.5\", \"77\"]) -> 84.1666...")
    @Test
    void parseAverage_Test03() {
        assertEquals(84.16667, Wrappers.parseAverage(toList(new String[]{"90", "85.5", "77"})), 0.001, "parseAverage of 90, 85.5, 77");
    }

    @DisplayName("parseAverage([\"4.25\"]) -> 4.25 (one element) and parseAverage([\"-1\", \"1\"]) -> 0.0")
    @Test
    void parseAverage_Test04() {
        assertEquals(4.25, Wrappers.parseAverage(toList(new String[]{"4.25"})), 0.0001, "parseAverage([\"4.25\"])");
        assertEquals(0.0, Wrappers.parseAverage(toList(new String[]{"-1", "1"})), 0.0001, "parseAverage([\"-1\", \"1\"])");
    }

    @DisplayName("isMaxValue(Integer.MAX_VALUE) -> true and isMaxValue(2147483647) -> true")
    @Test
    void isMaxValue_Test01() {
        assertTrue(Wrappers.isMaxValue(Integer.MAX_VALUE), "isMaxValue(Integer.MAX_VALUE)");
        assertTrue(Wrappers.isMaxValue(2147483647), "isMaxValue(2147483647)");
    }

    @DisplayName("isMaxValue(0), isMaxValue(-1) and isMaxValue(Integer.MIN_VALUE) -> false")
    @Test
    void isMaxValue_Test02() {
        assertFalse(Wrappers.isMaxValue(0), "isMaxValue(0)");
        assertFalse(Wrappers.isMaxValue(-1), "isMaxValue(-1)");
        assertFalse(Wrappers.isMaxValue(Integer.MIN_VALUE), "isMaxValue(Integer.MIN_VALUE)");
    }

    @DisplayName("isMaxValue(Integer.MAX_VALUE - 1) -> false (one short is not the max)")
    @Test
    void isMaxValue_Test03() {
        assertFalse(Wrappers.isMaxValue(Integer.MAX_VALUE - 1), "isMaxValue(Integer.MAX_VALUE - 1)");
    }

    @DisplayName("isMaxValue(Integer.MIN_VALUE - 1) -> true (overflow wraps all the way around)")
    @Test
    void isMaxValue_Test04() {
        assertTrue(Wrappers.isMaxValue(Integer.MIN_VALUE - 1),
            "Integer.MIN_VALUE - 1 wraps around to Integer.MAX_VALUE -- that is overflow, and it fails silently");
    }
}
