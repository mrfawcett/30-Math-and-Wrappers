import java.util.ArrayList;

/**
 * Demo for Math and Wrappers. PROVIDED - you do not need to change this file.
 * Run it to see your methods in action; the autograder never runs it.
 *
 * Every number printed here is either a fixed value you can check by hand or
 * a random result you can sanity-check against the range printed beside it.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Dice ===");
        System.out.println("Ten rolls of a six-sided die (each should be 1..6):");
        String rolls = "";
        for (int i = 0; i < 10; i++) {
            rolls += Dice.roll(6) + " ";
        }
        System.out.println("   " + rolls);

        System.out.println("Ten rolls of rollInRange(60, 100) (each should be 60..100):");
        rolls = "";
        for (int i = 0; i < 10; i++) {
            rolls += Dice.rollInRange(60, 100) + " ";
        }
        System.out.println("   " + rolls);

        // The lecture's live-code: roll two dice 1000 times, count the sevens.
        int sevens = 0;
        for (int i = 0; i < 1000; i++) {
            if (Dice.rollTwo() == 7) {
                sevens++;
            }
        }
        System.out.println("Sevens in 1000 rolls of two dice: " + sevens
            + "  (expect about 167 -- 6 of the 36 combinations total 7)");
        System.out.printf("   That is %.1f%%%n", 100.0 * sevens / 1000);

        System.out.println();
        System.out.println("=== Rounding ===");
        System.out.println("round2(3.14159)  = " + Rounding.round2(3.14159) + "   (want 3.14)");
        System.out.println("round2(19.999)   = " + Rounding.round2(19.999) + "   (want 20.0)");
        System.out.println("roundToInt(4.7)  = " + Rounding.roundToInt(4.7) + "   (want 5 -- rounds)");
        System.out.println("chop(4.7)        = " + Rounding.chop(4.7) + "   (want 4 -- chops)");
        System.out.println("roundToInt(-4.7) = " + Rounding.roundToInt(-4.7) + "   (want -5)");
        System.out.println("chop(-4.7)       = " + Rounding.chop(-4.7) + "   (want -4, toward zero)");
        System.out.println("hypotenuse(3, 4) = " + Rounding.hypotenuse(3, 4) + "   (want 5.0)");
        System.out.println("digitsIn(-407)   = " + Rounding.digitsIn(-407) + "   (want 3)");
        System.out.println("toCelsius(212)   = " + Rounding.toCelsius(212) + "   (want 100.0)");

        System.out.println();
        System.out.println("=== Wrappers ===");
        ArrayList<Integer> scores = new ArrayList<Integer>();
        scores.add(200);
        scores.add(95);
        scores.add(200);
        scores.add(-40);
        scores.add(200);
        System.out.println("scores = " + scores);
        System.out.println("sumOfList(scores)        = " + Wrappers.sumOfList(scores) + "   (want 655)");
        System.out.println("countValue(scores, 200)  = " + Wrappers.countValue(scores, 200) + "   (want 3)");
        System.out.println("largest(scores)          = " + Wrappers.largest(scores) + "   (want 200)");
        System.out.println("largest(empty list)      = " + Wrappers.largest(new ArrayList<Integer>()) + "   (want null)");
        System.out.println("parseAndAdd(\"2\", \"3\")    = " + Wrappers.parseAndAdd("2", "3") + "   (want 5, not 23)");

        ArrayList<String> grades = new ArrayList<String>();
        grades.add("90");
        grades.add("85.5");
        grades.add("77");
        System.out.println("parseAverage(" + grades + ") = " + Wrappers.parseAverage(grades) + "   (want 84.1666...)");
        System.out.println("isMaxValue(Integer.MAX_VALUE) = " + Wrappers.isMaxValue(Integer.MAX_VALUE) + "   (want true)");
        System.out.println("isMaxValue(Integer.MIN_VALUE - 1) = " + Wrappers.isMaxValue(Integer.MIN_VALUE - 1)
            + "   (want true -- overflow wraps around)");

        System.out.println();
        System.out.println("=== The Integer cache trap, live ===");
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println("127 == 127       -> " + (a == b) + "      (cached: same object)");
        System.out.println("128 == 128       -> " + (c == d) + "     (two objects!)");
        System.out.println("128 .equals(128) -> " + c.equals(d) + "      (compares values)");
    }
}
