import java.util.Scanner;

public class ClassAttendanceTracker {

    public static int[] attendanceSummary(int[] days) {
        int presentDays = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int attendance : days) {
            if (attendance == 1) {
                presentDays++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[] { presentDays, longestStreak };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            days[i] = scanner.nextInt();
        }

        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0]
                + ", Longest streak: " + result[1]);

        scanner.close();
    }
}

/*
Input format:
n
n attendance values (1 = present, 0 = absent)

Example:
8
1 1 0 1 1 1 0 1

Output:
Present: 6, Longest streak: 3

Time complexity: O(n)
Auxiliary space: O(1), excluding the input array.
*/
