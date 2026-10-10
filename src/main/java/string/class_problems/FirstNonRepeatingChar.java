package string.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Day 1 - Problem 4: First Non-Repeating Character (The Unique Letter Hunt Mini-Game).
 */
public class FirstNonRepeatingChar {

    /** Returns the first character that occurs exactly once, or '\0' if there is none. */
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (frequency.get(c) == 1) {
                return c; // early exit on the first unique character
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
        scanner.close();
    }
}
