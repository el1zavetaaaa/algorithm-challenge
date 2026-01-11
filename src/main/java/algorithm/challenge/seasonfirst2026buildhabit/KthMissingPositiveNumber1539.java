package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
public class KthMissingPositiveNumber1539 {
    public static void main(String[] args) {
        System.out.println(findKthPositive2(new int[]{2,3,4,7,11}, 5));
        System.out.println(findKthPositive2(new int[]{1,5,6}, 5));
        System.out.println(findKthPositive(new int[]{1,2,3,4}, 2));
        System.out.println(findKthPositive(new int[]{3,10}, 2));
    }

    public static int findKthPositive(int[] arr, int k) {
        final List<Integer> list = new ArrayList<>();
        if(arr[0] != 1){
            list.add(1);
            while (arr[0] - list.get(list.size() - 1) > 1){
                list.add(list.get(list.size() - 1) + 1);
            }
        }

        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i-1];

            if(arr[i] - prev > 1){
                list.add(prev + 1);
                while (arr[i] - list.get(list.size() - 1) > 1) {
                    list.add(list.get(list.size() - 1) + 1);
                }
            }
        }

        if(k > list.size() - 1){
            list.add(arr[arr.length - 1] + 1);
            for (int i = list.size() - 1; i < k; i++) {
                list.add(list.get(i) + 1);
            }
        }

        return list.get(k - 1);
    }
    public static int findKthPositive2(int[] arr, int k) {
        int missingSoFar = 0;
        int previous = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            int missingBetween = current - previous - 1;

            if (missingSoFar + missingBetween >= k) {
                return previous + (k - missingSoFar);
            }

            missingSoFar += missingBetween;
            previous = current;
        }

        return arr[arr.length - 1] + (k - missingSoFar);
    }

}
