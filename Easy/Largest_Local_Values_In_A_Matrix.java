/*
Question:
Given an n x n matrix grid, create a matrix maxLocal
of size (n - 2) x (n - 2).

Each maxLocal[i][j] contains the largest value
in the 3 x 3 matrix starting from grid[i][j].

Example:
Input:
grid = [
    [9,9,8,1],
    [5,6,2,6],
    [8,2,6,4],
    [6,2,2,2]
]

Output:
[
    [9,9],
    [8,6]
]
*/

class Solution {
    public int[][] largestLocal(int[][] grid) {

        int n = grid.length;

        int[][] maxLocal = new int[n - 2][n - 2];

        // Select every possible 3 x 3 matrix
        for (int i = 0; i < n - 2; i++) {

            for (int j = 0; j < n - 2; j++) {

                int max = 0;

                // Check all 9 elements
                for (int row = i; row < i + 3; row++) {

                    for (int col = j; col < j + 3; col++) {

                        max = Math.max(max, grid[row][col]);
                    }
                }

                // Store the maximum value
                maxLocal[i][j] = max;
            }
        }

        return maxLocal;
    }
}
