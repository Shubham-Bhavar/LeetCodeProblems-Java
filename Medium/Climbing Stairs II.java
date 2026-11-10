
/*
 * LeetCode 3693. Climbing Stairs II
 *
 * Problem:
 * Find the minimum total cost to reach step n.
 * You can jump 1, 2, or 3 steps at a time.
 *
 * Approach: Dynamic Programming
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            dp[i] = Integer.MAX_VALUE;

            for (int j = 1; j <= 3; j++) {

                int prev = i - j;

                if (prev >= 0) {

                    int jumpCost = costs[i - 1] + j * j;

                    dp[i] = Math.min(dp[i],
                            dp[prev] + jumpCost);
                }
            }
        }

        return dp[n];
    }
}
