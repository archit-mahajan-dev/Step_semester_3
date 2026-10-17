import java.util.*;

public class DeliveryFeeCalculator {
    interface Delivery { double fee(); String type(); }
    static class Standard implements Delivery {
        double w, d; Standard(double w, double d) { this.w=w; this.d=d; }
        public double fee() { return 5 + 0.50*w + 0.10*d; }
        public String type() { return "STANDARD"; }
    }
    static class Express implements Delivery {
        double w, d; Express(double w, double d) { this.w=w; this.d=d; }
        public double fee() { return 15 + w + 0.20*d; }
        public String type() { return "EXPRESS"; }
    }
    static class International implements Delivery {
        double w, d, customs; International(double w, double d, double c) { this.w=w; this.d=d; customs=c; }
        public double fee() { return 25 + 2*w + 0.50*d + customs; }
        public String type() { return "INTERNATIONAL"; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); double total=0;
        for (int i=0;i<n;i++) {
            String type=sc.next(); double w=sc.nextDouble(), d=sc.nextDouble();
            Delivery delivery;
            switch(type) {
                case "STANDARD": delivery=new Standard(w,d); break;
                case "EXPRESS": delivery=new Express(w,d); break;
                case "INTERNATIONAL": delivery=new International(w,d,sc.nextDouble()); break;
                default: throw new IllegalArgumentException("Unknown delivery type: "+type);
            }
            double fee=delivery.fee();
            System.out.printf(Locale.US,"%s: %.2f%n",delivery.type(),fee); total+=fee;
        }
        System.out.printf(Locale.US,"Total: %.2f%n",total);
    }
}
