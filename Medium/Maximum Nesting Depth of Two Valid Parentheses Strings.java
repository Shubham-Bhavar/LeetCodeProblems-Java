/*
 * ============================================================
 * LeetCode 1111: Maximum Nesting Depth of Two Valid
 *                Parentheses Strings
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * Given a valid parentheses string seq, split it into two
 * disjoint subsequences A and B.
 *
 * Both A and B must be valid parentheses strings.
 *
 * We need to minimize:
 *
 *     max(depth(A), depth(B))
 *
 * Return an answer array:
 *
 *     0 -> character belongs to A
 *     1 -> character belongs to B
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * seq = "(()())"
 *
 * Output:
 * [0,1,1,1,1,0]
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * seq = "()(())()"
 *
 * Output:
 * [0,0,0,1,1,0,1,1]
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * Keep track of the current nesting depth.
 *
 * We can divide the parentheses between A and B based on
 * whether the current depth is odd or even.
 *
 * If depth is odd  -> put character in B (1)
 * If depth is even -> put character in A (0)
 *
 * For '(':
 *     Increase depth first, then decide the group.
 *
 * For ')':
 *     Decide the group first, then decrease depth.
 *
 * ------------------------------------------------------------
 * Example:
 *
 * seq = "((()))"
 *
 * Depth:
 *
 * ( -> 1 -> group 1
 * ( -> 2 -> group 0
 * ( -> 3 -> group 1
 * ) -> 3 -> group 1
 * ) -> 2 -> group 0
 * ) -> 1 -> group 1
 *
 * Answer:
 * [1,0,1,1,0,1]
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * ============================================================
 */

class Solution {

    public int[] maxDepthAfterSplit(String seq) {

        int n = seq.length();

        int[] answer = new int[n];

        int depth = 0;

        for (int i = 0; i < n; i++) {

            char ch = seq.charAt(i);

            if (ch == '(') {

                // Opening bracket increases depth
                depth++;

                // Odd depth -> B
                // Even depth -> A
                answer[i] = depth % 2;

            } else {

                // Closing bracket belongs to the
                // current depth level
                answer[i] = depth % 2;

                // Then decrease depth
                depth--;
            }
        }

        return answer;
    }
}
