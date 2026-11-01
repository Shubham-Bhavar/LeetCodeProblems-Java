
/*
 * LeetCode 1312 - Minimum Insertion Steps to Make a String Palindrome
 *
 * Difficulty: Hard
 * Approach: Dynamic Programming
 *
 * Time Complexity: O(n * n)
 * Space Complexity: O(n * n)
 */

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Check substrings of increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i + 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        return dp[0][n - 1];
    }
}
