/*
 * LeetCode 856: Score of Parentheses
 *
 * Problem:
 * Given a balanced parentheses string s, return its score.
 *
 * Rules:
 * 1. "()" has score 1.
 * 2. AB has score A + B.
 * 3. (A) has score 2 * A.
 *
 * Examples:
 *
 * Input:  s = "()"
 * Output: 1
 *
 * Input:  s = "(())"
 * Output: 2
 *
 * Input:  s = "()()"
 * Output: 2
 *
 * Constraints:
 * 2 <= s.length <= 50
 * s contains only '(' and ')'.
 * s is balanced.
 *
 * Approach:
 * - Use a stack to store scores of nested levels.
 * - When '(' appears, start a new level with score 0.
 * - When ')' appears:
 *      If the current score is 0, it means "()",
 *      so its score is 1.
 *      Otherwise, its score is doubled.
 * - Add the calculated score to the previous level.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        // Score outside the parentheses
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Start a new level
                stack.push(0);
            } else {
                // Get score of current level
                int current = stack.pop();

                // "()" = 1, otherwise "(A)" = 2 * A
                int score;

                if (current == 0) {
                    score = 1;
                } else {
                    score = 2 * current;
                }

                // Add score to previous level
                stack.push(stack.pop() + score);
            }
        }

        return stack.peek();
    }
}
