
/*
 * LeetCode 1043 - Partition Array for Maximum Sum
 *
 * Difficulty: Medium
 * Approach: Dynamic Programming (Bottom-Up)
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(n)
 */

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maxValue = 0;

            for (int j = 1; j <= k && j <= i; j++) {
                maxValue = Math.max(maxValue, arr[i - j]);

                dp[i] = Math.max(
                    dp[i],
                    dp[i - j] + maxValue * j
                );
            }
        }

        return dp[n];
    }
}
