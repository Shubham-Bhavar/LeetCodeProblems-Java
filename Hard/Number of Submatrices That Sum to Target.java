/*
 * LeetCode 1074: Number of Submatrices That Sum to Target
 *
 * Question:
 * Count non-empty submatrices whose sum equals target.
 *
 * Approach:
 * 1. Fix the top and bottom rows.
 * 2. Calculate column sums between these rows.
 * 3. Use prefix sum and HashMap to count subarrays equal to target.
 *
 * Time Complexity: O(rows^2 * cols)
 * Space Complexity: O(cols)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int ans = 0;

        for (int top = 0; top < rows; top++) {
            int[] sum = new int[cols];

            for (int bottom = top; bottom < rows; bottom++) {
                for (int c = 0; c < cols; c++)
                    sum[c] += matrix[bottom][c];

                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int prefix = 0;

                for (int x : sum) {
                    prefix += x;
                    ans += map.getOrDefault(prefix - target, 0);
                    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
                }
            }
        }

        return ans;
    }
}
