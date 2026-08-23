package algorithm.challenge.faang_practice.arrays;

public class StringCompression443 {
    /**
     Given an array of characters chars, compress it using the following algorithm:

     Begin with an empty string s. For each group of consecutive repeating characters in chars:

     If the group's length is 1, append the character to s.
     Otherwise, append the character followed by the group's length.
     The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

     After you are done modifying the input array, return the new length of the array.

     You must write an algorithm that uses only constant extra space.

     Note: The characters in the array beyond the returned length do not matter and should be ignored.



     Example 1:

     Input: chars = ["a","a","b","b","c","c","c"]
     Output: 6
     Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
     After modifying the input array in-place, the first 6 characters of chars should be ["a","2","b","2","c","3"].
     Example 2:

     Input: chars = ["a"]
     Output: 1
     Explanation: The only group is "a", which remains uncompressed since it is a single character.
     After modifying the input array in-place, the first character of chars should be ["a"].
     Example 3:

     Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     Output: 4
     Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
     After modifying the input array in-place, the first 4 characters of chars should be ["a","b","1","2"].
     */
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    public static int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char currentChar = chars[read];
            int start = read;
            while (read < chars.length && chars[read] == currentChar) {
                read++;
            }
            int count = read - start;

            chars[write++] = currentChar;
            if (count > 1) {
                int digitsStart = write;
                int n = count;
                while (n > 0) {
                    chars[write++] = (char) ('0' + n % 10);
                    n /= 10;
                }
                reverse(chars, digitsStart, write - 1); // digits came out reversed
            }
        }
        return write;
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

}
