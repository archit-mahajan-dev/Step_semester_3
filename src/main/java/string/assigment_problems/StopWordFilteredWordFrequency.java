package string.assigment_problems;
import java.util.*;
public class StopWordFilteredWordFrequency {
    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the","was","and","a","is","of","in"));
    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "")
                .replace("!", "").replace("?", "").replace(";", "").replace(":", "");
        String trimmed = cleaned.trim();
        if (trimmed.isEmpty()) return;
        String[] words = trimmed.split("\\s+");
        Map<String,Integer> counts = new HashMap<>();
        for (String word : words) {
            if (!STOP_WORDS.contains(word) && !word.isEmpty())
                counts.put(word, counts.getOrDefault(word,0)+1);
        }
        List<Map.Entry<String,Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort((a,b) -> Integer.compare(b.getValue(), a.getValue()));
        for (Map.Entry<String,Integer> entry : entries)
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        printFilteredWordFrequency(sc.nextLine());
        sc.close();
    }
}
