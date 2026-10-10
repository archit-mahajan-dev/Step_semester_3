package string.class_problems;

import java.util.Random;

/**
 * Day 1 - Problem 3: BMI Calculator for a Team (The Corporate Wellness Program).
 * Computes BMI for each person, classifies the status and prints a wellness table.
 */
public class BmiCalculator {

    /** BMI < 18.5 Underweight; 18.5-24.9 Normal; 25-29.9 Overweight; >= 30 Obese. */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-8s | %-10s | %-11s | %-6s | %s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------+------------+-------------+--------+-------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d | %-10.2f | %-11.1f | %-6.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        final int team = 10;
        double[] heights = new double[team];
        double[] weights = new double[team];
        Random random = new Random();

        // Random values for a fast live demo: height 1.50-1.95 m, weight 45-110 kg.
        for (int i = 0; i < team; i++) {
            heights[i] = Math.round((1.50 + random.nextDouble() * 0.45) * 100.0) / 100.0;
            weights[i] = Math.round((45 + random.nextDouble() * 65) * 10.0) / 10.0;
        }

        printWellnessReport(heights, weights);
    }
}
