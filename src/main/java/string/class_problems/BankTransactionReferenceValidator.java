package string.class_problems;
import java.util.Scanner;
public class BankTransactionReferenceValidator {
    public static String normalizeReference(String raw) {
        String value = raw.trim();
        if (value.length() < 3) return value.toUpperCase();
        return value.substring(0, 3).toUpperCase() + value.substring(3);
    }
    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: reference must be exactly 14 characters";
        for (int i = 0; i < 3; i++)
            if (!Character.isLetter(reference.charAt(i))) return "Invalid: bank code must be 3 letters";
        for (int i = 3; i < 14; i++)
            if (!Character.isDigit(reference.charAt(i))) return "Invalid: body must contain only digits";
        StringBuilder out = new StringBuilder();
        out.append('[').append(reference.substring(0, 3)).append("] DATE: ")
           .append(reference.substring(3, 5)).append('/')
           .append(reference.substring(5, 7)).append('/')
           .append(reference.substring(7, 9)).append(" | SEQ: ")
           .append(reference.substring(9));
        return out.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String normalized = normalizeReference(sc.nextLine());
        System.out.println(validateAndFormat(normalized));
        sc.close();
    }
}
