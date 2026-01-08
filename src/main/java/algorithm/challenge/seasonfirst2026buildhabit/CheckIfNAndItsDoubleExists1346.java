package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yelyzavetalubenets
 **/
public class CheckIfNAndItsDoubleExists1346 {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(checkIfExist(new int[]{3, 1, 7, 11}));
        System.out.println(checkIfExist(new int[]{0, 0}));
        System.out.println(checkIfExist(new int[]{0, -2, 2}));
    }

    public static boolean checkIfExist(int[] arr) {
        final List<Integer> arrList = new ArrayList<>();
        for (int num : arr) {
            arrList.add(num);
        }

        List<Integer> filteredList = arrList.stream()
                .filter(curr -> curr % 2 == 0 && curr != 0)
                .map(curr -> curr / 2)
                .toList();

        List<Integer> filteredNullList = arrList.stream()
                .filter(curr -> curr == 0)
                .toList();

        return arrList.stream().anyMatch(filteredList::contains) || filteredNullList.size() > 1;
    }
}
