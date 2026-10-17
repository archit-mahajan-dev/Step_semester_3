public class StudentCollegeInfo {
    private String name;
    private int attendance;
    private static String collegeName = "SRM Institute of Science and Technology";
    private static int studentCount = 0;

    public StudentCollegeInfo(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new StudentCollegeInfo("Ravi", 90);
        new StudentCollegeInfo("Anitha", 95);
        StudentCollegeInfo.printCollegeInfo();
    }
}
