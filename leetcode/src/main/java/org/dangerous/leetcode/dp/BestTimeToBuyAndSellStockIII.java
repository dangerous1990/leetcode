package org.dangerous.leetcode.dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStockIII {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1).
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for (int i = 0; i < prices.length; i++) {
            oneBuy = Math.max(oneBuy, -prices[i]);//we set prices to negative, so the calculation of profit will be convenient
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] + oneBuy);
            twoBuy = Math.max(twoBuy, oneBuyOneSell - prices[i]);//we can buy the second only after first is sold
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + prices[i]);
        }

        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }


    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9}));
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{5, 5, 4, 9, 3, 8, 5, 5, 1, 6, 8, 3, 4}));
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{2, 1, 2, 0, 1}));
    }
}
