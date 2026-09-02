/*
LeetCode 2375 - Construct Smallest Number From DI String

Problem:
Given a pattern containing:
'I' -> Increasing
'D' -> Decreasing

Create the lexicographically smallest number using digits 1 to 9,
where each digit is used at most once.

Approach:
- Use a stack.
- Push digits from 1 to n + 1.
- When we see 'I', pop all digits from the stack.
- For 'D', keep pushing.
- This automatically reverses every consecutive D section,
  giving the smallest possible number.
*/

import java.util.*;

class Solution {
    public String smallestNumber(String pattern) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i <= pattern.length(); i++) {

            stack.push(i + 1);

            if (i == pattern.length() || pattern.charAt(i) == 'I') {

                while (!stack.isEmpty()) {
                    ans.append(stack.pop());
                }
            }
        }

        return ans.toString();
    }
}
