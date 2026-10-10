package string.class_problems;

import java.util.Scanner;

/**
 * Day 1 - Problem 2: Palindrome Checker (3 Approaches) - The QA Text Verification Toolkit.
 * Iterative, recursive and array-reversal checks must always agree.
 * Case and non-alphanumeric characters are ignored so short phrases also work.
 */
public class PalindromeChecker {

    private static String normalize(String text) {
        return text.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    /** Approach 1: compare characters from both ends moving toward the middle. */
    public static boolean isPalindromeIterative(String text) {
        String s = normalize(text);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /** Approach 2: compare first and last characters, then recurse on the inner substring. */
    public static boolean isPalindromeRecursive(String text) {
        return recursiveCheck(normalize(text));
    }

    private static boolean recursiveCheck(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return recursiveCheck(s.substring(1, s.length() - 1));
    }

    /** Approach 3: reverse a character array and compare it with the original. */
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = normalize(text).toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    private static String label(boolean result) {
        return result ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String text = scanner.nextLine();

        System.out.println("Iterative: " + label(isPalindromeIterative(text))
                + " | Recursive: " + label(isPalindromeRecursive(text))
                + " | Array Reversal: " + label(isPalindromeArrayReversal(text)));
        scanner.close();
    }
}
