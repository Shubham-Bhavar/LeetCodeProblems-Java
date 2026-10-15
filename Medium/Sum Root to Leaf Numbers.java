
/*
 * LeetCode 129: Sum Root to Leaf Numbers
 *
 * Problem:
 * Each root-to-leaf path represents a number.
 * Return the sum of all root-to-leaf numbers.
 *
 * Approach: DFS (Depth-First Search)
 * 1. Build the current number using:
 *    number = number * 10 + node.val
 * 2. If the node is a leaf, return the number.
 * 3. Otherwise, recursively calculate the left
 *    and right subtree sums.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * n = number of nodes
 * h = height of the tree
 */

// TreeNode is provided by LeetCode.

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int number) {
        if (node == null) {
            return 0;
        }

        number = number * 10 + node.val;

        // If the node is a leaf, return its complete number
        if (node.left == null && node.right == null) {
            return number;
        }

        return dfs(node.left, number)
             + dfs(node.right, number);
    }
}
