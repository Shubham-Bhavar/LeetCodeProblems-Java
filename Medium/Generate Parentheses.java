    /*
        LeetCode 22 - Generate Parentheses

        Problem:
        Given n pairs of parentheses, generate all combinations
        of well-formed parentheses.

        Example:
        Input: n = 3

        Output:
        ["((()))","(()())","(())()","()(())","()()()"]

        Approach:
        We use Backtracking.

        Rules:
        1. We can add '(' if open < n.
        2. We can add ')' only if close < open.
           This keeps the parentheses valid.

        Example for n = 3:
        ((()))
        (()())
        (())()
        ()(())
        ()()()

        Time Complexity:
        O(4^n / sqrt(n))  - number of valid combinations

        Space Complexity:
        O(n) - recursion depth
    */
import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(
            List<String> result,
            String current,
            int open,
            int close,
            int n) {

        // If all brackets are used
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add opening bracket
        if (open < n) {
            backtrack(
                result,
                current + "(",
                open + 1,
                close,
                n
            );
        }

        // Add closing bracket only when valid
        if (close < open) {
            backtrack(
                result,
                current + ")",
                open,
                close + 1,
                n
            );
        }
    }
}
