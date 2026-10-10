package string.assigment_problems;

/**
 * Week 1 Assignment - Problem 5: The Movie Review Word Length Profiler.
 * Short = 1-4 letters, Medium = 5-8 letters, Long = 9+ letters.
 * Punctuation is stripped so "great!" counts as a 5-letter word.
 */
public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {
        int shortCount = 0, mediumCount = 0, longCount = 0;

        String[] words = review.trim().split("\\s+");
        for (String word : words) {
            int length = word.replaceAll("[^A-Za-z]", "").length();
            if (length == 0) {
                continue; // skip empty tokens and pure punctuation
            }
            if (length <= 4) {
                shortCount++;
            } else if (length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
