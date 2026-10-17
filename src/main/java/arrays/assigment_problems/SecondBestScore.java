import java.util.Scanner;

public class SecondBestScore {

    public static int secondHighest(int[] scores) {
        int highest = -1;
        int secondHighest = -1;

        for (int score : scores) {
            if (score > highest) {
                secondHighest = highest;
                highest = score;
            } else if (score < highest && score > secondHighest) {
                secondHighest = score;
            }
        }

        return secondHighest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        System.out.println(secondHighest(scores));
        scanner.close();
    }
}

/*
Input format:
n
n scores

Example:
5
45 78 92 78 60

Output:
78

If there is no second-highest distinct score, output -1.
Time complexity: O(n)
Auxiliary space: O(1)
*/
