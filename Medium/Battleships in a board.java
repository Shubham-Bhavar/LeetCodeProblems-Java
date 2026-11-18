
/*
 * LeetCode 419: Battleships in a Board
 *
 * Problem:
 * Count the number of battleships in a 2D board.
 * 'X' represents a battleship and '.' represents empty space.
 *
 * Approach:
 * Matrix Traversal.
 *
 * Step-by-step:
 * 1. Traverse every cell of the board.
 * 2. Check if the current cell contains 'X'.
 * 3. Check the cell above and the cell on the left.
 * 4. If neither contains 'X', it is a new battleship.
 * 5. Increase the count.
 * 6. Return the total count.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countBattleships(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'X') {

                    // Check the cell above
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }

                    // Check the cell on the left
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }

                    // New battleship found
                    count++;
                }
            }
        }

        return count;
    }
}
