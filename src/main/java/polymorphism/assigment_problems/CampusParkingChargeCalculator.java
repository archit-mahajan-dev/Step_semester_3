import java.util.*;

public class CampusParkingChargeCalculator {
    interface Vehicle { double charge(); String type(); }
    static class Bike implements Vehicle {int h;Bike(int h){this.h=h;}public double charge(){return 10.0*h;}public String type(){return "BIKE";}}
    static class Car implements Vehicle {int h;Car(int h){this.h=h;}public double charge(){return 30.0+20.0*(h-1);}public String type(){return "CAR";}}
    static class Truck implements Vehicle {int h;Truck(int h){this.h=h;}public double charge(){return Math.max(100.0,50.0*h);}public String type(){return "TRUCK";}}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
        for(int i=0;i<n;i++){String type=sc.next();int hours=sc.nextInt();Vehicle v;
            switch(type){case "BIKE":v=new Bike(hours);break;case "CAR":v=new Car(hours);break;case "TRUCK":v=new Truck(hours);break;default:throw new IllegalArgumentException();}
            double charge=v.charge();System.out.printf(Locale.US,"%s: %.2f%n",v.type(),charge);total+=charge;}
        System.out.printf(Locale.US,"Total: %.2f%n",total);}
}
