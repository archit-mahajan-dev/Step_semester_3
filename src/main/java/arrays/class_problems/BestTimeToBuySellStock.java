package arrays.class_problems;

/** Week 4 practice L2: Best Time to Buy and Sell Stock — one pass. */
public class BestTimeToBuySellStock {
    static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int lowestPrice = prices[0];
        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitToday = prices[i] - lowestPrice;
            if (profitToday > bestProfit) bestProfit = profitToday;
            if (prices[i] < lowestPrice) lowestPrice = prices[i];
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
