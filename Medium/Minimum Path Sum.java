
/*
 * LeetCode 64: Minimum Path Sum
 *
 * Problem:
 * Given an m x n grid of non-negative numbers,
 * find the minimum path sum from the top-left
 * to the bottom-right cell.
 * We can only move right or down.
 *
 * Approach:
 * Dynamic Programming (DP)
 *
 * Step-by-step Explanation:
 * 1. Create a DP array of the same size as the grid.
 * 2. Set dp[0][0] equal to grid[0][0].
 * 3. Fill the first row by adding the previous cell.
 * 4. Fill the first column by adding the cell above.
 * 5. For every remaining cell, take the minimum
 *    of the top and left cells and add the current value.
 * 6. Return dp[m-1][n-1].
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Starting cell
        dp[0][0] = grid[0][0];

        // Fill the first row
        for (int j = 1; j < n; j++) {

            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {

            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the remaining cells
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                dp[i][j] = grid[i][j] +
                           Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
