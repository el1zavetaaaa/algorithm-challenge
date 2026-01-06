package algorithm.challenge.seasonfirst2026buildhabit;

/**
 * @author yelyzavetalubenets
 **/
public class FruitsIntoBasketsII3477 {
    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));
        System.out.println(numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7}));
        System.out.println(numOfUnplacedFruits(new int[]{8, 5}, new int[]{1, 8}));
        System.out.println(numOfUnplacedFruits(new int[]{1, 2, 1}, new int[]{3, 2, 2}));
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        boolean foundBasket = false;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruits[i] <= baskets[j]) {
                    foundBasket = true;
                    baskets = removeElement(baskets, j);
                    break;
                }
            }

            if (foundBasket) {
                foundBasket = false;
            } else count++;
        }

        return count;
    }

    private static int[] removeElement(int[] arr, int index) {
        final int[] newArr = new int[arr.length - 1];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[counter++] = arr[i];
            }
        }
        return newArr;
    }

}
