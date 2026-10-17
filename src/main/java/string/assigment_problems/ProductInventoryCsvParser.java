package string.assigment_problems;
import java.util.Scanner;
public class ProductInventoryCsvParser {
    public static String parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) return "Invalid Record";
        return "Product: " + fields[0].trim() + " | SKU: " + fields[1].trim()
                + " | Qty: " + fields[2].trim();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(parseInventoryRecord(sc.nextLine()));
        sc.close();
    }
}
