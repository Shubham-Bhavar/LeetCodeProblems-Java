/*
 * LeetCode 1637: Widest Vertical Area Between Two Points Containing No Points
 *
 * Problem:
 * You are given n points on a 2D plane.
 * points[i] = [xi, yi]
 *
 * A vertical area is a region between two vertical lines.
 * It extends infinitely along the y-axis.
 *
 * We need to return the maximum width of a vertical area
 * that contains no points inside it.
 *
 * Important:
 * Points exactly on the boundary are NOT considered inside.
 *
 * Example 1:
 * Input:
 * points = [[8,7],[9,9],[7,4],[9,7]]
 *
 * Output:
 * 1
 *
 * Example 2:
 * Input:
 * points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 *
 * Output:
 * 3
 *
 * Constraints:
 * 2 <= n <= 10^5
 * 0 <= xi, yi <= 10^9
 *
 * Approach:
 * 1. Only the x-coordinate matters because the area is vertical.
 * 2. Extract all x-coordinates.
 * 3. Sort the x-coordinates.
 * 4. Find the maximum difference between adjacent x-values.
 *
 * Why adjacent points?
 * After sorting, any empty vertical area must lie between
 * two consecutive x-coordinates.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;

        int[] x = new int[n];

        // Store all x-coordinates
        for (int i = 0; i < n; i++) {
            x[i] = points[i][0];
        }

        // Sort x-coordinates
        Arrays.sort(x);

        int maxWidth = 0;

        // Find maximum gap between adjacent x-values
        for (int i = 1; i < n; i++) {
            maxWidth = Math.max(maxWidth, x[i] - x[i - 1]);
        }

        return maxWidth;
    }
}
