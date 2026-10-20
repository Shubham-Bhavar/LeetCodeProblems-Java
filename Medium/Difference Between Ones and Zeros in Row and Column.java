
/*
 * Problem: Difference Between Ones and Zeros in Row and Column
 * Difficulty: Medium
 * Topics: Array, Matrix
 *
 * Approach:
 * 1. Count the number of ones in each row and column.
 * 2. Calculate zeros using total cells minus ones.
 * 3. Calculate diff[i][j] using the row and column counts.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) for the result matrix,
 *                   O(m + n) for the count arrays.
 */

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] onesRow = new int[m];
        int[] onesCol = new int[n];

        // Count ones in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }

        int[][] diff = new int[m][n];

        // Calculate the difference matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int zerosRow = n - onesRow[i];
                int zerosCol = m - onesCol[j];

                diff[i][j] = onesRow[i] + onesCol[j]
                           - zerosRow - zerosCol;
            }
        }

        return diff;
    }
}
