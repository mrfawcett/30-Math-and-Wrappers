import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DiceRollTest {
    @DisplayName("roll(6): 2000 rolls all land in 1..6")
    @Test
    void roll_Test01() {
        for (int i = 0; i < 2000; i++) {
            int r = Dice.roll(6);
            assertTrue(r >= 1 && r <= 6, "roll(6) returned " + r + ", which is outside 1..6");
        }
    }

    @DisplayName("roll(6): every face 1..6 appears at least once in 2000 rolls")
    @Test
    void roll_Test02() {
        boolean[] seen = new boolean[7];
        for (int i = 0; i < 2000; i++) {
            int r = Dice.roll(6);
            if (r >= 1 && r <= 6) {
                seen[r] = true;
            }
        }
        for (int face = 1; face <= 6; face++) {
            assertTrue(seen[face], "face " + face + " never came up in 2000 rolls of roll(6)");
        }
    }

    @DisplayName("roll(6): the die is not stuck -- 6 appears (catches a 0..5 die or a die stuck on 1)")
    @Test
    void roll_Test03() {
        boolean sawSix = false;
        boolean sawZero = false;
        for (int i = 0; i < 2000; i++) {
            int r = Dice.roll(6);
            if (r == 6) sawSix = true;
            if (r == 0) sawZero = true;
        }
        assertFalse(sawZero, "roll(6) returned 0 -- did you forget the + 1?");
        assertTrue(sawSix, "roll(6) never returned 6 in 2000 rolls -- is the cast around the whole product?");
    }

    @DisplayName("roll(1): a one-sided die is always 1")
    @Test
    void roll_Test04() {
        for (int i = 0; i < 500; i++) {
            assertEquals(1, Dice.roll(1), "roll(1) must always be 1");
        }
    }

    @DisplayName("roll(2): a coin -- both 1 and 2 appear, nothing else, in 2000 flips")
    @Test
    void roll_Test05() {
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < 2000; i++) {
            int r = Dice.roll(2);
            if (r == 1) ones++;
            else if (r == 2) twos++;
            else fail("roll(2) returned " + r);
        }
        assertTrue(ones > 0, "roll(2) never returned 1");
        assertTrue(twos > 0, "roll(2) never returned 2");
    }

    @DisplayName("roll(20): 2000 rolls stay in 1..20 and reach both 1 and 20")
    @Test
    void roll_Test06() {
        boolean sawLow = false;
        boolean sawHigh = false;
        for (int i = 0; i < 2000; i++) {
            int r = Dice.roll(20);
            assertTrue(r >= 1 && r <= 20, "roll(20) returned " + r);
            if (r == 1) sawLow = true;
            if (r == 20) sawHigh = true;
        }
        assertTrue(sawLow, "roll(20) never returned 1");
        assertTrue(sawHigh, "roll(20) never returned 20");
    }

    @DisplayName("roll(6): results are spread out -- no single face takes more than half the rolls")
    @Test
    void roll_Test07() {
        int[] counts = new int[7];
        for (int i = 0; i < 2000; i++) {
            int r = Dice.roll(6);
            if (r >= 1 && r <= 6) {
                counts[r]++;
            }
        }
        for (int face = 1; face <= 6; face++) {
            assertTrue(counts[face] < 1000,
                "face " + face + " came up " + counts[face] + " times out of 2000 -- a fair die averages about 333");
        }
    }
}
