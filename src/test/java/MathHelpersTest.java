import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MathHelpersTest {
    @DisplayName("hypotenuse(3, 4) -> 5.0 and hypotenuse(5, 12) -> 13.0")
    @Test
    void hypotenuse_Test01() {
        assertEquals(5.0, Rounding.hypotenuse(3, 4), 0.0001, "hypotenuse(3, 4)");
        assertEquals(13.0, Rounding.hypotenuse(5, 12), 0.0001, "hypotenuse(5, 12)");
    }

    @DisplayName("hypotenuse(1, 1) -> 1.4142... (square root of 2, not a whole number)")
    @Test
    void hypotenuse_Test02() {
        assertEquals(1.41421356, Rounding.hypotenuse(1, 1), 0.0001, "hypotenuse(1, 1)");
    }

    @DisplayName("hypotenuse(0, 7) -> 7.0 (one leg of zero) and the order of the legs does not matter")
    @Test
    void hypotenuse_Test03() {
        assertEquals(7.0, Rounding.hypotenuse(0, 7), 0.0001, "hypotenuse(0, 7)");
        assertEquals(7.0, Rounding.hypotenuse(7, 0), 0.0001, "hypotenuse(7, 0)");
        assertEquals(Rounding.hypotenuse(2, 3), Rounding.hypotenuse(3, 2), 0.0001, "hypotenuse(2,3) vs (3,2)");
    }

    @DisplayName("hypotenuse(1.5, 2.0) -> 2.5 (decimal legs)")
    @Test
    void hypotenuse_Test04() {
        assertEquals(2.5, Rounding.hypotenuse(1.5, 2.0), 0.0001, "hypotenuse(1.5, 2.0)");
    }

    @DisplayName("digitsIn(12345) -> 5 and digitsIn(7) -> 1")
    @Test
    void digitsIn_Test01() {
        assertEquals(5, Rounding.digitsIn(12345), "digitsIn(12345)");
        assertEquals(1, Rounding.digitsIn(7), "digitsIn(7)");
    }

    @DisplayName("digitsIn(0) -> 1 (zero is written with one digit -- catches a loop that never runs)")
    @Test
    void digitsIn_Test02() {
        assertEquals(1, Rounding.digitsIn(0), "digitsIn(0) -- a while (n > 0) loop never runs for 0; handle it");
    }

    @DisplayName("digitsIn(-407) -> 3 and digitsIn(-5) -> 1 (the minus sign is not a digit)")
    @Test
    void digitsIn_Test03() {
        assertEquals(3, Rounding.digitsIn(-407), "digitsIn(-407) -- use Math.abs first");
        assertEquals(1, Rounding.digitsIn(-5), "digitsIn(-5)");
    }

    @DisplayName("digitsIn(1000) -> 4 and digitsIn(999) -> 3 (either side of a power of ten)")
    @Test
    void digitsIn_Test04() {
        assertEquals(4, Rounding.digitsIn(1000), "digitsIn(1000)");
        assertEquals(3, Rounding.digitsIn(999), "digitsIn(999)");
        assertEquals(2, Rounding.digitsIn(10), "digitsIn(10)");
    }

    @DisplayName("digitsIn(Integer.MAX_VALUE) -> 10 (2147483647 has ten digits)")
    @Test
    void digitsIn_Test05() {
        assertEquals(10, Rounding.digitsIn(Integer.MAX_VALUE), "digitsIn(Integer.MAX_VALUE)");
        assertEquals(10, Rounding.digitsIn(-Integer.MAX_VALUE), "digitsIn(-2147483647)");
    }

    @DisplayName("toCelsius(212) -> 100.0 and toCelsius(32) -> 0.0 (catches 5 / 9 integer division)")
    @Test
    void toCelsius_Test01() {
        assertEquals(100.0, Rounding.toCelsius(212), 0.0001, "toCelsius(212) -- if you got 0.0, then 5 / 9 was computed as an int");
        assertEquals(0.0, Rounding.toCelsius(32), 0.0001, "toCelsius(32)");
    }

    @DisplayName("toCelsius(-40) -> -40.0 (the one temperature both scales agree on)")
    @Test
    void toCelsius_Test02() {
        assertEquals(-40.0, Rounding.toCelsius(-40), 0.0001, "toCelsius(-40)");
    }

    @DisplayName("toCelsius(98.6) -> 37.0 and toCelsius(50) -> 10.0")
    @Test
    void toCelsius_Test03() {
        assertEquals(37.0, Rounding.toCelsius(98.6), 0.001, "toCelsius(98.6)");
        assertEquals(10.0, Rounding.toCelsius(50), 0.0001, "toCelsius(50)");
    }
}
