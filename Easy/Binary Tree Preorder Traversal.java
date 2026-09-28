/*
 * LeetCode: 144. Binary Tree Preorder Traversal
 *
 * Problem:
 * Given the root of a binary tree, return the preorder traversal
 * of its nodes' values.
 *
 * Preorder Traversal:
 * Root → Left → Right
 *
 * Example 1:
 * Input:  root = [1,null,2,3]
 * Output: [1,2,3]
 *
 * Example 2:
 * Input:  root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * Output: [1,2,4,5,6,7,3,8,9]
 *
 * Example 3:
 * Input:  root = []
 * Output: []
 *
 * Approach:
 * Use recursion.
 * 1. Visit the current node.
 * 2. Traverse the left subtree.
 * 3. Traverse the right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * where n = number of nodes and h = height of the tree.
 */

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // Root
        result.add(root.val);

        // Left subtree
        preorder(root.left, result);

        // Right subtree
        preorder(root.right, result);
    }
}
