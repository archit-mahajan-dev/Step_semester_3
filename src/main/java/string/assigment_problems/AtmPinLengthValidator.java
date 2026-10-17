package string.assigment_problems;
import java.util.Scanner;
public class AtmPinLengthValidator {
    public static String checkPinLength(String pin) {
        if (pin.length() != 4) return "Invalid PIN — must be exactly 4 digits.";
        for (int i=0;i<pin.length();i++)
            if (!Character.isDigit(pin.charAt(i))) return "Invalid PIN — must be exactly 4 digits.";
        return "PIN length OK.";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(checkPinLength(sc.nextLine()));
        sc.close();
    }
}
