import java.util.Scanner;

public class ExamScoreBandCounter {

    public static int countInBand(int[] scores, int low, int high) {
        int firstAtLeastLow = lowerBound(scores, low);
        int firstGreaterThanHigh = upperBound(scores, high);

        return firstGreaterThanHigh - firstAtLeastLow;
    }

    private static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (scores[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (scores[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        int low = scanner.nextInt();
        int high = scanner.nextInt();

        System.out.println(countInBand(scores, low, high));
        scanner.close();
    }
}

/*
Input format:
n
n sorted scores
low high

Example:
10
35 42 42 50 58 58 58 63 71 88
42 58

Output:
6

Time complexity: O(log n)
Auxiliary space: O(1)
*/
