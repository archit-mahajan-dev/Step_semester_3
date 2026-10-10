package string.assigment_problems;

/**
 * Week 1 Assignment - Problem 4: The Warehouse Inventory Balancer.
 * Item numbers are reported 1-based, as in the sample output.
 * If the maximum appears more than once, the first one found (Section A first) is reported.
 */
public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: both sections must have the same number of items.");
            return;
        }

        int totalA = 0, totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxItem = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxItem = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxItem = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + maxQuantity + " (" + maxSection + ", Item " + maxItem + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
