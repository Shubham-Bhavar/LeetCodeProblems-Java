/*
 * LeetCode 52: N-Queens II
 *
 * Problem:
 * Place n queens on an n x n chessboard so that no two
 * queens attack each other.
 *
 * Queens cannot share the same row, column, or diagonal.
 * Return the number of distinct valid solutions.
 *
 * Example 1:
 * Input:  n = 4
 * Output: 2
 *
 * Example 2:
 * Input:  n = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= n <= 9
 *
 * Approach:
 * 1. Place one queen in each row.
 * 2. Check whether its column and diagonals are safe.
 * 3. Recursively place queens in the next row.
 * 4. Count a solution when all rows are filled.
 *
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 */

class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];

        backtrack(0, n, columns, diagonal1, diagonal2);

        return count;
    }

    private void backtrack(
            int row,
            int n,
            boolean[] columns,
            boolean[] diagonal1,
            boolean[] diagonal2) {

        // All queens have been placed successfully
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;

            // Skip positions under attack
            if (columns[col] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            // Place queen
            columns[col] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            // Place queen in the next row
            backtrack(row + 1, n, columns, diagonal1, diagonal2);

            // Backtrack: remove queen
            columns[col] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}
