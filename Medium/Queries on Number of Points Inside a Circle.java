/*
 * LeetCode 1828: Queries on Number of Points Inside a Circle
 *
 * Problem:
 * Given points[i] = [xi, yi] and queries[j] = [xj, yj, rj],
 * count how many points lie inside or on the boundary
 * of each query circle.
 *
 * Example 1:
 * Input:
 * points = [[1,3],[3,3],[5,3],[2,2]]
 * queries = [[2,3,1],[4,3,1],[1,1,2]]
 * Output: [3,2,2]
 *
 * Example 2:
 * Input:
 * points = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * Output: [2,3,2,4]
 *
 * Constraints:
 * 1 <= points.length <= 500
 * 1 <= queries.length <= 500
 * Coordinates and radii are between 0 and 500.
 *
 * Approach:
 * 1. Process each circle query.
 * 2. Calculate the squared distance from every point
 *    to the circle's center.
 * 3. If squared distance <= radius squared, count it.
 * 4. Store the count for each query.
 *
 * Time Complexity: O(Q * P)
 * Space Complexity: O(Q) for the answer
 * P = number of points, Q = number of queries.
 */

class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int centerX = queries[i][0];
            int centerY = queries[i][1];
            int radius = queries[i][2];

            int count = 0;

            for (int[] point : points) {

                int dx = point[0] - centerX;
                int dy = point[1] - centerY;

                // Check whether the point is inside or
                // on the boundary of the circle.
                if (dx * dx + dy * dy <= radius * radius) {
                    count++;
                }
            }

            answer[i] = count;
        }

        return answer;
    }
}
