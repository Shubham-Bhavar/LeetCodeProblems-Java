/*
 * LeetCode 861: Score After Flipping Matrix
 *
 * Problem:
 * Flip any row or column to maximize the sum of binary
 * numbers represented by the matrix rows.
 *
 * Example 1:
 * Input:  grid = [[0,0,1,1],
 *                 [1,0,1,0],
 *                 [1,1,0,0]]
 * Output: 39
 *
 * Example 2:
 * Input:  grid = [[0]]
 * Output: 1
 *
 * Constraints:
 * 1 <= m, n <= 20
 * grid[i][j] is either 0 or 1.
 *
 * Approach:
 * 1. Ensure the first element of every row is 1.
 * 2. For each column, maximize the number of 1s.
 * 3. Calculate the score using binary place values.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */

class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Make the first bit of every row 1
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }

        int score = 0;

        // Maximize the number of 1s in every column
        for (int j = 0; j < n; j++) {
            int ones = 0;

            for (int i = 0; i < m; i++) {
                ones += grid[i][j];
            }

            int maxOnes = Math.max(ones, m - ones);

            // Each column represents a binary place value
            score += maxOnes * (1 << (n - 1 - j));
        }

        return score;
    }
}
