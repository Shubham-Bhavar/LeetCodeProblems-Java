/*
 * LeetCode 2415: Reverse Odd Levels of Binary Tree
 *
 * Problem:
 * Given the root of a perfect binary tree, reverse the node values
 * at every odd level of the tree.
 *
 * The root is at level 0.
 * Therefore:
 * - Level 0 -> do not reverse
 * - Level 1 -> reverse
 * - Level 2 -> do not reverse
 * - Level 3 -> reverse
 * - ...
 *
 * Example 1:
 * Input:  root = [2,3,5,8,13,21,34]
 * Output: [2,5,3,8,13,21,34]
 *
 * Explanation:
 * Level 1 contains [3,5].
 * Reverse it to [5,3].
 *
 * Example 2:
 * Input:  root = [7,13,11]
 * Output: [7,11,13]
 *
 * Example 3:
 * Input:
 * [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
 *
 * Output:
 * [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 *
 * Approach:
 * Since the tree is perfect, every node has a corresponding
 * mirror node.
 *
 * For example:
 *
 *              1
 *            /   \
 *           2     3
 *
 * At an odd level, swap the values of the two corresponding nodes.
 *
 * We recursively process:
 * - left child of left node with right child of right node
 * - right child of left node with left child of right node
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {

    public TreeNode reverseOddLevels(TreeNode root) {

        // Start with level 0
        dfs(root.left, root.right, 1);

        return root;
    }

    private void dfs(TreeNode leftNode,
                     TreeNode rightNode,
                     int level) {

        // Stop at leaf nodes
        if (leftNode == null || rightNode == null) {
            return;
        }

        // Reverse values at odd levels
        if (level % 2 == 1) {
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
        }

        // Move to the next level
        dfs(leftNode.left, rightNode.right, level + 1);

        dfs(leftNode.right, rightNode.left, level + 1);
    }
}
