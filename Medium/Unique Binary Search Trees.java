```java
/*
 * LeetCode: Unique Binary Search Trees
 *
 * Problem:
 * Given an integer n, return the number of structurally unique
 * Binary Search Trees (BSTs) which have exactly n nodes with
 * unique values from 1 to n.
 *
 * Example 1:
 * Input:  n = 3
 * Output: 5
 *
 * Example 2:
 * Input:  n = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= n <= 19
 *
 * ------------------------------------------------------------
 * Approach: Dynamic Programming
 * ------------------------------------------------------------
 *
 * Let dp[i] = number of structurally unique BSTs possible
 * using exactly i nodes.
 *
 * Base case:
 *
 * dp[0] = 1
 *
 * Why?
 * An empty tree is considered one possible subtree.
 * This is important when calculating left or right subtrees.
 *
 * For every possible root:
 *
 *       root
 *      /    \
 *   left   right
 *
 * If the root is at position j:
 *
 * Left subtree  -> j nodes
 * Right subtree -> i - j - 1 nodes
 *
 * Therefore:
 *
 * dp[i] += dp[j] * dp[i-j-1]
 *
 * ------------------------------------------------------------
 * Example: n = 3
 * ------------------------------------------------------------
 *
 * dp[0] = 1
 * dp[1] = 1
 *
 * For 2 nodes:
 *
 * dp[2] = dp[0] * dp[1]
 *       + dp[1] * dp[0]
 *       = 1 + 1
 *       = 2
 *
 * For 3 nodes:
 *
 * dp[3] = dp[0] * dp[2]
 *       + dp[1] * dp[1]
 *       + dp[2] * dp[0]
 *
 *       = 1*2 + 1*1 + 2*1
 *       = 5
 *
 * Answer = 5
 *
 * ------------------------------------------------------------
 * Time Complexity:
 * O(n²)
 *
 * We calculate every dp[i] using all possible root positions.
 *
 * Space Complexity:
 * O(n)
 *
 * We store the number of BSTs for each number of nodes.
 */

class Solution {

    public int numTrees(int n) {

        // dp[i] = number of unique BSTs with i nodes
        int[] dp = new int[n + 1];

        // Empty tree
        dp[0] = 1;

        // Calculate answer for 1 to n nodes
        for (int nodes = 1; nodes <= n; nodes++) {

            // Try every node as the root
            for (int root = 1; root <= nodes; root++) {

                int leftNodes = root - 1;
                int rightNodes = nodes - root;

                // Number of combinations:
                // left subtree possibilities × right subtree possibilities
                dp[nodes] += dp[leftNodes] * dp[rightNodes];
            }
        }

        return dp[n];
    }
}
