package lcof;

import java.util.Arrays;

public class Offer063 {
    static int N = (int) 1e5;
    public static int maxProfit(int[] prices) {
        int[] dp = new int[100010];
        int n = prices.length;
        dp[0] = 0;
        int cost=prices[0];
        for (int i = 1; i < prices.length; i++) {
            cost = Math.min(cost,prices[i]);
            dp[i] = Math.max(dp[i-1],prices[i]-cost);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] a = new int[]{1,2};
        maxProfit(a);
    }
}
