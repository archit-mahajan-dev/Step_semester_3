import java.util.Locale;
import java.util.Scanner;

public class CollegeFeeCounter {

    interface BusUser {
        double transportFee();
    }

    abstract static class Student {
        private final String name;

        Student(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        abstract double tuitionFee();

        double hostelFee() {
            return 0.0;
        }

        double totalFee() {
            double busFee = this instanceof BusUser
                    ? ((BusUser) this).transportFee()
                    : 0.0;

            return tuitionFee() + hostelFee() + busFee;
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        @Override
        double tuitionFee() {
            return 40000.0;
        }

        @Override
        public double transportFee() {
            return 12000.0;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        @Override
        double tuitionFee() {
            return 40000.0;
        }

        @Override
        double hostelFee() {
            return 60000.0;
        }
    }

    static class Scholar extends Student implements BusUser {
        Scholar(String name) {
            super(name);
        }

        @Override
        double tuitionFee() {
            return 20000.0;
        }

        @Override
        public double transportFee() {
            return 12000.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String name = scanner.next();
            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown student type: " + type);
            }

            double fee = student.totalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", student.getName(), fee);
            totalCollected += fee;
        }

        System.out.printf(Locale.US, "Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}
