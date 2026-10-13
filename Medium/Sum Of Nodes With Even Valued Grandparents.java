/*
 * LeetCode 1315: Sum of Nodes with Even-Valued Grandparent
 *
 * Problem:
 * Return the sum of all nodes whose grandparent has an even value.
 *
 * Example 1:
 * Input:  root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 *
 * Explanation:
 * Nodes with even-valued grandparents are 9, 1, 4, and 5.
 * Sum = 9 + 1 + 4 + 5 = 19.
 *
 * Approach:
 * 1. Traverse the tree using DFS.
 * 2. Track the parent and grandparent values.
 * 3. If the grandparent is even, add the current node.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h), where h is the tree height.
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

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, -1, -1);
    }

    private int dfs(TreeNode node, int parent, int grandparent) {
        if (node == null) {
            return 0;
        }

        int sum = 0;

        if (grandparent != -1 && grandparent % 2 == 0) {
            sum += node.val;
        }

        sum += dfs(node.left, node.val, parent);
        sum += dfs(node.right, node.val, parent);

        return sum;
    }
}