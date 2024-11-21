public class BestTimeToBuyAndSellStockII122 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int start = prices[0];
        int len = prices.length;

        for (int i = 1; i < len; i++) {
            if (start < prices[i]) {
                profit += prices[i] - start;
            }
            start = prices[i];
        }

        return profit;
    }
}
