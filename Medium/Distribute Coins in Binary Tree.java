
/*
 * LeetCode 979 - Distribute Coins in Binary Tree
 *
 * Difficulty: Medium
 * Approach: DFS (Postorder Traversal)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class Solution {
    int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        moves += Math.abs(left) + Math.abs(right);

        return node.val + left + right - 1;
    }
}
