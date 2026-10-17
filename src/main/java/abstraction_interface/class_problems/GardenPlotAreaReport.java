import java.util.Locale;
import java.util.Scanner;

public class GardenPlotAreaReport {

    interface Plot {
        String getOwner();

        String getShape();

        double calculateArea();
    }

    static class Circle implements Plot {
        private final String owner;
        private final double radius;

        Circle(String owner, double radius) {
            this.owner = owner;
            this.radius = radius;
        }

        public String getOwner() {
            return owner;
        }

        public String getShape() {
            return "CIRCLE";
        }

        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle implements Plot {
        private final String owner;
        private final double length;
        private final double width;

        Rectangle(String owner, double length, double width) {
            this.owner = owner;
            this.length = length;
            this.width = width;
        }

        public String getOwner() {
            return owner;
        }

        public String getShape() {
            return "RECTANGLE";
        }

        public double calculateArea() {
            return length * width;
        }
    }

    static class Triangle implements Plot {
        private final String owner;
        private final double base;
        private final double height;

        Triangle(String owner, double base, double height) {
            this.owner = owner;
            this.base = base;
            this.height = height;
        }

        public String getOwner() {
            return owner;
        }

        public String getShape() {
            return "TRIANGLE";
        }

        public double calculateArea() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double totalArea = 0.0;

        for (int i = 0; i < count; i++) {
            String shape = scanner.next();
            String owner = scanner.next();
            Plot plot;

            switch (shape) {
                case "CIRCLE":
                    plot = new Circle(owner, scanner.nextDouble());
                    break;
                case "RECTANGLE":
                    plot = new Rectangle(owner, scanner.nextDouble(), scanner.nextDouble());
                    break;
                case "TRIANGLE":
                    plot = new Triangle(owner, scanner.nextDouble(), scanner.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown plot shape: " + shape);
            }

            double area = plot.calculateArea();
            System.out.printf(
                    Locale.US,
                    "%s (%s): %.2f%n",
                    plot.getOwner(),
                    plot.getShape(),
                    area
            );
            totalArea += area;
        }

        System.out.printf(Locale.US, "Total Area: %.2f%n", totalArea);
        scanner.close();
    }
}
