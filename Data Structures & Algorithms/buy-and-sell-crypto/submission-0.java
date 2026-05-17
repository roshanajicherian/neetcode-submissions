class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int prev = prices[0];
        for (int i = 0; i < n - 1; i++) {
            if (prices[i] > prev)
                continue;
            prev = prices[i];
            for (int j = i + 1; j < n; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }
}
