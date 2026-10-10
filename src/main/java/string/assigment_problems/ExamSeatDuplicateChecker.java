package string.assigment_problems;

/**
 * Week 1 Assignment - Problem 1: The Exam Hall Seat Duplication Checker.
 * Arrays and nested loops only (no Collections classes).
 */
public class ExamSeatDuplicateChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        int[] reported = new int[seatNumbers.length]; // seats already printed
        int reportedCount = 0;
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    // Avoid printing the same duplicated seat more than once.
                    boolean alreadyReported = false;
                    for (int k = 0; k < reportedCount; k++) {
                        if (reported[k] == seatNumbers[i]) {
                            alreadyReported = true;
                            break;
                        }
                    }
                    if (!alreadyReported) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        reported[reportedCount++] = seatNumbers[i];
                        duplicateFound = true;
                    }
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}
