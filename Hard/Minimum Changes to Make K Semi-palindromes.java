
/*
 * LeetCode 2911: Minimum Changes to Make K Semi-palindromes
 *
 * Problem:
 * Divide the given string into exactly k substrings.
 * Each substring must be a semi-palindrome.
 * Return the minimum number of character changes required.
 *
 * Approach:
 * 1. Precompute the minimum changes needed to make
 *    every substring a semi-palindrome.
 *
 * 2. For each substring, check all valid divisors.
 *    Compare characters in each group from both ends.
 *
 * 3. Use Dynamic Programming to divide the string
 *    into exactly k valid substrings with minimum cost.
 *
 * Step-by-step:
 * - cost[i][j] stores the minimum changes for s[i...j-1].
 * - dp[p][i] stores the minimum changes to divide
 *   the first i characters into p substrings.
 *
 * Time Complexity:
 * O(n^3 * sqrt(n) + k * n^2)
 *
 * Space Complexity:
 * O(n^2 + k * n)
 */

import java.util.Arrays;

class Solution {
    public int minChanges(String s, int k) {

        int n = s.length();

        // Step 1: Precompute substring costs
        int[][] cost = new int[n][n + 1];

        for (int len = 2; len <= n; len++) {

            for (int start = 0; start + len <= n; start++) {

                int minCost = Integer.MAX_VALUE;

                // Check all valid divisors
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Check each group
                    for (int offset = 0; offset < d; offset++) {

                        int left = start + offset;
                        int right = start + offset
                                + ((len - 1 - offset) / d) * d;

                        // Compare characters from both ends
                        while (left < right) {

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    minCost = Math.min(minCost, changes);
                }

                cost[start][start + len] = minCost;
            }
        }

        // Step 2: Dynamic Programming
        int INF = 100000000;

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Base case
        dp[0][0] = 0;

        // Step 3: Calculate minimum partition cost
        for (int parts = 1; parts <= k; parts++) {

            for (int end = 2 * parts; end <= n; end++) {

                for (int start = 2 * (parts - 1);
                     start <= end - 2; start++) {

                    dp[parts][end] = Math.min(
                        dp[parts][end],
                        dp[parts - 1][start]
                                + cost[start][end]
                    );
                }
            }
        }

        // Final answer
        return dp[k][n];
    }
}
