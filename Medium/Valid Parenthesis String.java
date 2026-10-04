/*
 * LeetCode 678: Valid Parenthesis String
 *
 * Problem:
 * Given a string containing '(', ')' and '*',
 * return true if the string is valid.
 *
 * '*' can represent:
 * - '('
 * - ')'
 * - empty string ""
 *
 * Example 1:
 * Input:  s = "()"
 * Output: true
 *
 * Example 2:
 * Input:  s = "(*)"
 * Output: true
 *
 * Example 3:
 * Input:  s = "(*))"
 * Output: true
 *
 * Example 4:
 * Input:  s = "("
 * Output: false
 *
 * Approach:
 * Keep two values:
 *
 * minOpen = minimum possible number of unmatched '('
 * maxOpen = maximum possible number of unmatched '('
 *
 * For '(':
 *     minOpen++
 *     maxOpen++
 *
 * For ')':
 *     minOpen--
 *     maxOpen--
 *
 * For '*':
 *     '*' can be ')', '(' or empty:
 *     minOpen--
 *     maxOpen++
 *
 * minOpen can never be negative because we can treat '*'
 * as '(' when necessary.
 *
 * If maxOpen becomes negative, there are too many ')',
 * so the string is invalid.
 *
 * At the end, minOpen must be 0.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            }

            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            }

            else { // '*'
                minOpen--;
                maxOpen++;
            }

            // Too many closing parentheses
            if (maxOpen < 0) {
                return false;
            }

            // Minimum cannot be negative
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        return minOpen == 0;
    }
}
