/**
 * LeetCode 115: Distinct Subsequences
 *
 * Approach:
 * 1. Use dynamic programming to count distinct subsequences.
 * 2. dp[j] represents the number of ways to form t[0..j-1].
 * 3. Traverse backwards to avoid overwriting previous results.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(m)
 */

class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }

        return dp[m];
    }
}
