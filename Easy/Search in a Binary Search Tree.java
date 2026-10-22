
/**
 * LeetCode 700: Search in a Binary Search Tree
 *
 * Approach:
 * Use the BST property to search efficiently.
 * - If val is smaller, move to the left subtree.
 * - If val is greater, move to the right subtree.
 * - If equal, return the current node.
 *
 * Time Complexity: O(h), where h is the tree height.
 * Space Complexity: O(1)
 * (Iterative approach)
 */

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }
}
