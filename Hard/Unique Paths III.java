/*
 * LeetCode 980: Unique Paths III
 *
 * Problem:
 * You are given an m x n grid where:
 *
 * 1 = starting square
 * 2 = ending square
 * 0 = empty square
 * -1 = obstacle
 *
 * Return the number of 4-directional walks from the starting square
 * to the ending square that visit every non-obstacle square exactly once.
 *
 * Example 1:
 * Input:
 * grid = [[1,0,0,0],
 *         [0,0,0,0],
 *         [0,0,2,-1]]
 *
 * Output: 2
 *
 * Example 2:
 * Input:
 * grid = [[1,0,0,0],
 *         [0,0,0,0],
 *         [0,0,0,2]]
 *
 * Output: 4
 *
 * Example 3:
 * Input:
 * grid = [[0,1],
 *         [2,0]]
 *
 * Output: 0
 *
 * Approach:
 * 1. Count the total number of non-obstacle cells.
 * 2. Find the starting cell.
 * 3. Use DFS + backtracking.
 * 4. Mark the current cell as visited.
 * 5. Move in all four directions.
 * 6. When we reach the ending cell, count the path only if
 *    every non-obstacle cell has been visited.
 * 7. Unmark the cell while backtracking so it can be used
 *    by another possible path.
 *
 * Time Complexity:
 * O(4^(m*n)) in the worst case.
 *
 * Space Complexity:
 * O(m*n) for the recursion stack and visited state.
 */

class Solution {

    private int rows;
    private int cols;
    private int totalCells;
    private int answer;

    public int uniquePathsIII(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        int startRow = 0;
        int startCol = 0;

        // Count all non-obstacle cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (grid[row][col] != -1) {
                    totalCells++;
                }

                if (grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        // Start DFS
        dfs(grid, startRow, startCol, 1);

        return answer;
    }

    private void dfs(int[][] grid, int row, int col, int visitedCells) {

        // Out of bounds
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols) {
            return;
        }

        // Obstacle or already visited cell
        if (grid[row][col] == -1) {
            return;
        }

        // Reached ending square
        if (grid[row][col] == 2) {

            // Valid only if every non-obstacle cell was visited
            if (visitedCells == totalCells) {
                answer++;
            }

            return;
        }

        // Mark current cell as visited
        int originalValue = grid[row][col];
        grid[row][col] = -1;

        // Move up
        dfs(grid, row - 1, col, visitedCells + 1);

        // Move down
        dfs(grid, row + 1, col, visitedCells + 1);

        // Move left
        dfs(grid, row, col - 1, visitedCells + 1);

        // Move right
        dfs(grid, row, col + 1, visitedCells + 1);

        // Backtrack
        grid[row][col] = originalValue;
    }
}
