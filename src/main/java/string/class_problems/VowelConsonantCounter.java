package string.class_problems;
import java.util.Scanner;
public class VowelConsonantCounter {
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c == ' ') continue;
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') vowels++;
            else if (c >= 'a' && c <= 'z') consonants++;
        }
        return new int[]{vowels, consonants};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] result = countVowelsAndConsonants(text);
        System.out.println("Vowels: " + result[0] + " | Consonants: " + result[1]);
        sc.close();
    }
}
