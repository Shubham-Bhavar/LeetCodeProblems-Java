/*
 * LeetCode 1340: Jump Game V
 *
 * Question:
 * Find the maximum number of indices visitable by jumping
 * at most d steps to either side, only to smaller values,
 * without crossing an equal or greater value.
 *
 * Approach:
 * 1. Use DFS with memoization (Dynamic Programming).
 * 2. dp[i] stores the maximum indices visitable starting at i.
 * 3. Check left and right jumps up to distance d.
 * 4. Stop when a value is greater than or equal to arr[i].
 * 5. Return the maximum dp[i] for all starting indices.
 *
 * Time Complexity: O(n * d)
 * Space Complexity: O(n)
 */

class Solution {
    int[] dp;

    public int maxJumps(int[] arr, int d) {
        int n = arr.length, ans = 0;
        dp = new int[n];

        for (int i = 0; i < n; i++)
            ans = Math.max(ans, dfs(arr, i, d));

        return ans;
    }

    int dfs(int[] arr, int i, int d) {
        if (dp[i] != 0) return dp[i];

        dp[i] = 1;

        for (int dir : new int[]{-1, 1}) {
            for (int x = 1; x <= d; x++) {
                int j = i + dir * x;

                if (j < 0 || j >= arr.length || arr[j] >= arr[i])
                    break;

                dp[i] = Math.max(dp[i], 1 + dfs(arr, j, d));
            }
        }

        return dp[i];
    }
}
