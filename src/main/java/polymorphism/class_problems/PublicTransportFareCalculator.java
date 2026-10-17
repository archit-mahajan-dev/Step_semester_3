import java.util.*;

public class PublicTransportFareCalculator {
    interface Transport { double fare(); String type(); }
    static class Bus implements Transport {
        double distance; Bus(double d){distance=d;}
        public double fare(){return Math.min(10,2+0.10*distance);}
        public String type(){return "BUS";}
    }
    static class Train implements Transport {
        double distance; Train(double d){distance=d;}
        public double fare(){return 3+0.15*distance;}
        public String type(){return "TRAIN";}
    }
    static class Metro implements Transport {
        double distance, factor; Metro(double d,double f){distance=d;factor=f;}
        public double fare(){return (1.50+0.20*distance)*factor;}
        public String type(){return "METRO";}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); int n=sc.nextInt(); double total=0;
        for(int i=0;i<n;i++){
            String type=sc.next(); double distance=sc.nextDouble(); Transport t;
            switch(type){
                case "BUS":t=new Bus(distance);break;
                case "TRAIN":t=new Train(distance);break;
                case "METRO":t=new Metro(distance,sc.nextDouble());break;
                default:throw new IllegalArgumentException("Unknown transport type: "+type);
            }
            double fare=t.fare();System.out.printf(Locale.US,"%s: %.2f%n",t.type(),fare);total+=fare;
        }
        System.out.printf(Locale.US,"Total: %.2f%n",total);
    }
}
