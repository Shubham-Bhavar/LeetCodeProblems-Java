
/*
 * LeetCode 998: Maximum Binary Tree II
 *
 * Problem:
 * Insert a new value at the end of the original array
 * and return the updated Maximum Binary Tree.
 *
 * Approach:
 * Recursion
 *
 * Step-by-step Explanation:
 * 1. If root is null, create a new node.
 * 2. If val is greater than root.val:
 *    - Create a new node with val.
 *    - Make the existing root its left child.
 *    - Return the new node.
 * 3. Otherwise, recursively insert val
 *    into the right subtree.
 * 4. Return the original root.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(h)
 * h = height of the tree.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode() {}
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        // If tree is empty, create a new node.
        if (root == null) {
            return new TreeNode(val);
        }

        // If new value is greater than root.
        if (val > root.val) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        // Insert into the right subtree.
        root.right = insertIntoMaxTree(root.right, val);

        return root;
    }
}
