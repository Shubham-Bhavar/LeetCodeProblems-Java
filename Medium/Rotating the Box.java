/*
 * LeetCode 1861: Rotating the Box
 *
 * Problem:
 * You are given an m x n matrix boxGrid representing a box.
 *
 * Each cell contains:
 * '#' -> stone
 * '*' -> obstacle
 * '.' -> empty space
 *
 * The box is rotated 90 degrees clockwise.
 * During rotation, stones fall due to gravity.
 *
 * Stones fall until they hit:
 * - an obstacle
 * - another stone
 * - the bottom/right wall of the original box
 *
 * Return the resulting n x m matrix.
 *
 * Example 1:
 * Input:
 * [["#",".","#"]]
 *
 * Output:
 * [["."],
 *  ["#"],
 *  ["#"]]
 *
 * Example 2:
 * Input:
 * [["#",".","*","."],
 *  ["#","#","*","."]]
 *
 * Output:
 * [["#","."],
 *  ["#","#"],
 *  ["*","*"],
 *  [".","."]]
 *
 * Constraints:
 * 1 <= m, n <= 500
 *
 * Approach:
 * 1. Process every row from right to left.
 * 2. Simulate gravity by moving stones '#' to the right.
 * 3. Obstacles '*' stop the stones.
 * 4. After gravity is completed, rotate the matrix 90 degrees clockwise.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Step 1: Apply gravity
        for (int row = 0; row < m; row++) {
            int empty = n - 1;

            for (int col = n - 1; col >= 0; col--) {

                if (boxGrid[row][col] == '*') {
                    empty = col - 1;
                }

                else if (boxGrid[row][col] == '#') {
                    // Move stone to the rightmost available position
                    boxGrid[row][col] = '.';
                    boxGrid[row][empty] = '#';

                    empty--;
                }
            }
        }

        // Step 2: Rotate 90 degrees clockwise
        char[][] result = new char[n][m];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[col][m - 1 - row] = boxGrid[row][col];
            }
        }

        return result;
    }
}
