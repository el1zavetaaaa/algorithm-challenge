package algorithm.challenge.faang_practice.arrays;


import java.util.HashSet;
import java.util.Set;

public class WhichAreIn {
    public static void main(String[] args) {
        final String[] arr = inArray(new String[]{"arp", "live", "strong"}, new String[]{"lively", "alive", "harp", "sharp", "armstrong"});
        final String[] arr2 = inArray(new String[]{"tarp", "mice", "bull"}, new String[]{"lively", "alive", "harp", "sharp", "armstrong"});
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }

    /**
     * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
     * <p>
     * Example 1:
     * <p>
     * a1 = ["arp", "live", "strong"]
     * <p>
     * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
     * <p>
     * returns ["arp", "live", "strong"]
     * <p>
     * Example 2:
     * <p>
     * a1 = ["tarp", "mice", "bull"]
     * <p>
     * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
     * <p>
     * returns []
     * <p>
     * Notes:
     * <p>
     * Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
     * In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
     * Beware: In some languages r must be without duplicates.
     */
    public static String[] inArray(String[] array1, String[] array2) {
        final Set<String> result = new HashSet<>();
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array2[i].contains(array1[j]))
                    result.add(array1[j]);
            }
        }

        return result.stream().sorted().toArray(String[]::new);
    }
}
