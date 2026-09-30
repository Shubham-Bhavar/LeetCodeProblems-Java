/*
 * ============================================================
 * LeetCode 309: Best Time to Buy and Sell Stock with Cooldown
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * You are given an array prices where prices[i] is the price
 * of a stock on the i-th day.
 *
 * You may complete as many transactions as you like.
 *
 * However, after selling a stock, you must wait one day before
 * buying again.
 *
 * You cannot hold multiple stocks at the same time.
 *
 * Return the maximum profit you can achieve.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * prices = [1,2,3,0,2]
 *
 * Output:
 * 3
 *
 * Explanation:
 *
 * Buy at 1
 * Sell at 3
 * Cooldown
 * Buy at 0
 * Sell at 2
 *
 * Profit:
 * (3 - 1) + (2 - 0)
 * = 2 + 2
 * = 4
 *
 * However, because of the cooldown restriction, the optimal
 * sequence gives a maximum profit of 3:
 *
 * Buy at 1
 * Sell at 2
 * Cooldown
 * Buy at 0
 * Sell at 2
 *
 * Profit = 1 + 2 = 3
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * prices = [1]
 *
 * Output:
 * 0
 *
 * ------------------------------------------------------------
 * Constraints:
 * ------------------------------------------------------------
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * We use Dynamic Programming with 3 states:
 *
 * 1. buy
 *    Maximum profit when we are currently holding a stock.
 *
 * 2. sell
 *    Maximum profit when we have just sold a stock.
 *
 * 3. cooldown
 *    Maximum profit when we are not holding a stock and
 *    are not selling today.
 *
 * ------------------------------------------------------------
 * State Transitions:
 * ------------------------------------------------------------
 *
 * BUY:
 *
 * We can either:
 * - Continue holding the stock
 * - Buy today after being in cooldown
 *
 * buy = max(buy, cooldown - price)
 *
 * SELL:
 *
 * We can sell the stock we were holding:
 *
 * sell = buy + price
 *
 * COOLDOWN:
 *
 * After selling, we enter cooldown.
 *
 * cooldown = max(cooldown, oldSell)
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * ============================================================
 */

class Solution {

    public int maxProfit(int[] prices) {

        int buy = -prices[0];
        int sell = 0;
        int cooldown = 0;

        for (int i = 1; i < prices.length; i++) {

            int oldBuy = buy;
            int oldSell = sell;
            int oldCooldown = cooldown;

            // Buy today or continue holding the stock
            buy = Math.max(oldBuy,
                    oldCooldown - prices[i]);

            // Sell today
            sell = oldBuy + prices[i];

            // Stay in cooldown or enter cooldown after selling
            cooldown = Math.max(oldCooldown, oldSell);
        }

        return Math.max(sell, cooldown);
    }
}
