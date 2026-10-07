/*
 * LeetCode 518: Coin Change II
 *
 * Problem:
 * You are given an integer array coins representing different
 * coin denominations and an integer amount.
 *
 * Return the number of combinations that make up the amount.
 *
 * You have an unlimited number of each coin.
 *
 * Different orders of the same coins are NOT counted separately.
 *
 * Example 1:
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 *
 * Combinations:
 * 5 = 5
 * 5 = 2 + 2 + 1
 * 5 = 2 + 1 + 1 + 1
 * 5 = 1 + 1 + 1 + 1 + 1
 *
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 *
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 * Approach:
 * Use a 1D DP array.
 *
 * dp[i] = number of ways to make amount i.
 *
 * Initially:
 * dp[0] = 1
 *
 * Because there is exactly one way to make amount 0:
 * choose no coins.
 *
 * For every coin:
 *   for every amount from coin to amount:
 *       dp[j] += dp[j - coin]
 *
 * Processing coins in the outer loop ensures that
 * different orders are not counted as different combinations.
 *
 * Time Complexity: O(coins.length * amount)
 * Space Complexity: O(amount)
 */

class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {

            for (int current = coin;
                 current <= amount;
                 current++) {

                dp[current] += dp[current - coin];
            }
        }

        return dp[amount];
    }
}
