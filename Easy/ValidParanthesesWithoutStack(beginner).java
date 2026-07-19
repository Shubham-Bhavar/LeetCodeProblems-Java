// Problem: Valid Parentheses (Without Stack - Trick)
// Approach: Repeatedly remove valid pairs
// Time Complexity: O(n^2)

class Solution {
    public boolean isValid(String s) {

        // keep removing valid pairs
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "")
                 .replace("{}", "")
                 .replace("[]", "");
        }

        // if empty → valid
        return s.isEmpty();
    }
}
