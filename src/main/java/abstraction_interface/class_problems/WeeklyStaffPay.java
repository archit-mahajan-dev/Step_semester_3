import java.util.Locale;
import java.util.Scanner;

public class WeeklyStaffPay {

    abstract static class StaffMember {
        private final String name;

        StaffMember(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        abstract double calculatePay();
    }

    static class FullTimeStaff extends StaffMember {
        private final double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        double calculatePay() {
            return weeklySalary;
        }
    }

    static class HourlyStaff extends StaffMember {
        private final double hours;
        private final double rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        double calculatePay() {
            if (hours <= 40) {
                return hours * rate;
            }

            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }

    static class Intern extends StaffMember {
        private final double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        double calculatePay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        double totalPayroll = 0.0;

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String name = scanner.next();
            StaffMember staffMember;

            switch (type) {
                case "FULLTIME":
                    staffMember = new FullTimeStaff(name, scanner.nextDouble());
                    break;
                case "HOURLY":
                    staffMember = new HourlyStaff(
                            name,
                            scanner.nextDouble(),
                            scanner.nextDouble()
                    );
                    break;
                case "INTERN":
                    staffMember = new Intern(name, scanner.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown staff type: " + type);
            }

            double pay = staffMember.calculatePay();
            System.out.printf(Locale.US, "%s: %.2f%n", staffMember.getName(), pay);
            totalPayroll += pay;
        }

        System.out.printf(Locale.US, "Total Payroll: %.2f%n", totalPayroll);
        scanner.close();
    }
}
