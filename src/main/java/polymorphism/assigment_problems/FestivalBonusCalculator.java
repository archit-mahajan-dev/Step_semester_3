import java.util.*;

public class FestivalBonusCalculator {
    interface Employee { double bonus(); String name(); }
    static class FullTime implements Employee {String n;double s;FullTime(String n,double s){this.n=n;this.s=s;}public double bonus(){return s*.10;}public String name(){return n;}}
    static class PartTime implements Employee {String n;double s;PartTime(String n,double s){this.n=n;this.s=s;}public double bonus(){return s*.05;}public String name(){return n;}}
    static class Intern implements Employee {String n;double s;Intern(String n,double s){this.n=n;this.s=s;}public double bonus(){return 2000;}public String name(){return n;}}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;
        for(int i=0;i<n;i++){String type=sc.next(),name=sc.next();double salary=sc.nextDouble();Employee e;
            switch(type){case "FULLTIME":e=new FullTime(name,salary);break;case "PARTTIME":e=new PartTime(name,salary);break;case "INTERN":e=new Intern(name,salary);break;default:throw new IllegalArgumentException();}
            double b=e.bonus();System.out.printf(Locale.US,"%s: %.2f%n",e.name(),b);total+=b;}
        System.out.printf(Locale.US,"Total Bonus: %.2f%n",total);}
}
