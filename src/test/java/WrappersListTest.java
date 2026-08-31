import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class WrappersListTest {
    /** Builds an ArrayList<Integer> from an int[] so each test reads in one line. */
    private static ArrayList<Integer> toList(int[] values) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }
        return list;
    }

    @DisplayName("sumOfList([4, 9, -2]) -> 11")
    @Test
    void sumOfList_Test01() {
        assertEquals(11, Wrappers.sumOfList(toList(new int[]{4, 9, -2})), "sumOfList([4, 9, -2])");
    }

    @DisplayName("sumOfList([]) -> 0 (empty list)")
    @Test
    void sumOfList_Test02() {
        assertEquals(0, Wrappers.sumOfList(new ArrayList<Integer>()), "sumOfList of an empty list");
    }

    @DisplayName("sumOfList([250]) -> 250 (one element) and sumOfList([-1, -2, -3]) -> -6")
    @Test
    void sumOfList_Test03() {
        assertEquals(250, Wrappers.sumOfList(toList(new int[]{250})), "sumOfList([250])");
        assertEquals(-6, Wrappers.sumOfList(toList(new int[]{-1, -2, -3})), "sumOfList([-1, -2, -3])");
    }

    @DisplayName("countValue([1, 2, 1, 3, 1], 1) -> 3 (small values -- inside the Integer cache)")
    @Test
    void countValue_Test01() {
        assertEquals(3, Wrappers.countValue(toList(new int[]{1, 2, 1, 3, 1}), 1), "countValue(..., 1)");
    }

    @DisplayName("countValue([200, 200, 300, 200], 200) -> 3 (values >= 128 -- catches == on Integers)")
    @Test
    void countValue_Test02() {
        assertEquals(3, Wrappers.countValue(toList(new int[]{200, 200, 300, 200}), 200),
            "countValue(..., 200) -- if you got 0, you compared two Integer objects with ==. Use .equals()");
    }

    @DisplayName("countValue([128, 127, 128], 128) -> 2 and countValue([128, 127, 128], 127) -> 1 (the cache edge)")
    @Test
    void countValue_Test03() {
        ArrayList<Integer> list = toList(new int[]{128, 127, 128});
        assertEquals(2, Wrappers.countValue(list, 128), "countValue([128, 127, 128], 128) -- 128 is just outside the cache");
        assertEquals(1, Wrappers.countValue(list, 127), "countValue([128, 127, 128], 127)");
    }

    @DisplayName("countValue([1000, 1000], 1000) -> 2 and countValue([-500, -500, 5], -500) -> 2")
    @Test
    void countValue_Test04() {
        assertEquals(2, Wrappers.countValue(toList(new int[]{1000, 1000}), 1000), "countValue([1000, 1000], 1000)");
        assertEquals(2, Wrappers.countValue(toList(new int[]{-500, -500, 5}), -500), "countValue([-500, -500, 5], -500)");
    }

    @DisplayName("countValue: value not present -> 0, and empty list -> 0")
    @Test
    void countValue_Test05() {
        assertEquals(0, Wrappers.countValue(toList(new int[]{1, 2, 3}), 4), "countValue([1, 2, 3], 4)");
        assertEquals(0, Wrappers.countValue(new ArrayList<Integer>(), 7), "countValue([], 7)");
    }

    @DisplayName("largest([3, 9, 4]) -> 9")
    @Test
    void largest_Test01() {
        assertEquals(Integer.valueOf(9), Wrappers.largest(toList(new int[]{3, 9, 4})), "largest([3, 9, 4])");
    }

    @DisplayName("largest([]) -> null (an empty list has no largest value)")
    @Test
    void largest_Test02() {
        assertNull(Wrappers.largest(new ArrayList<Integer>()), "largest of an empty list must be null");
    }

    @DisplayName("largest([-5, -2, -9]) -> -2 (all negative -- catches a max that starts at 0)")
    @Test
    void largest_Test03() {
        assertEquals(Integer.valueOf(-2), Wrappers.largest(toList(new int[]{-5, -2, -9})),
            "largest([-5, -2, -9]) -- start your max at the first element, not at 0");
    }

    @DisplayName("largest: one element, ties, big values, and the max first or last -- [42], [7, 7], [1000, 5000, 200], [9, 1, 2], [1, 2, 9]")
    @Test
    void largest_Test04() {
        assertEquals(Integer.valueOf(42), Wrappers.largest(toList(new int[]{42})), "largest([42])");
        assertEquals(Integer.valueOf(7), Wrappers.largest(toList(new int[]{7, 7})), "largest([7, 7])");
        assertEquals(Integer.valueOf(5000), Wrappers.largest(toList(new int[]{1000, 5000, 200})), "largest([1000, 5000, 200])");
        assertEquals(Integer.valueOf(9), Wrappers.largest(toList(new int[]{9, 1, 2})), "largest([9, 1, 2])");
        assertEquals(Integer.valueOf(9), Wrappers.largest(toList(new int[]{1, 2, 9})), "largest([1, 2, 9])");
    }
}
