package neetcode.slidingwindow;

/**
 * 문제 : Best Time to Buy and Sell Stock
 * https://neetcode.io/problems/buy-and-sell-crypto?list=neetcode150
 */
public class BestTimetoBuyAndSellStock {

    public static void main(String[] args) {

        int result = maxProfit(new int[]{10, 1, 5, 6, 7, 1});
//        int result = maxProfit(new int[]{10, 11, 5, 6, 7, 1});
//        int result = maxProfit(new int[]{10, 8, 7, 5, 2});
        System.out.println("result = " + result);
    }

    public static int maxProfit(int[] prices) {

        int buyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                int currentProfit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }
}
