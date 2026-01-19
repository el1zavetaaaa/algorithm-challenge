package algorithm.challenge.seasonfirst2026buildhabit;

/**
 * @author yelyzavetalubenets
 **/
public class MissingNumber268 {
    public static void main(String[] args) {

        System.out.println(missingNumber(new int[]{3,0,1}));
    }

    public static int missingNumber(int[] nums) {
         int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }

        return result;

    }
}
