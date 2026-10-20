
/*
 * Problem: 938. Range Sum of BST
 * Difficulty: Easy
 * Topics: Tree, Binary Search Tree, Depth-First Search
 *
 * Approach:
 * 1. If the node is null, return 0.
 * 2. If the node value is less than low, search only the right subtree.
 * 3. If the node value is greater than high, search only the left subtree.
 * 4. Otherwise, add the current node and both subtree sums.
 *
 * Time Complexity: O(n) worst case
 * Space Complexity: O(h), where h is the tree height.
 */

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }
}
