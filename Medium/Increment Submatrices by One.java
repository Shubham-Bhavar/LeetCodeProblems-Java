
/*
 * Problem: 2536. Increment Submatrices by One
 * Difficulty: Medium
 * Approach: 2D Difference Array + Prefix Sum
 * Time Complexity: O(n^2 + q)
 * Space Complexity: O(n^2)
 */

class Solution {

    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] diff = new int[n + 1][n + 1];

        // Apply each query using difference array
        for (int[] query : queries) {

            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];

            diff[r1][c1]++;
            diff[r2 + 1][c1]--;
            diff[r1][c2 + 1]--;
            diff[r2 + 1][c2 + 1]++;
        }

        // Calculate prefix sums
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                mat[i][j] = diff[i][j];

                if (i > 0) {
                    mat[i][j] += mat[i - 1][j];
                }

                if (j > 0) {
                    mat[i][j] += mat[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    mat[i][j] -= mat[i - 1][j - 1];
                }
            }
        }

        return mat;
    }
}
