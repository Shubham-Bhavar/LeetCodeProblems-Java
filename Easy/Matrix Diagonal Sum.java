/*
 * LeetCode 1572: Matrix Diagonal Sum
 *
 * Problem:
 * Return the sum of the primary and secondary diagonals
 * of a square matrix. Count the center element only once.
 *
 * Example 1:
 * Input:  mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 25
 *
 * Example 2:
 * Input:  mat = [[1,1,1,1],[1,1,1,1],
 *                [1,1,1,1],[1,1,1,1]]
 * Output: 8
 *
 * Example 3:
 * Input:  mat = [[5]]
 * Output: 5
 *
 * Constraints:
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 *
 * Approach:
 * 1. Add primary diagonal: mat[i][i].
 * 2. Add secondary diagonal: mat[i][n-1-i].
 * 3. Avoid counting the center element twice.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];

            // Avoid counting the center element twice
            if (i == n - 1 - i) {
                sum -= mat[i][i];
            }
        }

        return sum;
    }
}
