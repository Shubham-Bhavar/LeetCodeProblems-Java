/*
 * LeetCode 301: Remove Invalid Parentheses
 *
 * Problem:
 * Given a string s containing parentheses and letters,
 * remove the minimum number of invalid parentheses to make
 * the string valid.
 *
 * Return all unique valid strings with the minimum removals.
 *
 * Example 1:
 * Input:  s = "()())()"
 * Output: ["(())()", "()()()"]
 *
 * Example 2:
 * Input:  s = "(a)())()"
 * Output: ["(a())()", "(a)()()"]
 *
 * Example 3:
 * Input:  s = ")("
 * Output: [""]
 *
 * Approach:
 * Use BFS (Breadth-First Search).
 *
 * 1. Start with the original string.
 * 2. Check whether it is valid.
 * 3. If not valid, remove one parenthesis from every possible
 *    position and create the next level.
 * 4. If any valid strings are found at the current level,
 *    return them.
 * 5. Do not go to the next level because we already found
 *    solutions using the minimum number of removals.
 *
 * We use a Set to avoid duplicate strings.
 *
 * Time Complexity:
 * O(2^n * n) in the worst case.
 *
 * Space Complexity:
 * O(2^n * n)
 */

import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // Check if current string is valid
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                // If valid strings are found,
                // do not remove more characters.
                if (found) {
                    continue;
                }

                // Remove one parenthesis
                for (int j = 0; j < current.length(); j++) {

                    char ch = current.charAt(j);

                    // Only remove parentheses
                    if (ch != '(' && ch != ')') {
                        continue;
                    }

                    String next =
                            current.substring(0, j)
                            + current.substring(j + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            // Current BFS level gave valid answers
            if (found) {
                break;
            }
        }

        return result;
    }

    // Checks whether parentheses are valid
    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }

            // More ')' than '('
            if (balance < 0) {
                return false;
            }
        }

        // All '(' must also be matched
        return balance == 0;
    }
}
