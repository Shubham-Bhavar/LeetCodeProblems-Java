/*
 * LeetCode 200: Number of Islands
 *
 * Problem:
 * Given an m x n binary grid:
 *
 * '1' -> Land
 * '0' -> Water
 *
 * An island is formed by connecting adjacent land cells
 * horizontally or vertically.
 *
 * Return the number of islands.
 *
 * Example 1:
 * Input:
 * [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 *
 * Output: 1
 *
 * Example 2:
 * Input:
 * [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 *
 * Output: 3
 *
 * Constraints:
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 * Approach:
 * 1. Traverse every cell.
 * 2. When we find '1', we found a new island.
 * 3. Increase the island count.
 * 4. Use DFS to visit all connected '1's.
 * 5. Mark visited land as '0' so it is not counted again.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) in the worst case due to recursion.
 */

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1') {
                    count++;

                    // Visit the complete island
                    dfs(grid, row, col);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {

        // Check boundaries and water
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == '0') {
            return;
        }

        // Mark as visited
        grid[row][col] = '0';

        // Up
        dfs(grid, row - 1, col);

        // Down
        dfs(grid, row + 1, col);

        // Left
        dfs(grid, row, col - 1);

        // Right
        dfs(grid, row, col + 1);
    }
}
