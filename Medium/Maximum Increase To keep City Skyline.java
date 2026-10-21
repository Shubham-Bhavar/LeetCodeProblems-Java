/*
 * Problem: 807. Max Increase to Keep City Skyline
 * Difficulty: Medium
 * Topics: Array, Greedy, Matrix
 *
 * Approach:
 * 1. Find the maximum height in each row and column.
 * 2. For each building, calculate the minimum of its row maximum
 *    and column maximum.
 * 3. Increase the building height up to this limit.
 * 4. Add all possible increases to the answer.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;

        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        // Find maximum height in each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int totalIncrease = 0;

        // Calculate the maximum possible increase
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxHeight = Math.min(rowMax[i], colMax[j]);
                totalIncrease += maxHeight - grid[i][j];
            }
        }

        return totalIncrease;
    }
}