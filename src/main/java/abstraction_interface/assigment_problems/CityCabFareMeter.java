import java.util.Locale;
import java.util.Scanner;

public class CityCabFareMeter {

    interface NightService {
        double applyNightCharge(double fare);
    }

    abstract static class Cab {
        protected final double distanceKm;

        Cab(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract double ratePerKm();

        double calculateFare() {
            return Math.max(distanceKm * ratePerKm(), 100.0);
        }
    }

    static class Mini extends Cab {
        Mini(double distanceKm) {
            super(distanceKm);
        }

        @Override
        double ratePerKm() {
            return 10.0;
        }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double distanceKm) {
            super(distanceKm);
        }

        @Override
        double ratePerKm() {
            return 14.0;
        }

        @Override
        public double applyNightCharge(double fare) {
            return fare * 1.20;
        }
    }

    static class SUV extends Cab implements NightService {
        SUV(double distanceKm) {
            super(distanceKm);
        }

        @Override
        double ratePerKm() {
            return 18.0;
        }

        @Override
        public double applyNightCharge(double fare) {
            return fare * 1.20;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            String time = scanner.next();
            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini(distance);
                    break;
                case "SEDAN":
                    cab = new Sedan(distance);
                    break;
                case "SUV":
                    cab = new SUV(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cab type: " + type);
            }

            if (time.equals("NIGHT")) {
                if (!(cab instanceof NightService)) {
                    System.out.println(type + ": night service not available");
                    continue;
                }

                NightService nightCab = (NightService) cab;
                double fare = nightCab.applyNightCharge(cab.calculateFare());
                System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
                total += fare;
            } else {
                double fare = cab.calculateFare();
                System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        scanner.close();
    }
}
