/*
 * Problem: 3665. Twisted Mirror Path Count
 * Difficulty: Medium
 *
 * Approach: Dynamic Programming
 *
 * 1. Track paths entering each cell from the left and from above.
 * 2. If the cell is empty, the robot can move right or down.
 * 3. If the cell is a mirror:
 *    - Entering from the left redirects the robot down.
 *    - Entering from above redirects the robot right.
 * 4. Count all paths reaching the destination.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        // Paths entering from left and from above
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        // Start position
        right[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int fromRight = right[i][j];
                int fromDown = down[i][j];

                if (grid[i][j] == 1) {

                    // Mirror: entering from left redirects down
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (int) ((down[i + 1][j] + (long) fromRight) % MOD);
                    }

                    // Mirror: entering from above redirects right
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (int) ((right[i][j + 1] + (long) fromDown) % MOD);
                    }

                } else {

                    // Empty cell: combine incoming paths
                    int total = (int) (((long) fromRight + fromDown) % MOD);

                    // Move right
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (int) ((right[i][j + 1] + (long) total) % MOD);
                    }

                    // Move down
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (int) ((down[i + 1][j] + (long) total) % MOD);
                    }
                }
            }
        }

        // Destination is guaranteed to be an empty cell
        return (int) (((long) right[m - 1][n - 1]
                     + down[m - 1][n - 1]) % MOD);
    }
}
