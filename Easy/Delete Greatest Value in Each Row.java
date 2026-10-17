/*
LeetCode 2500: Delete Greatest Value in Each Row
Difficulty: Easy
Topics: Array, Sorting, Matrix

Problem:
Delete the greatest element from each row in every operation.
Add the maximum of the deleted elements to the answer.

Approach:
1. Sort each row in ascending order.
2. Traverse columns from right to left.
3. Find the maximum value in each column and add it to the answer.

Time Complexity: O(m * n log n)
Space Complexity: O(1) extra space, excluding sorting overhead.
*/

import java.util.Arrays;

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Sort every row
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int answer = 0;

        // Traverse columns from greatest to smallest
        for (int j = n - 1; j >= 0; j--) {
            int max = 0;

            for (int i = 0; i < m; i++) {
                max = Math.max(max, grid[i][j]);
            }

            answer += max;
        }

        return answer;
    }
}
