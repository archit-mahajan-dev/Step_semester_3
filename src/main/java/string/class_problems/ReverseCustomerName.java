package string.class_problems;

/**
 * Day 1 - Problem 5: Reverse Customer Name (The Customer Identity Verification System).
 * The original name is never modified; a new reversed String is returned.
 */
public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return new String(reversed);
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}
