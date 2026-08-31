import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DiceRollTwoTest {
    @DisplayName("rollTwo: 2000 totals all land in 2..12")
    @Test
    void rollTwo_Test01() {
        for (int i = 0; i < 2000; i++) {
            int total = Dice.rollTwo();
            assertTrue(total >= 2 && total <= 12, "rollTwo() returned " + total + ", which is outside 2..12");
        }
    }

    @DisplayName("rollTwo: the mean of 2000 totals is between 6.0 and 8.0 (true mean is 7)")
    @Test
    void rollTwo_Test02() {
        int sum = 0;
        for (int i = 0; i < 2000; i++) {
            sum += Dice.rollTwo();
        }
        double mean = (double) sum / 2000;
        assertTrue(mean >= 6.0 && mean <= 8.0, "mean of 2000 rollTwo() calls was " + mean + ", expected about 7.0");
    }

    @DisplayName("rollTwo: at least six different totals appear in 2000 rolls (catches a constant)")
    @Test
    void rollTwo_Test03() {
        boolean[] seen = new boolean[13];
        int distinct = 0;
        for (int i = 0; i < 2000; i++) {
            int total = Dice.rollTwo();
            if (total >= 2 && total <= 12 && !seen[total]) {
                seen[total] = true;
                distinct++;
            }
        }
        assertTrue(distinct >= 6, "only " + distinct + " different totals came up in 2000 rolls");
    }

    @DisplayName("rollTwo: both 2 (snake eyes) and 12 (boxcars) show up in 2000 rolls")
    @Test
    void rollTwo_Test04() {
        boolean sawTwo = false;
        boolean sawTwelve = false;
        for (int i = 0; i < 2000; i++) {
            int total = Dice.rollTwo();
            if (total == 2) sawTwo = true;
            if (total == 12) sawTwelve = true;
        }
        assertTrue(sawTwo, "rollTwo() never returned 2 in 2000 rolls (expect about 55)");
        assertTrue(sawTwelve, "rollTwo() never returned 12 in 2000 rolls (expect about 55)");
    }

    @DisplayName("rollTwo: 7 is the most common total -- more than 240 of 2000 rolls (expect about 333)")
    @Test
    void rollTwo_Test05() {
        // Two real dice total 7 one time in six. One random number from 2..12
        // hits 7 only one time in eleven (about 182 of 2000), so this test
        // fails for the shortcut the Javadoc warns about.
        int sevens = 0;
        for (int i = 0; i < 2000; i++) {
            if (Dice.rollTwo() == 7) {
                sevens++;
            }
        }
        assertTrue(sevens > 240, "only " + sevens + " sevens in 2000 rolls -- did you add two dice, or pick one number from 2..12?");
    }

    @DisplayName("rollTwo: 2 is rare -- fewer than 120 of 2000 rolls (expect about 55)")
    @Test
    void rollTwo_Test06() {
        int twos = 0;
        for (int i = 0; i < 2000; i++) {
            if (Dice.rollTwo() == 2) {
                twos++;
            }
        }
        assertTrue(twos < 120, twos + " twos in 2000 rolls -- with two real dice a 2 comes up only 1/36 of the time");
    }
}
