package algorithm.challenge.faang_practice.arrays;

import java.util.*;

public class TheWrongWayCow {
    public static void main(String[] args) {
        char[][] field1 = {
                "cow.cow.cow.cow.cow".toCharArray(),
                "cow.cow.cow.cow.cow".toCharArray(),
                "cow.woc.cow.cow.cow".toCharArray(),
                "cow.cow.cow.cow.cow".toCharArray()
        };

        char[][] field2 = {
                "c..........".toCharArray(),
                "o...c......".toCharArray(),
                "w...o.c....".toCharArray(),
                "....w.o....".toCharArray(),
                "......w.cow".toCharArray()
        };

        System.out.println(Arrays.toString(findWrongWayCow(field1)));
        System.out.println(Arrays.toString(findWrongWayCow(field2)));
        System.out.println(Arrays.toString(findWrongWayCowBoyerMoore(field1)));
        System.out.println(Arrays.toString(findWrongWayCowBoyerMoore(field2)));
    }

    /**
     * Have you ever noticed that cows in a field are always facing in the same direction?
     * <p>
     * Reference: http://bfy.tw/7fgf
     * <p>
     * Well.... not quite always.
     * <p>
     * One stubborn cow wants to be different from the rest of the herd - it's that damn Wrong-Way Cow!
     * <p>
     * Task
     * <p>
     * Given a field of cows find which one is the Wrong-Way Cow and return her position.
     * <p>
     * Notes:
     * <p>
     * There are always at least 3 cows in a herd
     * There is only 1 Wrong-Way Cow!
     * Fields are rectangular
     * The cow position is zero-based [x,y] of her head (i.e. the letter c)
     * There are no diagonal cows -- they only face North/South/East/West (i.e. up/down/right/left)
     * Examples
     * <p>
     * Ex1
     * <p>
     * cow.cow.cow.cow.cow
     * cow.cow.cow.cow.cow
     * cow.woc.cow.cow.cow
     * cow.cow.cow.cow.cow
     * Answer: [6,2]
     * <p>
     * Ex2
     * <p>
     * c..........
     * o...c......
     * w...o.c....
     * ....w.o....
     * ......w.cow
     * Answer: [8,4]
     * <p>
     * Notes
     * <p>
     * The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
     * <p>
     * To explain - Yes, I recognise that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows. In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
     * <p>
     * But such a field will never be tested by this Kata.
     * <p>
     * ...w...
     * ..cow..
     * .woco..
     * .ow.c..
     * .c.....
     */

    public static int[] findWrongWayCow(final char[][] field) {
        final Map<Character, List<int[]>> result = new HashMap<>();

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                char current = field[row][col];

                if (current == 'c') {
                    if (col + 1 < field[row].length) {
                        char right = field[row][col + 1];
                        if (right == 'o') {
                            result.computeIfAbsent('r', k -> new ArrayList<>()).add(new int[]{col, row});
                        }
                    }
                    if (col != 0) {
                        char left = field[row][col - 1];
                        if (left == 'o') {
                            result.computeIfAbsent('l', k -> new ArrayList<>()).add(new int[]{col, row});
                        }
                    }
                    if (row + 1 < field.length) {
                        char below = field[row + 1][col];
                        if (below == 'o') {
                            result.computeIfAbsent('b', k -> new ArrayList<>()).add(new int[]{col, row});
                        }
                    }
                    if (row != 0) {
                        char above = field[row - 1][col];
                        if (above == 'o') {
                            result.computeIfAbsent('a', k -> new ArrayList<>()).add(new int[]{col, row});
                        }
                    }
                }
            }
        }

        // Your cow finding code here
        return result.values()
                .stream()
                .filter(val -> val.size() == 1)
                .findFirst()
                .get()
                .get(0);
    }

    public static int[] findWrongWayCowBoyerMoore(final char[][] field) {
        char candidate = 0;
        int count = 0;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'c') {
                    char direction = getDirection(field, row, col);

                    if (count == 0) {
                        candidate = direction;
                        count = 1;
                    } else if (direction == candidate) {
                        count++;
                    } else {
                        count--;
                    }
                }
            }
        }

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'c') {
                    if (getDirection(field, row, col) != candidate) {
                        return new int[]{col, row};
                    }
                }
            }
        }

        return new int[]{};
    }

    private static char getDirection(char[][] field, int row, int col) {
        if (col + 1 < field[row].length && field[row][col + 1] == 'o') return 'r';
        if (col - 1 >= 0 && field[row][col - 1] == 'o') return 'l';
        if (row + 1 < field.length && field[row + 1][col] == 'o') return 'b';
        return 'a';
    }
}
