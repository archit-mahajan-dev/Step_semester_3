import java.util.*;

public class HostelElectricityBill {
    interface Room { double bill(); String type(); }
    static class Single implements Room {int units;Single(int u){units=u;}public double bill(){return 8.0*units;}public String type(){return "SINGLE";}}
    static class Shared implements Room {int units,occupants;Shared(int u,int o){units=u;occupants=o;}public double bill(){return 6.0*units/occupants;}public String type(){return "SHARED";}}
    static class AC implements Room {int units;AC(int u){units=u;}public double bill(){return 10.0*units+200;}public String type(){return "AC";}}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
        for(int i=0;i<n;i++){String type=sc.next();int units=sc.nextInt();Room r;
            switch(type){case "SINGLE":r=new Single(units);break;case "SHARED":r=new Shared(units,sc.nextInt());break;case "AC":r=new AC(units);break;default:throw new IllegalArgumentException();}
            double amount=r.bill();System.out.printf(Locale.US,"%s: %.2f%n",r.type(),amount);total+=amount;}
        System.out.printf(Locale.US,"Total: %.2f%n",total);}
}
