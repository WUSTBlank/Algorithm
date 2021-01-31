package chapter1.Section02;

import java.util.Arrays;

/**
 * @author Sharon
 * @date 2021-01-28 https://leetcode-cn.com/problems/coin-change-2/
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        if (amount <= 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 test = new CoinChange2();
        System.out.println(test.change(5, new int[] {1, 2, 5}));
    }

}
