package algorithm.challenge.seasonfirst2026buildhabit;

/**
 * @author yelyzavetalubenets
 **/
public class CountNegativeNumbersInASortedMatrix1351 {
    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
        System.out.println(countNegatives2(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    count++;
                } else break;
            }
        }

        return count;
    }

    public static int countNegatives2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int i = 0;          // start at top row
        int j = cols - 1;   // start at rightmost column
        int count = 0;

        while (i < rows && j >= 0) {
            if (grid[i][j] < 0) {
                // all elements below grid[i][j] are also negative
                count += (rows - i);
                j--; // move left
            } else {
                i++; // move down
            }
        }

        return count;
    }
}
