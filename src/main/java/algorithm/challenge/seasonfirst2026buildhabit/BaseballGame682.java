package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yelyzavetalubenets
 **/
public class BaseballGame682 {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
        System.out.println(calPoints2(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints2(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    public static int calPoints(String[] operations) {
        final Deque<Integer> baseballScore = new ArrayDeque<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int previousTop = baseballScore.pop();
                int newTop = baseballScore.peek() + previousTop;
                baseballScore.push(previousTop);
                baseballScore.push(newTop);
            } else if (op.equals("D"))
                baseballScore.push(baseballScore.peek() * 2);
            else if (op.equals("C"))
                baseballScore.pop();
            else
                baseballScore.push(Integer.valueOf(op));
        }

        return baseballScore.stream().reduce(Integer::sum).orElse(0);
    }

    public static int calPoints2(String[] operations) {
        final Deque<Integer> baseballScore = new ArrayDeque<>();

        int count = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                int top = baseballScore.pop();
                int newTop = top + baseballScore.peek();
                count += newTop;
                baseballScore.push(top);
                baseballScore.push(newTop);
            } else if (operations[i].equals("D")) {
                count += baseballScore.peek() * 2;
                baseballScore.push(baseballScore.peek() * 2);
            } else if (operations[i].equals("C"))
                count -= baseballScore.pop();
            else {
                baseballScore.push(Integer.valueOf(operations[i]));
                count += Integer.parseInt(operations[i]);
            }
        }

        return count;
    }
}
