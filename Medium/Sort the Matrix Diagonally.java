/*
LeetCode 1329: Sort the Matrix Diagonally
Difficulty: Medium
Topics: Array, Matrix, Sorting

Approach:
1. Start from every cell in the top row and left column.
2. Collect each diagonal's elements and sort them.
3. Put the sorted elements back into the matrix.

Time Complexity: O(m * n * log(min(m, n)))
Space Complexity: O(min(m, n))
*/

import java.util.*;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Start diagonals from the top row
        for (int col = 0; col < n; col++) {
            sortDiagonal(mat, 0, col);
        }

        // Start diagonals from the left column
        for (int row = 1; row < m; row++) {
            sortDiagonal(mat, row, 0);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {
        int m = mat.length;
        int n = mat[0].length;

        List<Integer> values = new ArrayList<>();

        int r = row;
        int c = col;

        // Collect diagonal elements
        while (r < m && c < n) {
            values.add(mat[r][c]);
            r++;
            c++;
        }

        // Sort in ascending order
        Collections.sort(values);

        r = row;
        c = col;
        int index = 0;

        // Put sorted elements back
        while (r < m && c < n) {
            mat[r][c] = values.get(index++);
            r++;
            c++;
        }
    }
}
