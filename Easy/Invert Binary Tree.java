/*
 * LeetCode 226: Invert Binary Tree
 *
 * Problem:
 * Given the root of a binary tree, invert the tree and return its root.
 *
 * Inverting a binary tree means swapping the left and right child
 * of every node.
 *
 * Example 1:
 * Input:  root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * Example 2:
 * Input:  root = [2,1,3]
 * Output: [2,3,1]
 *
 * Example 3:
 * Input:  root = []
 * Output: []
 *
 * Constraints:
 * 0 <= number of nodes <= 100
 * -100 <= Node.val <= 100
 */

class Solution {

    public TreeNode invertTree(TreeNode root) {

        // Base case:
        // If the tree is empty, there is nothing to invert.
        if (root == null) {
            return null;
        }

        // Swap the left and right subtrees.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left subtree.
        invertTree(root.left);

        // Recursively invert the right subtree.
        invertTree(root.right);

        // Return the root of the inverted tree.
        return root;
    }
}
