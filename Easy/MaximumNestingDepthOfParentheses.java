// Problem: Maximum Nesting Depth of Parentheses
// Approach: Count '(' and track maximum depth

class Solution {
    public int maxDepth(String s) {

        int depth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }
            else if (c == ')') {
                depth--;
            }
        }

        return maxDepth;
    }
}
