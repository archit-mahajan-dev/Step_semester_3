import java.util.Scanner;

public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int rotation = (int) (k % n);
        String[] rotatedNames = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + rotation) % n;
            rotatedNames[newIndex] = names[i];
        }

        return rotatedNames;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = scanner.next();
        }

        long k = scanner.nextLong();
        String[] result = rotateRoster(names, k);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
}

/*
Input format:
n
n names
k

Example:
5
A B C D E
7

Output:
[D, E, A, B, C]

Time complexity: O(n)
Auxiliary space: O(n)
*/
