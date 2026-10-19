/*
LeetCode 1123: Lowest Common Ancestor of Deepest Leaves
Difficulty: Medium
Topics: Tree, Depth-First Search, Binary Tree

Approach:
1. Recursively find the deepest depth of the left and right subtrees.
2. If both depths are equal, the current node is the LCA.
3. Otherwise, continue into the deeper subtree.

Time Complexity: O(n)
Space Complexity: O(h), where h is the tree height.
*/

class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth == right.depth) {
            return new Result(root, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else {
            return new Result(right.node, right.depth + 1);
        }
    }

    class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
