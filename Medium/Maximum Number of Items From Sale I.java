
/*
 * LeetCode 3946: Maximum Number of Items From Sale I
 *
 * Approach: 0/1 Knapsack
 *
 * 1. Calculate the value of each item:
 *    1 purchased copy + free copies.
 *
 * 2. Use 0/1 Knapsack to select item types.
 *
 * 3. Find the cheapest item price.
 *
 * 4. Use the remaining budget to buy extra
 *    copies of the cheapest item.
 *
 * Time Complexity: O(n * n + n * budget)
 * Space Complexity: O(budget)
 */

class Solution {
    public int maxNumberOfItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        int[] dp = new int[budget + 1];

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        for (int i = 0; i < n; i++) {
            int cost = items[i][1];
            int value = 1;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    value++;
                }
            }

            for (int b = budget; b >= cost; b--) {
                dp[b] = Math.max(dp[b], dp[b - cost] + value);
            }
        }

        int ans = 0;

        for (int b = 0; b <= budget; b++) {
            int total = dp[b] + (budget - b) / minPrice;
            ans = Math.max(ans, total);
        }

        return ans;
    }
}
