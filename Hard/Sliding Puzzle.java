
/*
 * Problem: 773. Sliding Puzzle
 * Difficulty: Hard
 * Approach: Breadth-First Search (BFS)
 * Time Complexity: O(6! * 6)
 * Space Complexity: O(6!)
 */

import java.util.*;

class Solution {

    public int slidingPuzzle(int[][] board) {

        StringBuilder start = new StringBuilder();

        // Convert 2D board into a string
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }

        String target = "123450";

        // Possible adjacent positions of zero
        int[][] moves = {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start.toString());
        visited.add(start.toString());

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // Check if puzzle is solved
                if (current.equals(target)) {
                    return steps;
                }

                int zero = current.indexOf('0');

                // Generate next possible states
                for (int next : moves[zero]) {

                    char[] arr = current.toCharArray();

                    // Swap zero with adjacent tile
                    char temp = arr[zero];
                    arr[zero] = arr[next];
                    arr[next] = temp;

                    String newState = new String(arr);

                    if (!visited.contains(newState)) {
                        visited.add(newState);
                        queue.offer(newState);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
