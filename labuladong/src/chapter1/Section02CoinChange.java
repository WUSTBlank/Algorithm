package chapter1;

import java.util.Arrays;

/**
 * @author Sharon
 * @date 2021-01-28
 * https://leetcode-cn.com/problems/coin-change/
 */
public class Section02CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        int coinsCount = coins.length;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Section02CoinChange test = new Section02CoinChange();
        System.out.println(test.coinChange(new int[] {1, 2, 5}, 11));
    }

}
