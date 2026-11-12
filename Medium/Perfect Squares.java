
/*
 * LeetCode 279: Perfect Squares
 *
 * Problem:
 * Given an integer n, return the least number of perfect
 * square numbers that sum to n.
 *
 * Approach: Dynamic Programming
 *
 * Explanation:
 * 1. Create a DP array where dp[i] stores the minimum
 *    number of perfect squares required to make sum i.
 *
 * 2. Initialize dp[0] = 0 because zero requires
 *    zero perfect squares.
 *
 * 3. Traverse all numbers from 1 to n.
 *
 * 4. For each number, check every perfect square
 *    that is less than or equal to that number.
 *
 * 5. Update dp[i] by choosing the minimum number
 *    of squares required.
 *
 * 6. Return dp[n] as the final answer.
 *
 * Note:
 * The same perfect square can be used multiple times.
 *
 * Time Complexity: O(n * sqrt(n))
 * Space Complexity: O(n)
 */

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
