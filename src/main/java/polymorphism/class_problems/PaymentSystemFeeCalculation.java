import java.util.*;

public class PaymentSystemFeeCalculation {
    interface Payment {
        double adjustedAmount(double amount);
        String type();
    }
    static class Card implements Payment {
        public double adjustedAmount(double amount) { return amount * 1.02; }
        public String type() { return "CARD"; }
    }
    static class Wallet implements Payment {
        public double adjustedAmount(double amount) { return amount * 1.01; }
        public String type() { return "WALLET"; }
    }
    static class BankTransfer implements Payment {
        public double adjustedAmount(double amount) { return amount; }
        public String type() { return "BANKTRANSFER"; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double amount = Double.parseDouble(p[1]);
            Payment payment;
            switch (type) {
                case "CARD": payment = new Card(); break;
                case "WALLET": payment = new Wallet(); break;
                case "BANKTRANSFER": payment = new BankTransfer(); break;
                default: throw new IllegalArgumentException("Unknown payment type: " + type);
            }
            double adjusted = payment.adjustedAmount(amount);
            System.out.printf(Locale.US, "%s: %.2f%n", payment.type(), adjusted);
            total += adjusted;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
