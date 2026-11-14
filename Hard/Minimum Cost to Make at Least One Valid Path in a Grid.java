
/*
 * LeetCode 1368: Minimum Cost to Make at Least One Valid Path in a Grid
 *
 * Problem:
 * Given a grid where each cell contains a direction,
 * find the minimum number of arrow modifications needed
 * to create a valid path from the top-left to bottom-right.
 *
 * Approach:
 * 0-1 BFS using Deque
 *
 * Step-by-step Explanation:
 * 1. Create a distance array to store minimum costs.
 * 2. Initialize all distances with a large value.
 * 3. Set the starting cell distance to 0.
 * 4. Add the starting cell to the deque.
 * 5. Remove a cell from the front of the deque.
 * 6. Check its four neighboring cells.
 * 7. If the movement follows the arrow, cost is 0.
 * 8. Otherwise, cost is 1.
 * 9. Update the distance if a smaller cost is found.
 * 10. Add cost-0 moves to the front and cost-1 moves
 *     to the back of the deque.
 * 11. Return the distance of the bottom-right cell.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

import java.util.*;

class Solution {

    public int minCost(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Directions: Right, Left, Down, Up
        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        // Store minimum cost to reach each cell
        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Deque stores row, column and current cost
        Deque<int[]> deque = new ArrayDeque<>();

        dist[0][0] = 0;
        deque.offerFirst(new int[]{0, 0, 0});

        while (!deque.isEmpty()) {

            int[] current = deque.pollFirst();

            int row = current[0];
            int col = current[1];
            int cost = current[2];

            // Skip outdated entries
            if (cost > dist[row][col]) {
                continue;
            }

            // Destination reached
            if (row == m - 1 && col == n - 1) {
                return cost;
            }

            // Check all four directions
            for (int d = 0; d < 4; d++) {

                int newRow = row + directions[d][0];
                int newCol = col + directions[d][1];

                // Check boundaries
                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n) {

                    // Cost is 0 if arrow matches, otherwise 1
                    int newCost = cost;

                    if (grid[row][col] != d + 1) {
                        newCost++;
                    }

                    // Update minimum cost
                    if (newCost < dist[newRow][newCol]) {

                        dist[newRow][newCol] = newCost;

                        if (grid[row][col] == d + 1) {

                            deque.offerFirst(
                                new int[]{newRow, newCol, newCost}
                            );

                        } else {

                            deque.offerLast(
                                new int[]{newRow, newCol, newCost}
                            );
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
