/*
 * Problem: 1625. Lexicographically Smallest String After Applying Operations
 * Difficulty: Medium
 *
 * Approach:
 * 1. Use BFS to explore every reachable string.
 * 2. From each string, perform either operation:
 *    - Add a to digits at odd indices.
 *    - Rotate the string right by b positions.
 * 3. Store visited strings to avoid repeating states.
 * 4. Keep track of the lexicographically smallest string.
 *
 * Time Complexity: O(n * 10^n) upper bound on reachable states
 * Space Complexity: O(n * 10^n) for visited states and the queue
 */

import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        String smallest = s;
        int n = s.length();

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.compareTo(smallest) < 0) {
                smallest = current;
            }

            // Operation 1: Add a to digits at odd indices
            char[] digits = current.toCharArray();

            for (int i = 1; i < n; i += 2) {
                digits[i] = (char) ('0' + (digits[i] - '0' + a) % 10);
            }

            String added = new String(digits);

            if (visited.add(added)) {
                queue.offer(added);
            }

            // Operation 2: Rotate the string right by b positions
            String rotated =
                current.substring(n - b) + current.substring(0, n - b);

            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }

        return smallest;
    }
}
