package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yelyzavetalubenets
 **/
public class IntersectionsOfTwoArrays349 {
    public static void main(String[] args) {
        int[] arr = intersection(new int[]{1,2,2,1}, new int[]{2,2});
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int[] arr2 =  intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});;
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
       final Set<Integer> set1 = new HashSet<>();
       final Set<Integer> set2 = new HashSet<>();

        for (int num: nums1) {
            set1.add(num);
        }

        for (int num: nums2) {
            if(set1.contains(num)){
                set2.add(num);
            }
        }

        final int[] result = new int[set2.size()];
        int k =0;
        for (int num: set2) {
            result[k++] = num;
        }

        return result;
    }
}
