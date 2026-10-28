/*
 * LeetCode 3882: Minimum XOR Path in a Grid
 *
 * Question:
 * Find the minimum XOR value among all paths from the
 * top-left to the bottom-right, moving only right or down.
 *
 * Approach:
 * 1. Use DP to store all possible XOR values reaching each cell.
 * 2. From each cell, try moving right or down.
 * 3. XOR the current path value with the next cell's value.
 * 4. Return the minimum XOR value at the destination.
 *
 * Time Complexity: O(m * n * 1024)
 * Space Complexity: O(m * n * 1024)
 */

import java.util.*;

class Solution {
    public int minXorPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] dp = new boolean[m][n][1024];

        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < 1024; x++) {
                    if (!dp[i][j][x]) continue;

                    if (i + 1 < m)
                        dp[i + 1][j][x ^ grid[i + 1][j]] = true;

                    if (j + 1 < n)
                        dp[i][j + 1][x ^ grid[i][j + 1]] = true;
                }
            }
        }

        for (int x = 0; x < 1024; x++)
            if (dp[m - 1][n - 1][x]) return x;

        return -1;
    }
}
