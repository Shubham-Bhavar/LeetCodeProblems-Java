
/*
 * LeetCode 230 - Kth Smallest Element in a BST
 *
 * Difficulty: Medium
 * Approach: Inorder Traversal
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);

        count++;

        if (count == k) {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }
}
