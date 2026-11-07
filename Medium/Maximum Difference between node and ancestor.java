/*1026. Maximum Difference Between Node and Ancestor

Difficulty: Medium
Topic: Binary Tree / DFS
Language: Java

Approach

Used Depth First Search (DFS) to traverse the binary tree.

For each node, maintain:

- Minimum value among its ancestors and current node.
- Maximum value among its ancestors and current node.

Calculate the difference between the maximum and minimum values at every node and update the global maximum.

Complexity

- Time: O(n)
- Space: O(h)

Key Concepts

- Binary Tree
- Depth First Search (DFS)
- Recursion
- Tree Traversal*/

class Solution {
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    private void dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return;
        }

        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        maxDiff = Math.max(maxDiff, max - min);

        dfs(node.left, min, max);
        dfs(node.right, min, max);
    }
}
