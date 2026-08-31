/** READ FIRST
 * Dice is a toolbox of static methods built on Math.random(). You never write
 * new Dice() -- you call Dice.roll(6), exactly the way you call Math.sqrt(16).
 *
 * Math.random() gives a double that is >= 0.0 and < 1.0. On its own that is
 * useless. Stretch it, chop it, shift it:
 *
 *     Math.random()                  0.0 .. 0.9999
 *     Math.random() * 6              0.0 .. 5.9999
 *     (int)(Math.random() * 6)       0, 1, 2, 3, 4, 5
 *     (int)(Math.random() * 6) + 1   1 .. 6
 *
 * THE GENERAL FORM:   (int)(Math.random() * (high - low + 1)) + low
 *
 * The two classic bugs, straight from the lecture:
 *   (int) Math.random() * 6 + 1   casts ONLY Math.random(), which is always 0,
 *                                 so the die is stuck on 1. Cast the whole product.
 *   (int)(Math.random() * 7) + 1  rolls 1..7 on a six-sided die. The multiplier
 *                                 is the COUNT of values, not the top value.
 *
 * The tests roll each method 2000 times and check that every result is in
 * range and that every face shows up. Use Math.random() -- not the Random
 * class -- because Math.random() is the one on the AP exam.
 */
public class Dice {

    /** COMPLETE THIS METHOD
     * Precondition: sides >= 1
     * Returns a random int from 1 to sides, inclusive, with every value
     * equally likely. roll(6) returns 1, 2, 3, 4, 5 or 6. roll(1) is always 1.
     * Hint: (int)(Math.random() * sides) + 1 -- cast the whole product.
     */
    public static int roll(int sides) {
        // Insert your code below

        return 0;
    }

    /** COMPLETE THIS METHOD
     * Returns the total of two six-sided dice rolled independently: 2 to 12.
     * A 7 should come up about 1/6 of the time (6 of the 36 combinations),
     * and a 2 or a 12 only 1/36 of the time each.
     *
     * Roll two dice and add them. Do NOT pick one random number from 2 to 12 --
     * that makes every total equally likely, which real dice do not do, and
     * the tests can tell the difference.
     * Hint: call roll(6) twice.
     */
    public static int rollTwo() {
        // Insert your code below

        return 0;
    }

    /** COMPLETE THIS METHOD
     * Precondition: low <= high
     * Returns a random int from low to high, INCLUSIVE, every value equally
     * likely. rollInRange(60, 100) returns one of the 41 values 60..100.
     * rollInRange(5, 5) is always 5. rollInRange(-3, 3) can return -3 and 3.
     *
     * 60 to 100 is 41 values, not 40. Count them. The + 1 in the formula is
     * the count of values, not a fudge factor.
     * Hint: (int)(Math.random() * (high - low + 1)) + low
     */
    public static int rollInRange(int low, int high) {
        // Insert your code below

        return 0;
    }
}
