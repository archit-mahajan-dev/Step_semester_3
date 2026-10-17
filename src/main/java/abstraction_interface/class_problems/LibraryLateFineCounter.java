import java.util.Locale;
import java.util.Scanner;

public class LibraryLateFineCounter {

    interface LibraryItem {
        String getTitle();

        double calculateFine();
    }

    static class Book implements LibraryItem {
        private final String title;
        private final int daysLate;

        Book(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public String getTitle() {
            return title;
        }

        public double calculateFine() {
            return daysLate * 2.0;
        }
    }

    static class DVD implements LibraryItem {
        private final String title;
        private final int daysLate;

        DVD(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public String getTitle() {
            return title;
        }

        public double calculateFine() {
            return Math.min(daysLate * 5.0, 50.0);
        }
    }

    static class Magazine implements LibraryItem {
        private final String title;
        private final int daysLate;

        Magazine(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public String getTitle() {
            return title;
        }

        public double calculateFine() {
            return daysLate;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double totalFines = 0.0;

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, daysLate);
                    break;
                case "DVD":
                    item = new DVD(title, daysLate);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title, daysLate);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown library item: " + type);
            }

            double fine = item.calculateFine();
            System.out.printf(Locale.US, "%s: %.2f%n", item.getTitle(), fine);
            totalFines += fine;
        }

        System.out.printf(Locale.US, "Total Fines: %.2f%n", totalFines);
        scanner.close();
    }
}
