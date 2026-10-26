/**
 * LeetCode 3699: Number of ZigZag Arrays I
 *
 * Approach:
 * Use Dynamic Programming with Prefix Sums.
 * - up[i]: Number of arrays ending at value i with an increasing last step.
 * - down[i]: Number of arrays ending at value i with a decreasing last step.
 * The direction must alternate for every adjacent pair.
 * Prefix and suffix sums optimize transitions to O(r - l + 1).
 *
 * Time Complexity: O(n * (r - l + 1))
 * Space Complexity: O(r - l + 1)
 */

class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        for (int len = 1; len < n; len++) {
            long[] prefix = new long[m + 1];
            long[] suffix = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefix[i + 1] = (prefix[i] + down[i]) % MOD;
            }

            for (int i = m - 1; i >= 0; i--) {
                suffix[i] = (suffix[i + 1] + up[i]) % MOD;
            }

            for (int i = 0; i < m; i++) {
                up[i] = prefix[i];
                down[i] = suffix[i + 1];
            }
        }

        long answer = 0;

        for (int i = 0; i < m; i++) {
            answer = (answer + up[i] + down[i]) % MOD;
        }

        return (int) answer;
    }
}
