/*
    LeetCode - Count Nodes Equal to Average of Subtree

    Problem:
    ----------
    Given the root of a binary tree, return the number of nodes
    whose value is equal to the average of all values in its subtree.

    The average is rounded down.

    Example:
    Input:  root = [4,8,5,0,1,null,6]
    Output: 5

    Approach:
    ----------
    Use Postorder Traversal:

        LEFT → RIGHT → ROOT

    For every node, calculate:
    - Sum of values in its subtree
    - Number of nodes in its subtree

    Then:
        average = sum / count

    If average == node.val, increase the answer.

    Time Complexity: O(n)
    Space Complexity: O(h)
    where h = height of the tree.
*/

class Solution {

    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = root.val + left[0] + right[0];
        int nodes = 1 + left[1] + right[1];

        int average = sum / nodes;

        if (average == root.val) {
            count++;
        }

        return new int[]{sum, nodes};
    }
}
