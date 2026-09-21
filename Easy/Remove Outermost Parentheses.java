/*
    LeetCode 1021 - Remove Outermost Parentheses

    Problem:
    ----------
    Given a valid parentheses string, remove the outermost
    parentheses from every primitive valid parentheses string.

    Example:
    Input:  "(()())(())"
    Output: "()()()"

    Approach:
    ----------
    Use a balance counter.

    '(' increases balance.
    ')' decreases balance.

    Skip:
    - Opening '(' when balance == 0
    - Closing ')' when balance == 1

    These are the outermost parentheses of each primitive.

    Time Complexity: O(n)
    Space Complexity: O(n)
*/

class Solution {

    public String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                // Skip outermost opening parenthesis
                if (balance > 0) {
                    result.append(ch);
                }

                balance++;
            }
            else {

                balance--;

                // Skip outermost closing parenthesis
                if (balance > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
