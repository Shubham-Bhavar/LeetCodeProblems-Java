/*
 * LeetCode 629: K Inverse Pairs Array
 *
 * Problem:
 * For an integer array nums, an inverse pair is a pair [i, j]
 * where:
 *
 *     0 <= i < j < nums.length
 *     nums[i] > nums[j]
 *
 * Given integers n and k, return the number of different arrays
 * consisting of numbers from 1 to n that contain exactly k
 * inverse pairs.
 *
 * Return the answer modulo 1,000,000,007.
 *
 * Example 1:
 * Input:  n = 3, k = 0
 * Output: 1
 *
 * Explanation:
 * Only [1,2,3] has 0 inverse pairs.
 *
 * Example 2:
 * Input:  n = 3, k = 1
 * Output: 2
 *
 * Explanation:
 * [1,3,2] -> 1 inverse pair
 * [2,1,3] -> 1 inverse pair
 *
 * Constraints:
 * 1 <= n <= 1000
 * 0 <= k <= 1000
 *
 * ---------------------------------------------------------
 * Approach:
 *
 * Let:
 *
 * dp[j] = number of arrays using numbers 1 to current n
 *         having exactly j inverse pairs.
 *
 * When we add the new largest number `n`, it can create:
 *
 * 0, 1, 2, ..., n-1
 *
 * new inverse pairs depending on where we insert it.
 *
 * Therefore:
 *
 * dp[n][j] =
 *     dp[n-1][j]
 *   + dp[n-1][j-1]
 *   + ...
 *   + dp[n-1][j-(n-1)]
 *
 * Directly calculating this would take O(n * k * n).
 *
 * We optimize this using a sliding window / prefix sum.
 *
 * ---------------------------------------------------------
 * Example:
 *
 * For n = 3:
 *
 * Number 3 can create:
 * 0, 1, or 2 new inverse pairs.
 *
 * dp[3][1] =
 *     dp[2][1]
 *   + dp[2][0]
 *
 * ---------------------------------------------------------
 * Base case:
 *
 * dp[0] = 1
 *
 * There is one way to create an empty array.
 *
 * ---------------------------------------------------------
 * Time Complexity:
 * O(n * k)
 *
 * Space Complexity:
 * O(k)
 */

class Solution {

    public int kInversePairs(int n, int k) {

        final int MOD = 1_000_000_007;

        int[] dp = new int[k + 1];

        // With 0 numbers, there is one empty array
        dp[0] = 1;

        for (int number = 1; number <= n; number++) {

            int[] next = new int[k + 1];

            long window = 0;

            for (int pairs = 0; pairs <= k; pairs++) {

                window += dp[pairs];

                // Remove values outside the window
                if (pairs >= number) {
                    window -= dp[pairs - number];
                }

                window %= MOD;

                if (window < 0) {
                    window += MOD;
                }

                next[pairs] = (int) window;
            }

            dp = next;
        }

        return dp[k];
    }
}
