/*
 * LeetCode 32: Longest Valid Parentheses
 *
 * Problem:
 * Given a string containing only '(' and ')',
 * return the length of the longest valid parentheses substring.
 *
 * Example 1:
 * Input:  s = "(()"
 * Output: 2
 *
 * Example 2:
 * Input:  s = ")()())"
 * Output: 4
 *
 * Example 3:
 * Input:  s = ""
 * Output: 0
 *
 * Constraints:
 * 0 <= s.length <= 3 * 10^4
 * s[i] is '(' or ')'
 *
 * Approach:
 * Use a stack to store indexes.
 *
 * 1. Put -1 in the stack as a starting boundary.
 * 2. If we find '(':
 *      Push its index.
 * 3. If we find ')':
 *      Pop the last '('.
 *      If the stack becomes empty, push the current index
 *      as the new boundary.
 *      Otherwise, calculate the valid length.
 *
 * Example:
 * s = ")()())"
 *
 * The stack helps us find the starting position of
 * every valid parentheses substring.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        // Boundary before the valid substring
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                // No matching '('
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int length = i - stack.peek();
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}
