/*
LeetCode 1605: Find Valid Matrix Given Row and Column Sums
Difficulty: Medium
Topics: Array, Greedy, Matrix

Problem:
Construct a non-negative integer matrix such that each row
sum equals rowSum[i] and each column sum equals colSum[j].

Approach:
1. Take the minimum of the remaining row and column sums.
2. Place that value in the current cell.
3. Subtract it from both sums and move to the next row or column
   when its remaining sum becomes zero.

Time Complexity: O(m * n)
Space Complexity: O(m * n) for the result matrix
*/

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int[][] matrix = new int[m][n];

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            // Place the maximum possible value in the current cell
            int value = Math.min(rowSum[i], colSum[j]);

            matrix[i][j] = value;

            // Update remaining row and column sums
            rowSum[i] -= value;
            colSum[j] -= value;

            // Move to the next row if its sum is fulfilled
            if (rowSum[i] == 0) {
                i++;
            }

            // Move to the next column if its sum is fulfilled
            if (colSum[j] == 0) {
                j++;
            }
        }

        return matrix;
    }
}
