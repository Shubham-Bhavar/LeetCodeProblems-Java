/*
 * LeetCode 1379: Find a Corresponding Node of a Binary Tree
 * in a Clone of That Tree
 *
 * Problem:
 * Given the original tree, its cloned copy, and a target
 * node in the original tree, return the corresponding
 * node in the cloned tree.
 *
 * Example 1:
 * Input: tree = [7,4,3,null,null,6,19], target = 3
 * Output: 3
 *
 * Example 2:
 * Input: tree = [7], target = 7
 * Output: 7
 *
 * Example 3:
 * Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1]
 *        target = 4
 * Output: 4
 *
 * Constraints:
 * 1 <= number of nodes <= 10^4
 * Node values are unique.
 * target is a node in the original tree.
 *
 * Approach:
 * 1. Traverse original and cloned trees together.
 * 2. If the original node is the target, return its clone.
 * 3. Search the left subtree, then the right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h), due to recursion.
 * h = height of the tree.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(
            final TreeNode original,
            final TreeNode cloned,
            final TreeNode target) {

        // Target found in the original tree
        if (original == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        // Search the left subtree
        TreeNode leftResult = getTargetCopy(
                original.left, cloned.left, target
        );

        if (leftResult != null) {
            return leftResult;
        }

        // Search the right subtree
        return getTargetCopy(
                original.right, cloned.right, target
        );
    }
}
