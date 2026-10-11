/*
 * LeetCode 1261: Find Elements in a Contaminated Binary Tree
 *
 * Problem:
 * All node values in a binary tree are contaminated (-1).
 * Recover the tree using these rules:
 *
 * Root = 0
 * Left child  = 2 * parent + 1
 * Right child = 2 * parent + 2
 *
 * Implement:
 * FindElements(root) - Recover the tree.
 * find(target)       - Check whether target exists.
 *
 * Example 1:
 * Input:  root = [-1,null,-1], target = 2
 * Output: true
 *
 * Example 2:
 * Input:  root = [-1,-1,-1,-1,-1], target = 3
 * Output: true
 *
 * Constraints:
 * Height <= 20
 * Number of nodes <= 10^4
 * 0 <= target <= 10^6
 *
 * Approach:
 * 1. Set root value to 0.
 * 2. Recover left and right children recursively.
 * 3. Store recovered values in a HashSet.
 * 4. Use HashSet.contains() to search for a target.
 *
 * Time Complexity:
 * Constructor: O(n)
 * find(): O(1) average
 *
 * Space Complexity: O(n)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.HashSet;
import java.util.Set;

class FindElements {
    private Set<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        recover(root, 0);
    }

    private void recover(TreeNode node, int value) {
        if (node == null) {
            return;
        }

        node.val = value;
        values.add(value);

        recover(node.left, 2 * value + 1);
        recover(node.right, 2 * value + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}
