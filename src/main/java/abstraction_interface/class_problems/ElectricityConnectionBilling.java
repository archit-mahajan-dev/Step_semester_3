import java.util.Locale;
import java.util.Scanner;

public class ElectricityConnectionBilling {

    abstract static class Connection {
        protected final double units;

        Connection(double units) {
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class Home extends Connection {
        Home(double units) {
            super(units);
        }

        @Override
        double calculateBill() {
            if (units <= 100) {
                return units * 5.0;
            }

            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }

    static class Shop extends Connection {
        Shop(double units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return (units * 8.0) + 100.0;
        }
    }

    static class Factory extends Connection {
        Factory(double units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return Math.max(units * 6.0, 1000.0);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            Connection connection;

            switch (type) {
                case "HOME":
                    connection = new Home(units);
                    break;
                case "SHOP":
                    connection = new Shop(units);
                    break;
                case "FACTORY":
                    connection = new Factory(units);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown connection type: " + type);
            }

            double bill = connection.calculateBill();
            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        scanner.close();
    }
}
