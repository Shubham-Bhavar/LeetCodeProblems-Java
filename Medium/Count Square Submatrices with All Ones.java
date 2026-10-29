
/*
 * Problem: 1277. Count Square Submatrices with All Ones
 * Difficulty: Medium
 * Language: Java
 *
 * Approach:
 * 1. Traverse the matrix row by row.
 * 2. For each cell containing 1, calculate the largest
 *    square ending at that cell.
 * 3. Add the square size to the total count.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1) extra space
 */

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    matrix[i][j] = 1 + Math.min(
                        matrix[i - 1][j - 1],
                        Math.min(
                            matrix[i - 1][j],
                            matrix[i][j - 1]
                        )
                    );
                }

                count += matrix[i][j];
            }
        }

        return count;
    }
}
