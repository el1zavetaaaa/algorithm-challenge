package algorithm.challenge.faang_practice.arrays;

public class IncreasingTripletSubsequence334 {
    /**
     * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
     * <p>
     * Example 1:
     * Input: nums = [1,2,3,4,5]
     * Output: true
     * Explanation: Any triplet where i < j < k is valid.
     * <p>
     * Example 2:
     * Input: nums = [5,4,3,2,1]
     * Output: false
     * Explanation: No triplet exists.
     * <p>
     * Example 3:
     * Input: nums = [2,1,5,0,4,6]
     * Output: true
     * Explanation: One of the valid triplet is (1, 4, 5), because nums[1] == 1 < nums[4] == 4 < nums[5] == 6.
     */
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet(new int[]{1, 1, -2, 6}));
        System.out.println(increasingTriplet(new int[]{1, 2, 1, 3}));

    }

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= first) {
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                return true;
            }
        }
        return false;
    }


}
