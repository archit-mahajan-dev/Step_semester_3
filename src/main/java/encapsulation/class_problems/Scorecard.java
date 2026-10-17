public class Scorecard {
    private final boolean[] results;
    private int recordedCount;

    public Scorecard(int questionCount) {
        if (questionCount < 0) {
            throw new IllegalArgumentException("Question count cannot be negative");
        }
        results = new boolean[questionCount];
        recordedCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedCount >= results.length) {
            System.out.println("Answer rejected: scorecard is full");
            return;
        }
        results[recordedCount++] = correct;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
    }
}
