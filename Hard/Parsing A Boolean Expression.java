
/*
 * Problem: 1106. Parsing A Boolean Expression
 * Difficulty: Hard
 * Approach: Stack
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    public boolean parseBoolExpr(String expression) {

        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == ')') {

                int trueCount = 0;
                int falseCount = 0;

                while (stack.peek() != '(') {
                    char value = stack.pop();

                    if (value == 't') {
                        trueCount++;
                    } else if (value == 'f') {
                        falseCount++;
                    }
                }

                stack.pop();

                char operator = stack.pop();

                boolean result;

                if (operator == '!') {
                    result = falseCount == 1;
                } else if (operator == '&') {
                    result = falseCount == 0;
                } else {
                    result = trueCount > 0;
                }

                stack.push(result ? 't' : 'f');

            } else if (ch != ',') {
                stack.push(ch);
            }
        }

        return stack.peek() == 't';
    }
}
