import java.util.Locale;
import java.util.Scanner;

public class HomeApplianceEnergyReport {

    interface SaverMode {
        double saverFactor();
    }

    abstract static class Appliance {
        protected final double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double powerWatts();

        double energyUnits() {
            return (powerWatts() * hours) / 1000.0;
        }

        double calculateCost() {
            return energyUnits() * 8.0;
        }

        boolean supportsSaverMode() {
            return this instanceof SaverMode;
        }

        double energyUnits(boolean saverRequested) {
            double units = energyUnits();

            if (saverRequested && this instanceof SaverMode) {
                units *= ((SaverMode) this).saverFactor();
            }

            return units;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }

        @Override
        double powerWatts() {
            return 150.0;
        }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        AirConditioner(double hours) {
            super(hours);
        }

        @Override
        double powerWatts() {
            return 1500.0;
        }

        @Override
        public double saverFactor() {
            return 0.75;
        }
    }

    static class Television extends Appliance {
        Television(double hours) {
            super(hours);
        }

        @Override
        double powerWatts() {
            return 100.0;
        }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) {
            super(hours);
        }

        @Override
        double powerWatts() {
            return 500.0;
        }

        @Override
        public double saverFactor() {
            return 0.75;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            double hours = scanner.nextDouble();
            boolean saverRequested = scanner.hasNext("SAVER");

            if (saverRequested) {
                scanner.next();
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown appliance: " + type);
            }

            if (saverRequested && !appliance.supportsSaverMode()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.energyUnits(saverRequested);
            double cost = units * 8.0;

            System.out.printf(
                    Locale.US,
                    "%s: Units=%.2f Cost=%.2f%n",
                    type,
                    units,
                    cost
            );
            totalCost += cost;
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}
