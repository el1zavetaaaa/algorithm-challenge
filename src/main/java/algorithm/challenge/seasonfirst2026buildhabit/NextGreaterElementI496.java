package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yelyzavetalubenets
 **/
public class NextGreaterElementI496 {
    public static void main(String[] args) {
        final int[] result = nextGreaterElement2(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int num : result) {
            System.out.println(num);
        }

        final int[] result2 = nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        for (int num : result2) {
            System.out.println(num);
        }

        final int[] result3 = nextGreaterElement2(new int[]{1, 3, 5, 2, 4}, new int[]{6, 5, 4, 3, 2, 1, 7});
        for (int num : result3) {
            System.out.println(num);
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    nums1[i] = -1;
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums2[j]) {
                            nums1[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }

        return nums1;
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
