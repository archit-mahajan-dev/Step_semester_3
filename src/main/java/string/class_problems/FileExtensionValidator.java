package string.class_problems;
import java.util.Scanner;
public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot < 0 || dot == filename.length() - 1) return "Rejected — invalid file type";
        String ext = filename.substring(dot + 1);
        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx")
                || ext.equalsIgnoreCase("zip")) return "Accepted";
        return "Rejected — invalid file type";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(validateFileExtension(sc.nextLine()));
        sc.close();
    }
}
