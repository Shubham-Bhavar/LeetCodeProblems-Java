
/*
 * LeetCode 1092: Shortest Common Supersequence
 *
 * Problem:
 * Find the shortest string that contains both given
 * strings as subsequences.
 *
 * Approach: Dynamic Programming + LCS
 *
 * 1. Calculate the Longest Common Subsequence (LCS).
 * 2. Build the answer using the DP table.
 * 3. If characters are equal, add the character once.
 * 4. Otherwise, add the character from the larger DP value.
 * 5. Add remaining characters.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Build LCS table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        int i = m, j = n;

        // Build shortest common supersequence
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            } 
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                result.append(str1.charAt(i - 1));
                i--;
            } 
            else {
                result.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters
        while (i > 0) {
            result.append(str1.charAt(--i));
        }

        while (j > 0) {
            result.append(str2.charAt(--j));
        }

        return result.reverse().toString();
    }
}
