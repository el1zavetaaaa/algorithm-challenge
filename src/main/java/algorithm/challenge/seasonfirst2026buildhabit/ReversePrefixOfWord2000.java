package algorithm.challenge.seasonfirst2026buildhabit;

/**
 * @author yelyzavetalubenets
 **/
public class ReversePrefixOfWord2000 {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefix2("xyxzxe", 'z'));
        System.out.println(reversePrefix("abcd", 'z'));
    }

    public static String reversePrefix(String word, char ch) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                return reverse(word.substring(0, i + 1))
                        .concat(word.substring(i + 1));
            }
        }

        return word;
    }

    public static String reversePrefix2(String word, char ch) {
        var posCh = word.indexOf(ch);
        if (posCh <= 0)
            return word;
        var sb = new StringBuilder();
        for (var i = posCh; i >= 0; i--)
            sb.append(word.charAt(i));
        sb.append(word.substring(posCh + 1));
        return sb.toString();
    }

    private static String reverse(String toReverse) {
        StringBuilder result = new StringBuilder(toReverse);
        int i = 0;
        int j = toReverse.length() - 1;
        while (i < j) {
            char charI = toReverse.charAt(i);
            char charJ = toReverse.charAt(j);

            result.setCharAt(i, charJ);
            result.setCharAt(j, charI);
            i++;
            j--;
        }

        return result.toString();
    }
}
