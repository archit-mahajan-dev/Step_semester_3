public class EmployeeCompanyInfo {
    private String empName;
    private double salary;
    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount = 0;

    public EmployeeCompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeCompanyInfo("Divya", 65000);
        new EmployeeCompanyInfo("Arjun", 0);
        new EmployeeCompanyInfo("Priya", 72000);
        EmployeeCompanyInfo.printCompanyInfo();
    }
}
