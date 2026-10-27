/**
 * LeetCode 3963: Create Grid With Exactly One Path
 *
 * Approach:
 * Fill the grid with obstacles ('#').
 * Make the first row and last column free ('.').
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];

        // Fill the grid with obstacles
        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(grid[i], '#');
        }

        // Make the first row free
        java.util.Arrays.fill(grid[0], '.');

        // Make the last column free
        for (int i = 0; i < m; i++) {
            grid[i][n - 1] = '.';
        }

        // Convert each row into a String
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }
}
