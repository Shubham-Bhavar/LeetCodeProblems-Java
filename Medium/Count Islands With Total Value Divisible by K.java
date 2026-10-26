/**
 * LeetCode 3619: Count Islands With Total Value Divisible by K
 *
 * Approach:
 * Use DFS to explore each island of positive integers.
 * Calculate the total value of each island by summing its cells.
 * Mark visited cells as 0 to avoid visiting them again.
 * If the island's total value is divisible by k, increment the count.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) - DFS recursion stack in the worst case
 */

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = dfs(grid, i, j);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return 0;
        }

        long value = grid[i][j];

        // Mark the cell as visited
        grid[i][j] = 0;

        value += dfs(grid, i - 1, j);
        value += dfs(grid, i + 1, j);
        value += dfs(grid, i, j - 1);
        value += dfs(grid, i, j + 1);

        return value;
    }
}
