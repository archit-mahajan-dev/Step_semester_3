package string.class_problems;
import java.util.Scanner;
public class CsvStudentRecordParser {
    public static String parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) return "Invalid Record";
        return "Name: " + fields[0].trim() + " | Roll No: " + fields[1].trim()
                + " | Dept: " + fields[2].trim();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(parseStudentRecord(sc.nextLine()));
        sc.close();
    }
}
