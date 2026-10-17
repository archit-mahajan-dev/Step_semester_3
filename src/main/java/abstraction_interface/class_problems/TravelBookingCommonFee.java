import java.util.Locale;
import java.util.Scanner;

public class TravelBookingCommonFee {

    abstract static class Booking {
        private static final double BOOKING_FEE = 50.0;
        protected final double distanceKm;

        Booking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract double calculateBaseFare();

        double calculateTotal() {
            return calculateBaseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        double calculateBaseFare() {
            return distanceKm * 2.0;
        }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        double calculateBaseFare() {
            return distanceKm * 1.5;
        }
    }

    static class FlightBooking extends Booking {
        FlightBooking(double distanceKm) {
            super(distanceKm);
        }

        @Override
        double calculateBaseFare() {
            return 2500.0 + (distanceKm * 4.0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;
                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;
                case "FLIGHT":
                    booking = new FlightBooking(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown travel mode: " + mode);
            }

            System.out.printf(
                    Locale.US,
                    "%s: %.2f%n",
                    mode,
                    booking.calculateTotal()
            );
        }

        scanner.close();
    }
}
