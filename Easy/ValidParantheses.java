// Problem: Valid Parentheses
// Approach: Use stack to match opening and closing brackets
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Step 1: if opening bracket → push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Step 2: if closing bracket
            else {
                // अगर stack empty असेल → invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // check matching
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Step 3: stack empty असेल तर valid
        return stack.isEmpty();
    }
}
