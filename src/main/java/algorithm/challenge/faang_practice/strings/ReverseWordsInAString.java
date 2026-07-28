package algorithm.challenge.faang_practice.strings;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
    }

    /**
     A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     Return a string of the words in reverse order concatenated by a single space.
     Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

     Example 1:
     Input: s = "the sky is blue"
     Output: "blue is sky the"

     Example 2:
     Input: s = "  hello world  "
     Output: "world hello"
     Explanation: Your reversed string should not contain leading or trailing spaces.

     Example 3:
     Input: s = "a good   example"
     Output: "example good a"
     Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
    **/
    public static String reverseWords(String s) {
        s = s.trim().replaceAll("\s+", " ");
        final String[] initial = s.split(" ");

        final String[] reversed = new String[initial.length];
        for (int i = 0; i < initial.length; i++) {
            reversed[i] = initial[initial.length - 1 - i];
        }
        return String.join(" ", reversed);
    }
}
