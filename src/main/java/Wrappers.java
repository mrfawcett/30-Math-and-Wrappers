import java.util.ArrayList;

/** READ FIRST
 * int, double, boolean and char are primitives -- raw values, not objects.
 * An ArrayList only holds objects, so ArrayList<int> does not compile. Java
 * gives every primitive an object twin: int -> Integer, double -> Double.
 *
 *     ArrayList<Integer> scores = new ArrayList<Integer>();
 *     scores.add(95);              // int 95 is BOXED into an Integer for you
 *     int first = scores.get(0);   // the Integer is UNBOXED back into an int
 *     int sum = scores.get(0) + 3; // unboxes, adds, gives 98
 *
 * Autoboxing is automatic, which is why nobody notices it -- until this:
 *
 *     Integer a = 127, b = 127;    a == b        is true
 *     Integer c = 128, d = 128;    c == d        is FALSE  (!)
 *                                  c.equals(d)   is true
 *
 * Java caches the Integer objects from -128 to 127. Inside the cache two
 * names point at one object; outside it you get two objects with equal
 * values. == compares references. .equals() compares values. This is the
 * String lesson wearing a different hat. NEVER use == on a wrapper.
 *
 * The other wrapper tools you need today:
 *     Integer.parseInt("42")        -> the int 42
 *     Double.parseDouble("3.5")     -> the double 3.5
 *     Integer.MAX_VALUE             =  2147483647
 *     Integer.MIN_VALUE             = -2147483648  (MAX_VALUE + 1 wraps to this)
 *
 * The tests deliberately use values of 128 and above. If you compare with ==
 * you will pass the small-number tests and fail the big-number ones. That
 * is the trap, and it is the whole point of this class.
 */
public class Wrappers {

    /** COMPLETE THIS METHOD
     * Returns the sum of every Integer in list. An empty list sums to 0.
     * sumOfList([4, 9, -2]) is 11.
     * Hint: an int total, a loop, and autounboxing does the rest.
     */
    public static int sumOfList(ArrayList<Integer> list) {
        // Insert your code below

        return 0;
    }

    /** COMPLETE THIS METHOD
     * Returns how many elements of list are equal in value to value.
     * countValue([1, 2, 1, 3, 1], 1) is 3. countValue([200, 200, 300], 200) is 2.
     * An empty list, or a value that never appears, gives 0.
     *
     * value arrives already boxed as an Integer -- exactly as it would if it
     * came out of another ArrayList. Compare with .equals(), not ==.
     * list.get(i) == value compiles, passes for small numbers, and FAILS for
     * 128 and above. Reread the header comment if you want to know why.
     */
    public static int countValue(ArrayList<Integer> list, Integer value) {
        // Insert your code below

        return 0;
    }

    /** COMPLETE THIS METHOD
     * Returns the int sum of the two numbers written in a and b.
     * Precondition: a and b each hold a valid int, such as "42" or "-7".
     * parseAndAdd("2", "3") is 5 -- not 23. Convert first, then add.
     * Hint: Integer.parseInt turns a String into an int.
     */
    public static int parseAndAdd(String a, String b) {
        // Insert your code below

        return 0;
    }

    /** COMPLETE THIS METHOD
     * Precondition: list.size() > 0 and every String holds a valid number,
     *               such as "90", "85.5" or "-1"
     * Returns the average of the numbers written in list, as a double.
     * parseAverage(["1", "2", "3", "4"]) is 2.5.
     * parseAverage(["1.5", "2.5"]) is 2.0.
     * Hint: Double.parseDouble. Add them up in a double, divide by size().
     */
    public static double parseAverage(ArrayList<String> list) {
        // Insert your code below

        return 0.0;
    }

    /** COMPLETE THIS METHOD
     * Returns the largest value in list, or null if the list is empty.
     * largest([3, 9, 4]) is 9. largest([-5, -2, -9]) is -2. largest([]) is null.
     *
     * The return type is Integer, not int, precisely so that you CAN return
     * null -- a primitive int has no way to say "there is no answer".
     * Trap: starting your max at 0 breaks on a list of negatives. Start at
     * the first element (after you have checked the list is not empty).
     */
    public static Integer largest(ArrayList<Integer> list) {
        // Insert your code below

        return null;
    }

    /** COMPLETE THIS METHOD
     * Returns true if n is the biggest value an int can hold, Integer.MAX_VALUE
     * (2147483647), and false otherwise.
     * isMaxValue(Integer.MAX_VALUE) is true. isMaxValue(0) is false.
     * Fun fact the tests check: Integer.MIN_VALUE - 1 wraps around to
     * MAX_VALUE, so isMaxValue(Integer.MIN_VALUE - 1) is true. That is overflow.
     */
    public static boolean isMaxValue(int n) {
        // Insert your code below

        return false;
    }
}
