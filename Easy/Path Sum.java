
/*
 * LeetCode 112. Path Sum
 *
 * Description:
 * Given the root of a binary tree and a target sum,
 * determine whether a root-to-leaf path exists whose
 * node values add up to the target sum.
 *
 * Approach: Depth First Search (DFS)
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * h = height of the binary tree
 */

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Check if the tree is empty
        if (root == null) {
            return false;
        }

        // Check if the current node is a leaf
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Subtract the current node value
        int remainingSum = targetSum - root.val;

        // Search in the left or right subtree
        return hasPathSum(root.left, remainingSum)
            || hasPathSum(root.right, remainingSum);
    }
}
