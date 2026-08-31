/** READ FIRST
 * Rounding is a toolbox of static methods built on the Math class. Every
 * method here is one or two lines. The whole assignment is about RETURN TYPES:
 *
 *     Math.pow(2, 3)      is 8.0  (a double), never 8
 *     Math.sqrt(16)       is 4.0  (a double)
 *     Math.round(4.7)     is 5    (a LONG -- you must cast to int)
 *     Math.abs(-7)        is 7    (an int, because you gave it an int)
 *
 * And the distinction the AP exam asks about nearly every year:
 *
 *     (int) 4.7              is 4    a cast CHOPS
 *     (int) Math.round(4.7)  is 5    Math.round ROUNDS
 *
 * They are not the same thing. 4.7 becomes 4 when you cast. Every time.
 *
 * Input / output table (the tests use these and more):
 *
 *     round2(3.14159)    -> 3.14        roundToInt(4.7)   -> 5     chop(4.7)   -> 4
 *     round2(19.999)     -> 20.0        roundToInt(-4.7)  -> -5    chop(-4.7)  -> -4
 *     hypotenuse(3, 4)   -> 5.0         digitsIn(12345)   -> 5     digitsIn(0) -> 1
 *     toCelsius(212)     -> 100.0       toCelsius(-40)    -> -40.0
 *
 * AP subset only: Math.round, Math.abs, Math.sqrt, Math.pow, casts, loops.
 * No String tricks for digitsIn -- the point is the loop.
 */
public class Rounding {

    /** COMPLETE THIS METHOD
     * Returns value rounded to two decimal places (to the nearest cent).
     * round2(3.14159) is 3.14. round2(19.999) is 20.0. round2(-2.346) is -2.35.
     *
     * The formula from the lecture:  Math.round(value * 100) / 100.0
     * The .0 on the 100.0 is the ENTIRE lesson. Math.round(314.159) is the
     * long 314, and 314 / 100 is 3 -- integer division. 314 / 100.0 is 3.14.
     */
    public static double round2(double value) {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Returns value rounded to the NEAREST whole number, as an int.
     * roundToInt(4.7) is 5. roundToInt(4.2) is 4. roundToInt(-4.7) is -5.
     * Hint: Math.round(double) returns a long. Cast it: (int) Math.round(value)
     */
    public static int roundToInt(double value) {
        // Insert your code below

        return 0;
    }

    /** COMPLETE THIS METHOD
     * Returns value with the decimal part CHOPPED OFF (truncated), as an int.
     * chop(4.7) is 4. chop(4.99) is 4. chop(-4.7) is -4 (toward zero, not down).
     * Hint: this is what a cast does. One line, no Math method needed.
     */
    public static int chop(double value) {
        // Insert your code below

        return 0;
    }

    /** COMPLETE THIS METHOD
     * Precondition: a >= 0 and b >= 0
     * Returns the length of the hypotenuse of a right triangle with legs a
     * and b: the square root of (a squared plus b squared).
     * hypotenuse(3, 4) is 5.0. hypotenuse(5, 12) is 13.0.
     * Hint: Math.sqrt and either Math.pow or a * a. Both return double.
     */
    public static double hypotenuse(double a, double b) {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Precondition: n > Integer.MIN_VALUE
     * Returns how many digits n has when written out, ignoring any minus sign.
     * digitsIn(12345) is 5. digitsIn(-407) is 3. digitsIn(7) is 1.
     * digitsIn(0) is 1 -- zero is written with one digit.
     *
     * Use Math.abs to drop the sign, then a loop that divides by 10 and counts
     * until nothing is left. Do NOT convert to a String -- the loop is the point.
     * (Why the precondition: Math.abs(Integer.MIN_VALUE) is still negative,
     * because 2147483648 does not fit in an int. Overflow fails silently.)
     */
    public static int digitsIn(int n) {
        // Insert your code below

        return 0;
    }

    /** COMPLETE THIS METHOD
     * Returns the Celsius equivalent of a Fahrenheit temperature.
     * toCelsius(212) is 100.0. toCelsius(32) is 0.0. toCelsius(-40) is -40.0.
     * Formula: (fahrenheit - 32) * 5 / 9
     * Trap: (fahrenheit - 32) * (5 / 9) is always 0.0, because 5 / 9 is 0.
     */
    public static double toCelsius(double fahrenheit) {
        // Insert your code below

        return 0.0;
    }
}
