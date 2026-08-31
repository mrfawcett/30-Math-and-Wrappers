import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RoundToIntChopTest {
    @DisplayName("4.7: roundToInt -> 5 but chop -> 4 (a cast chops, Math.round rounds)")
    @Test
    void roundChop_Test01() {
        assertEquals(5, Rounding.roundToInt(4.7), "roundToInt(4.7) should round to the nearest whole number");
        assertEquals(4, Rounding.chop(4.7), "chop(4.7) should drop the decimal part");
    }

    @DisplayName("4.2: roundToInt -> 4 and chop -> 4 (they agree below the half)")
    @Test
    void roundChop_Test02() {
        assertEquals(4, Rounding.roundToInt(4.2), "roundToInt(4.2)");
        assertEquals(4, Rounding.chop(4.2), "chop(4.2)");
    }

    @DisplayName("4.99: roundToInt -> 5 but chop -> 4 (4.99 becomes 4 when you cast, every time)")
    @Test
    void roundChop_Test03() {
        assertEquals(5, Rounding.roundToInt(4.99), "roundToInt(4.99)");
        assertEquals(4, Rounding.chop(4.99), "chop(4.99)");
    }

    @DisplayName("-4.7: roundToInt -> -5 but chop -> -4 (a cast goes toward zero)")
    @Test
    void roundChop_Test04() {
        assertEquals(-5, Rounding.roundToInt(-4.7), "roundToInt(-4.7)");
        assertEquals(-4, Rounding.chop(-4.7), "chop(-4.7) -- casting truncates toward zero, it does not floor");
    }

    @DisplayName("-4.2: roundToInt -> -4 and chop -> -4")
    @Test
    void roundChop_Test05() {
        assertEquals(-4, Rounding.roundToInt(-4.2), "roundToInt(-4.2)");
        assertEquals(-4, Rounding.chop(-4.2), "chop(-4.2)");
    }

    @DisplayName("4.5: roundToInt -> 5 (a half rounds up) but chop -> 4")
    @Test
    void roundChop_Test06() {
        assertEquals(5, Rounding.roundToInt(4.5), "roundToInt(4.5) -- Math.round sends .5 up");
        assertEquals(4, Rounding.chop(4.5), "chop(4.5)");
    }

    @DisplayName("0.5 and 0.49: roundToInt -> 1 and 0; chop -> 0 and 0")
    @Test
    void roundChop_Test07() {
        assertEquals(1, Rounding.roundToInt(0.5), "roundToInt(0.5)");
        assertEquals(0, Rounding.roundToInt(0.49), "roundToInt(0.49)");
        assertEquals(0, Rounding.chop(0.5), "chop(0.5)");
        assertEquals(0, Rounding.chop(0.49), "chop(0.49)");
    }

    @DisplayName("whole numbers are unchanged: roundToInt(7.0) -> 7 and chop(7.0) -> 7")
    @Test
    void roundChop_Test08() {
        assertEquals(7, Rounding.roundToInt(7.0), "roundToInt(7.0)");
        assertEquals(7, Rounding.chop(7.0), "chop(7.0)");
    }

    @DisplayName("big values survive the cast: roundToInt(123456.6) -> 123457 and chop(123456.6) -> 123456")
    @Test
    void roundChop_Test09() {
        assertEquals(123457, Rounding.roundToInt(123456.6), "roundToInt(123456.6)");
        assertEquals(123456, Rounding.chop(123456.6), "chop(123456.6)");
    }
}
