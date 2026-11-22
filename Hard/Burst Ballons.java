/*
Problem:
Given an array of balloon values, burst all balloons
to maximize the total coins collected.

Approach:
1. Add 1 at the beginning and end of the array.
2. Use Dynamic Programming (DP).
3. Try every balloon as the last balloon to burst.
4. Calculate the maximum coins for each interval.
5. Return the maximum coins.

Time Complexity: O(n^3)
Space Complexity: O(n^2)
*/

class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;

        // Create a new array with boundary values
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        // Copy original balloon values
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // Create DP table
        int[][] dp = new int[n + 2][n + 2];

        // Calculate maximum coins for each interval
        for (int len = 1; len <= n; len++) {

            for (int left = 1; left <= n - len + 1; left++) {

                int right = left + len - 1;

                // Try each balloon as the last balloon
                for (int k = left; k <= right; k++) {

                    int coins = arr[left - 1] * arr[k]
                              * arr[right + 1];

                    coins += dp[left][k - 1]
                           + dp[k + 1][right];

                    // Update maximum coins
                    dp[left][right] = Math.max(
                        dp[left][right], coins
                    );
                }
            }
        }

        return dp[1][n];
    }
}