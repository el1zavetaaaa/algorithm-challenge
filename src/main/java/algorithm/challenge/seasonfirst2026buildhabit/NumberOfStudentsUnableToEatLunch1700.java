package algorithm.challenge.seasonfirst2026buildhabit;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yelyzavetalubenets
 **/
public class NumberOfStudentsUnableToEatLunch1700 {
    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> studentsS = new ArrayDeque<>();
        Deque<Integer> sandwichesS = new ArrayDeque<>();

        for (int student: students) {
            studentsS.addLast(student);
        }
        for (int sandwich: sandwiches) {
            sandwichesS.addLast(sandwich);
        }

        while (!sandwichesS.isEmpty()){
            if(!studentsS.contains(sandwichesS.getFirst())){
                break;
            }
            if(!studentsS.getFirst().equals(sandwichesS.getFirst())){
                int firstVal = studentsS.getFirst();
                studentsS.removeFirst();
                studentsS.addLast(firstVal);
            } else {
                studentsS.removeFirst();
                sandwichesS.removeFirst();
            }
        }

        return studentsS.size();
    }
}
