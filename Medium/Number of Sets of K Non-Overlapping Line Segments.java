    /*
        LeetCode 1621 - Number of Sets of K Non-Overlapping Line Segments

        Problem:
        ----------
        Given n points on a line, count the number of ways to
        draw exactly k non-overlapping line segments.

        A segment can share endpoints with another segment.

        Example:
        Input:  n = 4, k = 2
        Output: 5


        Key Observation:
        -----------------
        The answer can be converted into a combination:

            Answer = C(n + k - 1, 2 * k)

        So we only need to calculate a combination.

        Let:

            N = n + k - 1
            R = 2 * k

        Then:

            Answer = C(N, R)


        Combination Formula:
        --------------------
            C(N, R) = C(N - 1, R) + C(N - 1, R - 1)

        This is the same formula used to build Pascal's Triangle.


        Dynamic Programming:
        --------------------
        Instead of using a 2D DP table, we use a 1D array.

            dp[j] = C(currentRow, j)

        Initially:

            C(any number, 0) = 1

        Therefore:

            dp[0] = 1


        Why do we traverse j backwards?
        --------------------------------
        We calculate:

            dp[j] = dp[j] + dp[j - 1]

        If we move from right to left, dp[j - 1] still
        contains the value from the previous row.

        Therefore:

            for (j = R; j >= 1; j--)


        Example:
        --------
        n = 4
        k = 2

        N = 4 + 2 - 1 = 5
        R = 2 * 2 = 4

        Answer = C(5, 4)
               = 5


        Time Complexity:
        ----------------
        O(N * R)

        Since:
            N = n + k - 1
            R = 2 * k

        Overall:
            O((n + k) * k)


        Space Complexity:
        -----------------
        O(R) = O(k)


        Pattern to Remember:
        --------------------
        Problem
           ↓
        Convert to Combination
           ↓
        C(n + k - 1, 2k)
           ↓
        Pascal's Triangle
           ↓
        1D DP
    */
class Solution {

    public int numberOfSets(int n, int k) {

        // Required modulo value
        final int MOD = 1_000_000_007;

        // Convert the problem into C(N, R)
        int N = n + k - 1;
        int R = 2 * k;

        // dp[j] will store C(current N, j)
        long[] dp = new long[R + 1];

        // C(any number, 0) = 1
        dp[0] = 1;

        // Build Pascal's Triangle row by row
        for (int i = 1; i <= N; i++) {

            // Traverse backwards to preserve previous row values
            for (int j = Math.min(i, R); j >= 1; j--) {

                // Pascal's Triangle formula:
                // C(i,j) = C(i-1,j) + C(i-1,j-1)
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }

        // dp[R] = C(N, R)
        return (int) dp[R];
    }
}
