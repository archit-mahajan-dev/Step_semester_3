import java.util.Locale;
import java.util.Scanner;

public class ParcelShippingDesk {

    interface Insurable {
        double calculateInsurance();
    }

    abstract static class Parcel {
        protected final double weightKg;
        protected final double declaredValue;

        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        abstract double calculateCharge();

        double calculateInsurance() {
            return 0.0;
        }

        String getType() {
            return getClass().getSimpleName().toUpperCase();
        }

        double calculateTotal() {
            return calculateCharge() + calculateInsurance();
        }
    }

    static class Standard extends Parcel {
        Standard(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        double calculateCharge() {
            return 40.0 + (10.0 * weightKg);
        }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        double calculateCharge() {
            return 80.0 + (15.0 * weightKg);
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double weightKg, double declaredValue) {
            super(weightKg, declaredValue);
        }

        @Override
        double calculateCharge() {
            return 40.0 + (10.0 * weightKg) + 50.0;
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();
            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight, declaredValue);
                    break;
                case "EXPRESS":
                    parcel = new Express(weight, declaredValue);
                    break;
                case "FRAGILE":
                    parcel = new Fragile(weight, declaredValue);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown parcel type: " + type);
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                    Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type,
                    charge,
                    insurance,
                    total
            );
            grandTotal += total;
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
