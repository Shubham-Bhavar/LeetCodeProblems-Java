
/*
 * LeetCode 2428: Maximum Sum of an Hourglass
 *
 * Problem:
 * Find the maximum sum of an hourglass in a matrix.
 *
 * Approach:
 * Brute Force + Nested Loops
 *
 * Step-by-step Explanation:
 * 1. Get the number of rows and columns.
 * 2. Initialize maxSum to 0.
 * 3. Traverse every possible 3 x 3 area.
 * 4. Calculate the sum of the top three elements.
 * 5. Add the middle element.
 * 6. Add the bottom three elements.
 * 7. Update maxSum if the current sum is greater.
 * 8. Return maxSum.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int maxSum = 0;

        // Traverse every possible hourglass.
        for (int i = 0; i < m - 2; i++) {

            for (int j = 0; j < n - 2; j++) {

                int sum = 0;

                // Top row.
                sum += grid[i][j];
                sum += grid[i][j + 1];
                sum += grid[i][j + 2];

                // Middle element.
                sum += grid[i + 1][j + 1];

                // Bottom row.
                sum += grid[i + 2][j];
                sum += grid[i + 2][j + 1];
                sum += grid[i + 2][j + 2];

                // Update maximum sum.
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
