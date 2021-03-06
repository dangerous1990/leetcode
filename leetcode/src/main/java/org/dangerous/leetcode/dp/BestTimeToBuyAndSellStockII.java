package org.dangerous.leetcode.dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStockII {
    /**
     * 暴力解法 超时 time limit exceeded
     * ith |begin       |end
     * 1   |1           |1/3 length
     * 2   |lastSellPos |2/3 length
     * 3   |lastSellPos |length
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int l = prices.length;
        int n = l / 2;
        int profit = 0;
        for (int i = n; i > 0; i--) { // transactions
            int subProfit = 0;
            int lastSellPos = 0;
            for (int j = 1; j <= i; j++) { // ith transactions
                int currentProfit = 0; // current transactions profit
                int begin = lastSellPos + 1; // index of search  begin
                int end = j * l / i; // index of search end
                if (begin >= l) {
                    break;
                }
                int buy = prices[begin];
                for (int k = begin; k < l && k <= end; k++) {
                    if (prices[k - 1] == prices[k]) {
                        continue;
                    }
                    // find min price before k
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

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    /**
     * Peak Valley
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < n - 1) {
            // 找谷底
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            // 找山峰
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{2, 1, 2, 0, 1}));
    }
}
