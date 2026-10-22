/**
 * LeetCode 1382: Balance a Binary Search Tree
 *
 * Approach:
 * 1. Perform inorder traversal to store node values
 *    in sorted order.
 * 2. Build a balanced BST by choosing the middle
 *    element as the root recursively.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<Integer> values = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildTree(0, values.size() - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        values.add(node.val);
        inorder(node.right);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildTree(left, mid - 1);
        root.right = buildTree(mid + 1, right);

        return root;
    }
}
