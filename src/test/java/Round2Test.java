import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Round2Test {
    @DisplayName("round2(3.14159) -> 3.14")
    @Test
    void round2_Test01() {
        assertEquals(3.14, Rounding.round2(3.14159), 0.0001, "round2(3.14159)");
    }

    @DisplayName("round2(19.999) -> 20.0 (rounds up across a whole number)")
    @Test
    void round2_Test02() {
        assertEquals(20.0, Rounding.round2(19.999), 0.0001, "round2(19.999)");
    }

    @DisplayName("round2(7.125) -> 7.13 (a half cent rounds up)")
    @Test
    void round2_Test03() {
        assertEquals(7.13, Rounding.round2(7.125), 0.0001, "round2(7.125)");
    }

    @DisplayName("round2(-2.346) -> -2.35 (negatives round to the nearest cent too)")
    @Test
    void round2_Test04() {
        assertEquals(-2.35, Rounding.round2(-2.346), 0.0001, "round2(-2.346)");
    }

    @DisplayName("round2(12.345) -> 12.35 -- NOT 12.0 (catches Math.round(x*100)/100 integer division)")
    @Test
    void round2_Test05() {
        assertEquals(12.35, Rounding.round2(12.345), 0.0001,
            "round2(12.345) -- if you got 12.0 you divided a long by the int 100; divide by 100.0");
    }

    @DisplayName("round2(2.5) -> 2.5 (a value already at two decimals is unchanged)")
    @Test
    void round2_Test06() {
        assertEquals(2.5, Rounding.round2(2.5), 0.0001, "round2(2.5)");
    }

    @DisplayName("round2(0.0) -> 0.0 and round2(0.005) -> 0.01")
    @Test
    void round2_Test07() {
        assertEquals(0.0, Rounding.round2(0.0), 0.0001, "round2(0.0)");
        assertEquals(0.01, Rounding.round2(0.005), 0.0001, "round2(0.005)");
    }

    @DisplayName("round2(99.995) -> 100.0")
    @Test
    void round2_Test08() {
        assertEquals(100.0, Rounding.round2(99.995), 0.0001, "round2(99.995)");
    }
}
