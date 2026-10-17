import java.time.LocalDate;
import java.util.*;

public class StreamingPlanRenewalReminder {
    interface Plan { int days(); String name(); }
    static class Basic implements Plan {String n;Basic(String n){this.n=n;}public int days(){return 30;}public String name(){return n;}}
    static class Standard implements Plan {String n;Standard(String n){this.n=n;}public int days(){return 90;}public String name(){return n;}}
    static class Premium implements Plan {String n;Premium(String n){this.n=n;}public int days(){return 365;}public String name(){return n;}}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=Integer.parseInt(sc.nextLine().trim());
        for(int i=0;i<n;i++){String[] p=sc.nextLine().trim().split("\\s+");String type=p[0],name=p[1];LocalDate start=LocalDate.parse(p[2]);Plan plan;
            switch(type){case "BASIC":plan=new Basic(name);break;case "STANDARD":plan=new Standard(name);break;case "PREMIUM":plan=new Premium(name);break;default:throw new IllegalArgumentException();}
            System.out.println(plan.name()+": "+start.plusDays(plan.days()));}
    }
}
