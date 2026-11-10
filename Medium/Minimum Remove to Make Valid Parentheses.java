
/*
 * LeetCode 1249. Minimum Remove to Make Valid Parentheses
 *
 * Problem:
 * Remove the minimum number of parentheses to make
 * the given string valid.
 *
 * Approach: Stack (Using StringBuilder)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder result = new StringBuilder();
        int open = 0;

        // First pass: Remove invalid closing parentheses
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            } 
            else if (ch == ')') {

                if (open == 0) {
                    continue;
                }

                open--;
            }

            result.append(ch);
        }

        // Second pass: Remove extra opening parentheses
        StringBuilder answer = new StringBuilder();

        for (int i = result.length() - 1; i >= 0; i--) {

            char ch = result.charAt(i);

            if (ch == '(' && open > 0) {
                open--;
                continue;
            }

            answer.append(ch);
        }

        return answer.reverse().toString();
    }
}
