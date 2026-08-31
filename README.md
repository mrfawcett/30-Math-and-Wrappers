# Math and Wrappers

**Unit 2 — Classes, Methods & Strings** · Pairs with lecture 2.4 Math Class and Wrappers (Oct 13/14) · CED 4.7 (wrapper classes)

This is the first assignment where you use a class you did not write and never
instantiate. Nobody says `new Math()`. You call `Math.sqrt(16)` on the class
itself, and every method you write here works the same way — three small
toolboxes of `static` methods: `Dice`, `Rounding`, and `Wrappers`.

None of it is long. Most methods are one line. The points are in the details
the lecture warned you about: the cast that chops, the `long` that
`Math.round` hands back, the `+ 1` in the random-range formula, the `100.0`
that stops integer division, and the `==` that lies to you about an `Integer`
of 128. Every one of those shows up on the AP exam, and every one of them has
a test in this repo.

---

## What you are given

| File | Status | Purpose |
|---|---|---|
| `src/main/java/Dice.java` | **you complete this** | `roll`, `rollTwo`, `rollInRange` — the `Math.random()` formula |
| `src/main/java/Rounding.java` | **you complete this** | `round2`, `roundToInt`, `chop`, `hypotenuse`, `digitsIn`, `toCelsius` — the `Math` class and casts |
| `src/main/java/Wrappers.java` | **you complete this** | `sumOfList`, `countValue`, `parseAndAdd`, `parseAverage`, `largest`, `isMaxValue` — `Integer`, `Double`, autoboxing |
| `src/main/java/Main.java` | provided | a demo that prints every method next to the answer it should give |
| `src/test/java/*Test.java` | provided | the autograder's tests — read them |
| `pom.xml`, `grading.json` | provided | build and grading setup — do not edit |

Run `Main` from your IDE whenever you finish a method. It prints what your
method returned beside what it should have returned. The autograder never runs
`Main`; it only runs the tests.

## What to write

| Method | Points | What it does |
|---|---|---|
| `Dice.roll(int sides)` | 10 | A random int from 1 to `sides`, inclusive. |
| `Dice.rollTwo()` | 7 | The total of two six-sided dice, 2 to 12. |
| `Dice.rollInRange(int low, int high)` | 8 | A random int from `low` to `high`, inclusive. |
| `Rounding.round2(double value)` | 8 | `value` rounded to two decimal places. |
| `Rounding.roundToInt(double value)` / `chop(double value)` | 12 | Nearest whole number as an `int` / decimal part dropped. |
| `Rounding.hypotenuse(a, b)` / `digitsIn(int n)` / `toCelsius(double f)` | 15 | Pythagoras / count of digits via a loop / Fahrenheit to Celsius. |
| `Wrappers.sumOfList` / `countValue` / `largest` | 22 | Sum an `ArrayList<Integer>` / count matches with `.equals()` / biggest value or `null`. |
| `Wrappers.parseAndAdd` / `parseAverage` / `isMaxValue` | 18 | `Integer.parseInt` / `Double.parseDouble` / `Integer.MAX_VALUE`. |

### The random-range formula

```java
Math.random()                  // 0.0 .. 0.9999   low end included, high end NOT
Math.random() * 6              // 0.0 .. 5.9999   stretch
(int)(Math.random() * 6)       // 0, 1, 2, 3, 4, 5   chop
(int)(Math.random() * 6) + 1   // 1 .. 6          shift
```

General form: `(int)(Math.random() * (high - low + 1)) + low`. The `+ 1` is
the **count of values**, not a fudge factor — 60 to 100 is 41 values, not 40.

Two classic bugs, and the tests catch both:

- `(int) Math.random() * 6 + 1` casts **only** `Math.random()`, which is
  always 0, so the die is stuck on 1. Cast the whole product.
- `(int)(Math.random() * 7) + 1` rolls 1..7 on a six-sided die.

`rollTwo` must roll two dice and add them. One random number from 2 to 12
makes every total equally likely; real dice hit 7 six ways out of 36 and 2
only one way. The test counts the sevens and can tell the difference.

### Cast vs round

| expression | value | why |
|---|---|---|
| `(int) 4.7` | `4` | a cast **chops** |
| `(int) Math.round(4.7)` | `5` | `Math.round` **rounds** |
| `(int) -4.7` | `-4` | chops toward zero, not down |
| `(int) Math.round(-4.7)` | `-5` | nearest whole number |
| `Math.round(4.7)` | `5L` | a `long` — you must cast it to reach an `int` |

`round2` is `Math.round(value * 100) / 100.0`. The `.0` is the entire lesson:
`Math.round(314.159)` is the `long` 314, and `314 / 100` is `3`. Delete the
`.0` and every answer becomes a whole number — there is a test for exactly that.

### digitsIn is a loop, not a String

`Math.abs` first to drop the sign, then divide by 10 until nothing is left,
counting as you go. Zero has one digit, so a `while (n > 0)` loop that never
runs gives the wrong answer for 0 — handle it. The precondition
`n > Integer.MIN_VALUE` exists because `Math.abs(Integer.MIN_VALUE)` is still
negative: 2147483648 does not fit in an `int`. Overflow fails silently.

### Wrappers: `.equals()`, never `==`

```java
Integer a = 127, b = 127;   a == b        // true
Integer c = 128, d = 128;   c == d        // FALSE
                            c.equals(d)   // true
```

Java caches the `Integer` objects from -128 to 127. Inside the cache both
names point at one object; outside it you get two objects with equal values.
`==` compares references. `.equals()` compares values. Same rule as Strings.

`countValue` receives its `value` already boxed as an `Integer`, the way it
would be if it came out of another list. `list.get(i) == value` compiles,
passes the test that uses 1s and 2s, and **fails** the tests that use 200 and
1000. That is the trap from the lecture, on purpose.

`largest` returns `Integer`, not `int`, so it *can* return `null` for an
empty list — a primitive has no way to say "there is no answer". Start your
max at the first element, not at 0, or a list of negatives breaks it.

---

## Examples

```
Dice.roll(6)                 -> one of 1, 2, 3, 4, 5, 6
Dice.rollInRange(60, 100)    -> one of the 41 values 60 .. 100
Dice.rollInRange(5, 5)       -> 5, always

Rounding.round2(3.14159)     -> 3.14
Rounding.roundToInt(4.7)     -> 5        Rounding.chop(4.7)   -> 4
Rounding.roundToInt(-4.7)    -> -5       Rounding.chop(-4.7)  -> -4
Rounding.hypotenuse(3, 4)    -> 5.0
Rounding.digitsIn(-407)      -> 3        Rounding.digitsIn(0) -> 1
Rounding.toCelsius(212)      -> 100.0

Wrappers.sumOfList([4, 9, -2])            -> 11
Wrappers.countValue([200, 200, 300], 200) -> 2
Wrappers.parseAndAdd("2", "3")            -> 5   (not 23)
Wrappers.parseAverage(["1", "2", "3", "4"]) -> 2.5
Wrappers.largest([-5, -2, -9])            -> -2
Wrappers.largest([])                      -> null
Wrappers.isMaxValue(Integer.MIN_VALUE - 1) -> true   (overflow wraps around)
```

## Running the tests

`mvn test` runs everything; `mvn test -Dtest=Round2Test` runs one rubric line.

| Test class | Rubric line | Points |
|---|---|---|
| `DiceRollTest` | `Dice.roll` | 10 |
| `DiceRollTwoTest` | `Dice.rollTwo` | 7 |
| `DiceRollInRangeTest` | `Dice.rollInRange` | 8 |
| `Round2Test` | `Rounding.round2` | 8 |
| `RoundToIntChopTest` | `Rounding.roundToInt` and `chop` | 12 |
| `MathHelpersTest` | `Rounding.hypotenuse`, `digitsIn` and `toCelsius` | 15 |
| `WrappersListTest` | `Wrappers.sumOfList`, `countValue` and `largest` | 22 |
| `WrappersParseTest` | `Wrappers.parseAndAdd`, `parseAverage` and `isMaxValue` | 18 |

The autograder awards a rubric line only when **every** test in that class
passes. The dice tests roll 2000 times and check that every face appears and
every result is in range — a die stuck on 1 earns 0 of 10, not 5.

## Suggested order

1. `Rounding.chop` and `Rounding.roundToInt` — one line each. Run
   `RoundToIntChopTest` and make sure you know which one is which.
2. `Rounding.round2`, `hypotenuse`, `toCelsius` — one line each, all about
   return types and the `.0`. Then `digitsIn`, the only loop in the file.
3. `Dice.roll` — derive the formula line by line, then `rollInRange`, which
   is the same formula with `low` and `high`. `rollTwo` is two calls to `roll`.
   Run `Main` and look at the ten rolls it prints.
4. `Wrappers.sumOfList`, `parseAndAdd`, `parseAverage`, `isMaxValue` — the
   conversions. Watch for `"2" + "3"`.
5. `Wrappers.largest` (check for empty first, start at element 0) and
   finally `countValue` with `.equals()`. Run `WrappersListTest` and read
   which values fail if you used `==`.

## Rules of the road

- AP Java subset only: `Math.random`, `Math.round`, `Math.abs`, `Math.sqrt`,
  `Math.pow`, casts, `Integer.parseInt`, `Double.parseDouble`,
  `Integer.MAX_VALUE`, `ArrayList` with `get`/`size`, loops. No `Random`
  class, no `String.format` or `DecimalFormat` for rounding, no
  `String.valueOf(n).length()` for `digitsIn`, no `Collections` or streams.
- Do not change method headers or provided code.
- Do not touch `src/test`, `pom.xml`, `grading.json`, or `.github`. The
  autograder checks that they are byte-identical to the template before it
  runs a single test; if they differ it stops and awards nothing, and the
  change shows up in the roster.
- The dice tests are statistical with wide margins. A correct `roll` passes
  every time; there is no "unlucky run" excuse for a die that never shows a 6.
