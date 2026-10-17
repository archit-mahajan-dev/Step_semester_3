package string.assigment_problems;
import java.util.Scanner;
public class WordReversalEncoder {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ", -1);
        StringBuilder result = new StringBuilder();
        for (int i=0;i<words.length;i++) {
            StringBuilder word = new StringBuilder();
            for (int j=words[i].length()-1;j>=0;j--) word.append(words[i].charAt(j));
            if (i>0) result.append(' ');
            result.append(word);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(reverseEachWord(sc.nextLine()));
        sc.close();
    }
}
