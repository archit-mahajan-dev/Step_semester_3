import java.util.Locale;
import java.util.Scanner;

public class MovieTicketCounter {

    abstract static class Ticket {
        private static final double CONVENIENCE_FEE = 20.0;
        protected final int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract double pricePerTicket();

        double totalAmount() {
            return count * (pricePerTicket() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends Ticket {
        RegularTicket(int count) {
            super(count);
        }

        @Override
        double pricePerTicket() {
            return 150.0;
        }
    }

    static class PremiumTicket extends Ticket {
        PremiumTicket(int count) {
            super(count);
        }

        @Override
        double pricePerTicket() {
            return 250.0;
        }
    }

    static class ReclinerTicket extends Ticket {
        ReclinerTicket(int count) {
            super(count);
        }

        @Override
        double pricePerTicket() {
            return 400.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookings = scanner.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < bookings; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown seat type: " + seat);
            }

            double amount = ticket.totalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", seat, amount);
            totalCollected += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", totalCollected);
        scanner.close();
    }
}
