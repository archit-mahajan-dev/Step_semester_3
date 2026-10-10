package string.assigment_problems;

/**
 * Week 1 Assignment - Problem 2: The Typing Speed Test Accuracy Checker.
 * Positions are reported 1-based, as in the sample output.
 */
public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: both strings must have the same length.");
            return;
        }
        if (original.isEmpty()) {
            System.out.println("Error: strings must not be empty.");
            return;
        }

        int total = original.length();
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / total;
        String mismatchInfo = (firstMismatch == -1)
                ? "No Mismatches"
                : "First Mismatch at position " + (firstMismatch + 1)
                  + " ('" + original.charAt(firstMismatch) + "' vs '" + typed.charAt(firstMismatch) + "')";

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | %s%n", matched, total, accuracy, mismatchInfo);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
