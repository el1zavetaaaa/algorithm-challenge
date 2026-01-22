package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.Arrays;

/**
 * @author yelyzavetalubenets
 **/
public class FindTheDistanceValueBetweenTwoArrays1385 {
    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
        System.out.println(findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3));
        System.out.println(findTheDistanceValue(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int x = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (!existsInRange(arr2, arr1[i] - d, arr1[i] + d)) {
                x++;
            }
        }
        return x;
    }

    private static boolean existsInRange(int[] arr, int leftBound, int rightBound) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < leftBound) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left < arr.length && arr[left] <= rightBound;
    }
}
