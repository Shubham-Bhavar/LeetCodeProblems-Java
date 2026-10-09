/*
 * LeetCode 1541: Minimum Insertions to Balance a Parentheses String
 *
 * Problem:
 * Given a string s containing only '(' and ')', find the minimum
 * insertions needed to balance the string.
 *
 * Every '(' must have exactly two consecutive ')' characters
 * as its closing pair: '))'.
 *
 * Example 1:
 * Input:  s = "(()))"
 * Output: 1
 *
 * Example 2:
 * Input:  s = "())"
 * Output: 0
 *
 * Example 3:
 * Input:  s = "))())("
 * Output: 3
 *
 * Constraints:
 * 1 <= s.length <= 100000
 *
 * Approach:
 * 1. Track the number of unmatched '(' using open.
 * 2. Every '(' requires two consecutive ')'.
 * 3. If a ')' appears, check whether another ')' follows.
 * 4. Insert a missing ')' when necessary.
 * 5. If a ')' has no matching '(', insert an '('.
 * 6. At the end, every unmatched '(' requires two ')'.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minInsertions(String s) {

        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {

                // Check whether the next character is ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    // Insert the missing second ')'
                    insertions++;
                }

                if (open > 0) {
                    open--;
                } else {
                    // No matching '(' exists; insert one
                    insertions++;
                }
            }
        }

        // Each unmatched '(' needs two closing parentheses
        insertions += open * 2;

        return insertions;
    }
}
