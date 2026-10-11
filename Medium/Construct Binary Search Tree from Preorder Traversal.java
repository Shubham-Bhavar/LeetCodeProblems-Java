/*
 * LeetCode 1008: Construct Binary Search Tree from Preorder Traversal
 *
 * Problem:
 * Given the preorder traversal of a BST, construct the BST
 * and return its root.
 *
 * Example 1:
 * Input:  preorder = [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 * Example 2:
 * Input:  preorder = [1,3]
 * Output: [1,null,3]
 *
 * Constraints:
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 1000
 * All values are unique.
 *
 * Approach:
 * 1. The first element becomes the root.
 * 2. Values smaller than the root go to the left subtree.
 * 3. Values greater than the root go to the right subtree.
 * 4. Use bounds to construct the tree efficiently.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int lower, int upper) {
        if (index == preorder.length) {
            return null;
        }

        int value = preorder[index];

        if (value <= lower || value >= upper) {
            return null;
        }

        TreeNode root = new TreeNode(value);
        index++;

        root.left = build(preorder, lower, value);
        root.right = build(preorder, value, upper);

        return root;
    }
}
