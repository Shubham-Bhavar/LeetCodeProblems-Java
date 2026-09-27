```java
/*
 * LeetCode: Reverse Substrings Between Each Pair of Parentheses
 *
 * Problem:
 * Given a string s containing lowercase English letters and parentheses,
 * reverse the strings inside each pair of matching parentheses.
 *
 * The reversal starts from the innermost pair of parentheses.
 * The final result must not contain any parentheses.
 *
 * Example 1:
 * Input:  s = "(abcd)"
 * Output: "dcba"
 *
 * Example 2:
 * Input:  s = "(u(love)i)"
 * Output: "iloveu"
 *
 * Example 3:
 * Input:  s = "(ed(et(oc))el)"
 * Output: "leetcode"
 *
 * Constraints:
 * - 1 <= s.length <= 2000
 * - s contains lowercase English letters and parentheses.
 * - All parentheses are balanced.
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * We use a Stack of StringBuilder objects.
 *
 * 1. Start with one empty StringBuilder.
 * 2. When '(' is found:
 *      - Push the current StringBuilder onto the stack.
 *      - Start a new StringBuilder for the substring inside parentheses.
 *
 * 3. When a lowercase character is found:
 *      - Add it to the current StringBuilder.
 *
 * 4. When ')' is found:
 *      - Reverse the current StringBuilder.
 *      - Pop the previous StringBuilder from the stack.
 *      - Append the reversed substring to it.
 *
 * 5. At the end, the remaining StringBuilder contains the answer.
 *
 * ------------------------------------------------------------
 * Example:
 * ------------------------------------------------------------
 *
 * Input: "(u(love)i)"
 *
 * '('  -> start new substring
 * 'u'  -> "u"
 * '('  -> start inner substring
 * "love" -> "love"
 * ')'  -> reverse "love" -> "evol"
 *          append to previous -> "uevol"
 * 'i'  -> "uevoli"
 * ')'  -> reverse "uevoli" -> "iloveu"
 *
 * Output: "iloveu"
 *
 * Time Complexity:
 * O(n²) in the worst case because reversing strings may take O(n)
 * multiple times.
 *
 * Space Complexity:
 * O(n) for the stack and StringBuilder objects.
 */

import java.util.Stack;

class Solution {

    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();

        // Current substring being constructed
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            // Start a new substring
            if (ch == '(') {
                stack.push(current);
                current = new StringBuilder();
            }

            // End of current substring
            else if (ch == ')') {

                // Reverse the substring inside parentheses
                current.reverse();

                // Restore the previous substring
                StringBuilder previous = stack.pop();

                // Append reversed substring
                previous.append(current);

                current = previous;
            }

            // Normal lowercase character
            else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}
