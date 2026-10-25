/**
 * LeetCode 1254: Number of Closed Islands
 *
 * Approach:
 * Traverse every cell in the grid.
 * When an unvisited land cell (0) is found, use DFS to explore its island.
 * If the island touches any boundary, it is not closed.
 * Count islands that do not touch the boundary.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) - DFS recursion stack
 */
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        // Island touching the boundary is not closed
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return false;
        }

        // Water or already visited land
        if (grid[r][c] == 1) {
            return true;
        }

        // Mark land as visited
        grid[r][c] = 1;

        boolean up = dfs(grid, r - 1, c);
        boolean down = dfs(grid, r + 1, c);
        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);

        return up && down && left && right;
    }
}
