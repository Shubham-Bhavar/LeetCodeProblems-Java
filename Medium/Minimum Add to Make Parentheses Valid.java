/*
 * LeetCode 921: Minimum Add to Make Parentheses Valid
 *
 * Problem:
 * Given a parentheses string s, return the minimum number of
 * parentheses that must be inserted to make the string valid.
 *
 * Example 1:
 * Input:  s = "())"
 * Output: 1
 *
 * Example 2:
 * Input:  s = "((("
 * Output: 3
 *
 * Approach:
 * - Keep track of unmatched opening parentheses.
 * - When we see '(' -> increase open.
 * - When we see ')':
 *      If an opening '(' is available, match it.
 *      Otherwise, we need to insert an '('.
 *
 * At the end, any remaining opening parentheses need a ')'.
 *
 * Answer = insertions needed for ')' + remaining '('
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int answer = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    answer++;
                }
            }
        }

        return answer + open;
    }
}
