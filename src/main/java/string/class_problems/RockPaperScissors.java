package string.class_problems;

import java.util.Random;

/**
 * Day 1 - Problem 1: Rock-Paper-Scissors Game (The College Coding Arcade).
 * Plays N rounds between the player and the computer and prints a scoreboard.
 */
public class RockPaperScissors {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /** Returns "Player Wins", "Computer Wins" or "Draw" for a single round. */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        final int rounds = 5;
        // Predefined player moves keep the live demo quick; computer moves are random.
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;
        for (int i = 0; i < rounds; i++) {
            computerMoves[i] = MOVES[random.nextInt(MOVES.length)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            System.out.println("Round " + (i + 1) + " - Player: " + playerMoves[i]
                    + ", Computer: " + computerMoves[i] + " -> " + results[i]);
            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println();
        System.out.printf("%-7s | %-12s | %-13s | %s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("--------+--------------+---------------+--------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-7d | %-12s | %-13s | %s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.println();
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}
