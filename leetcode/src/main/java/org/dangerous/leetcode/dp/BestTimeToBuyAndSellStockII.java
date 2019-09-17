package org.dangerous.leetcode.dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStockII {
    /**
     * 暴力解法 超时 time limit exceeded
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int l = prices.length;
        int n = l / 2;
        int profit = 0;
        for (int i = 1; i <= n; i++) { // transactions
            int subProfit = 0;
            int lastSellPos = 0;
            for (int j = 1; j <= i; j++) { // ith transactions
                int currentProfit = 0; // current transactions profit
                int begin = lastSellPos + 1; // index of search  begin
                int end = j * l / i; // index of search end
                if (begin >= l) {
                    break;
                }
                int buy = prices[lastSellPos + 1];
                for (int k = begin; k < l && k <= end; k++) { // search begin end
                    // find min price before i
                    buy = Math.min(buy, prices[k - 1]);
                    // max = max(current-min price,max)
                    // find max profit and last sell pos
                    if (prices[k] - buy > currentProfit) {
                        currentProfit = prices[k] - buy;
                        lastSellPos = k;
                    }
                }
                subProfit += currentProfit;
            }
            profit = Math.max(profit, subProfit);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{2, 1, 2, 0, 1}));
    }
}
