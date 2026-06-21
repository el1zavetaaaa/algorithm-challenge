package algorithm.challenge.faang_practice.arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum {
    /**
     * Write a function that takes an array of numbers (integers for the tests) and a target number. It should find two different items in the array that, when added together, give the target value. The indexes of these items should then be returned in a tuple / list (depending on your language) like so: (index1, index2).
     * <p>
     * For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.
     * <p>
     * The input will always be valid (numbers will be an array of length 2 or greater, and all of the items will be positive or negative integers; target will always be the sum of two different items from that array).
     * <p>
     * Based on: https://leetcode.com/problems/two-sum/
     * <p>
     * two_sum([1, 2, 3], 4) == {0, 2}
     * two_sum([3, 2, 4], 6) == {1, 2}
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3}, 4)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        final Map<Integer, Integer> tempNums = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int targetNum = target - numbers[i];
            if (tempNums.containsKey(targetNum))
                return new int[]{i, tempNums.get(targetNum)};
            tempNums.put(numbers[i], i);
        }
        return null;
    }
}
