/*
    LeetCode 48 - Rotate Image

    Problem:
    --------
    You are given an n x n 2D matrix representing an image.
    Rotate the image by 90 degrees clockwise.

    The rotation must be done in-place.
    Do not allocate another 2D matrix.

    Example 1:
    Input:
    matrix = [[1,2,3],
              [4,5,6],
              [7,8,9]]

    Output:
    [[7,4,1],
     [8,5,2],
     [9,6,3]]

    Example 2:
    Input:
    matrix = [[5,1,9,11],
              [2,4,8,10],
              [13,3,6,7],
              [15,14,12,16]]

    Output:
    [[15,13,2,5],
     [14,3,4,1],
     [12,6,8,9],
     [16,7,10,11]]

    Constraints:
    ------------
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000

    Approach:
    ---------
    1. Transpose the matrix.
    2. Reverse every row.

    90° Clockwise Rotation:
    Transpose + Reverse Rows

    Time Complexity: O(n^2)
    Space Complexity: O(1)
*/

class Solution {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse every row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
