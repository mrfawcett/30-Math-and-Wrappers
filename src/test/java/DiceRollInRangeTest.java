import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DiceRollInRangeTest {
    @DisplayName("rollInRange(5, 5): a one-value range is always 5")
    @Test
    void rollInRange_Test01() {
        for (int i = 0; i < 500; i++) {
            assertEquals(5, Dice.rollInRange(5, 5), "rollInRange(5, 5) must always be 5");
        }
    }

    @DisplayName("rollInRange(60, 100): 2000 rolls all land in 60..100")
    @Test
    void rollInRange_Test02() {
        for (int i = 0; i < 2000; i++) {
            int r = Dice.rollInRange(60, 100);
            assertTrue(r >= 60 && r <= 100, "rollInRange(60, 100) returned " + r);
        }
    }

    @DisplayName("rollInRange(1, 3): all three values 1, 2, 3 appear in 2000 rolls")
    @Test
    void rollInRange_Test03() {
        boolean[] seen = new boolean[4];
        for (int i = 0; i < 2000; i++) {
            int r = Dice.rollInRange(1, 3);
            assertTrue(r >= 1 && r <= 3, "rollInRange(1, 3) returned " + r);
            seen[r] = true;
        }
        assertTrue(seen[1], "1 never came up");
        assertTrue(seen[2], "2 never came up");
        assertTrue(seen[3], "3 never came up");
    }

    @DisplayName("rollInRange(10, 12): the top value 12 is reachable (catches high - low without the + 1)")
    @Test
    void rollInRange_Test04() {
        boolean sawTop = false;
        for (int i = 0; i < 2000; i++) {
            int r = Dice.rollInRange(10, 12);
            assertTrue(r >= 10 && r <= 12, "rollInRange(10, 12) returned " + r);
            if (r == 12) sawTop = true;
        }
        assertTrue(sawTop, "rollInRange(10, 12) never returned 12 -- the multiplier is (high - low + 1), the COUNT of values");
    }

    @DisplayName("rollInRange(-3, 3): negatives work -- stays in -3..3 and reaches both ends")
    @Test
    void rollInRange_Test05() {
        boolean sawLow = false;
        boolean sawHigh = false;
        for (int i = 0; i < 2000; i++) {
            int r = Dice.rollInRange(-3, 3);
            assertTrue(r >= -3 && r <= 3, "rollInRange(-3, 3) returned " + r);
            if (r == -3) sawLow = true;
            if (r == 3) sawHigh = true;
        }
        assertTrue(sawLow, "-3 never came up in 2000 rolls");
        assertTrue(sawHigh, "3 never came up in 2000 rolls");
    }

    @DisplayName("rollInRange(60, 100): the bottom value 60 is reachable (catches a shift by high instead of low)")
    @Test
    void rollInRange_Test06() {
        boolean sawBottom = false;
        for (int i = 0; i < 2000; i++) {
            if (Dice.rollInRange(60, 100) == 60) {
                sawBottom = true;
            }
        }
        assertTrue(sawBottom, "rollInRange(60, 100) never returned 60 in 2000 rolls (expect about 49)");
    }

    @DisplayName("rollInRange(0, 1): a range starting at 0 gives both 0 and 1")
    @Test
    void rollInRange_Test07() {
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < 2000; i++) {
            int r = Dice.rollInRange(0, 1);
            if (r == 0) zeros++;
            else if (r == 1) ones++;
            else fail("rollInRange(0, 1) returned " + r);
        }
        assertTrue(zeros > 0, "rollInRange(0, 1) never returned 0");
        assertTrue(ones > 0, "rollInRange(0, 1) never returned 1");
    }
}
