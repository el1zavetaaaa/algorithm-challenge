package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author yelyzavetalubenets
 **/
public class ClearDigits3174 {
    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
        System.out.println(clearDigits("cb34"));
    }

    public static String clearDigits(String s) {
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                characters.push(s.charAt(i));
            } else {
                if (!characters.empty()) {
                    characters.pop();
                }
            }
        }

        return characters.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
