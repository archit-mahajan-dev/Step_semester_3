import java.util.*;

public class CanteenBillingCounter {
    interface Customer { double finalAmount(double amount); String type(); }
    static class Student implements Customer { public double finalAmount(double a){return a*0.90;} public String type(){return "STUDENT";} }
    static class Staff implements Customer { public double finalAmount(double a){return a*0.95;} public String type(){return "STAFF";} }
    static class Guest implements Customer { public double finalAmount(double a){return a+10;} public String type(){return "GUEST";} }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
        for(int i=0;i<n;i++){String type=sc.next();double amount=sc.nextDouble();Customer c;
            switch(type){case "STUDENT":c=new Student();break;case "STAFF":c=new Staff();break;case "GUEST":c=new Guest();break;default:throw new IllegalArgumentException();}
            double value=c.finalAmount(amount);System.out.printf(Locale.US,"%s: %.2f%n",c.type(),value);total+=value;}
        System.out.printf(Locale.US,"Total: %.2f%n",total);
    }
}
