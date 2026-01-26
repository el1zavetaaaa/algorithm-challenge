package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
public class IntersectionOfTwoArraysII350 {
    public static void main(String[] args) {
        final int[] result = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        final int[] result2 = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result2[i]);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = nums1.length - 1;
        int j = nums2.length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i--;
                j--;
            } else if (nums1[i] > nums2[j])
                i--;
            else j--;
        }

        int[] res = new int[result.size()];
        int k = 0;
        for (Integer num : result) {
            res[k] = num;
            k++;
        }
        return res;
    }
}
