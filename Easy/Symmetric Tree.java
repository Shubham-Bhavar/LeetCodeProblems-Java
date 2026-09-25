/*
    LeetCode 101 - Symmetric Tree

    Problem:
    --------
    Given the root of a binary tree, check whether the tree
    is symmetric around its center.

    Example 1:
    Input:
    root = [1,2,2,3,4,4,3]

    Output:
    true

    Example 2:
    Input:
    root = [1,2,2,null,3,null,3]

    Output:
    false

    Approach:
    ---------
    Compare the left and right subtrees as mirror images.

    For two mirror nodes:
    1. Both null -> true
    2. One null -> false
    3. Values different -> false
    4. Compare:
       - left.left with right.right
       - left.right with right.left

    Time Complexity: O(n)
    Space Complexity: O(h)
*/

class Solution {
    public boolean isSymmetric(TreeNode root) 
    {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right)
    {
        // Both are null
        if (left == null && right == null)
        {
            return true;
        }

        // One is null
        if (left == null || right == null)
        {
            return false;
        }

        // Values are different
        if (left.val != right.val)
        {
            return false;
        }

        // Compare opposite sides
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}
