import java.util.Scanner;

public class BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {
        int bestRowIndex = 0;
        int largestTotal = -1;

        for (int row = 0; row < grid.length; row++) {
            int rowTotal = 0;

            for (int column = 0; column < grid[row].length; column++) {
                rowTotal += grid[row][column];
            }

            // Strictly greater preserves the smaller index when totals tie.
            if (rowTotal > largestTotal) {
                largestTotal = rowTotal;
                bestRowIndex = row;
            }
        }

        return new int[] { bestRowIndex, largestTotal };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] grid = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = scanner.nextInt();
            }
        }

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);

        scanner.close();
    }
}

/*
Input format:
rows columns
grid values row by row

Example:
3 3
2 0 1
3 3 1
1 1 1

Output:
Row 1, Total 7

Time complexity: O(r * c)
Auxiliary space: O(1), excluding the input grid.
*/
