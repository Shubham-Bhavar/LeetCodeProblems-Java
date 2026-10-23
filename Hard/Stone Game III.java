/**
 * LeetCode 1406: Stone Game III
 *
 * Approach:
 * 1. Use dynamic programming to calculate the optimal score difference.
 * 2. Start from the last stone and move backwards.
 * 3. On each turn, try taking 1, 2, or 3 stones.
 * 4. Choose the move that maximizes the current player's score difference.
 * 5. Determine the winner based on the final score difference.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        // Calculate the optimal score difference from right to left
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            dp[i] = Integer.MIN_VALUE;

            // Try taking 1, 2, or 3 stones
            for (int j = 1; j <= 3 && i + j <= n; j++) {
                sum += stoneValue[i + j - 1];

                // Maximize the score difference
                dp[i] = Math.max(dp[i], sum - dp[i + j]);
            }
        }

        // Determine the winner
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        }

        return "Tie";
    }
}
