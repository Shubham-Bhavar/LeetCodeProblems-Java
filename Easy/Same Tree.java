/*
    LeetCode 100 - Same Tree

    Problem:
    --------
    Given the roots of two binary trees p and q, check whether
    the two trees are the same.

    Two binary trees are considered the same if:
    1. They have the same structure.
    2. Corresponding nodes have the same value.

    Example 1:
    Input:
    p = [1,2,3]
    q = [1,2,3]

    Output:
    true

    Example 2:
    Input:
    p = [1,2]
    q = [1,null,2]

    Output:
    false

    Example 3:
    Input:
    p = [1,2,1]
    q = [1,1,2]

    Output:
    false

    Approach:
    ---------
    Use recursion.

    For every pair of nodes:
    1. If both are null -> trees are same at this position.
    2. If one is null -> structures are different.
    3. If values are different -> trees are different.
    4. Recursively compare left subtrees.
    5. Recursively compare right subtrees.

    Time Complexity: O(n)
    Space Complexity: O(h)

    n = number of nodes
    h = height of the tree
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        // Both nodes are null
        if (p == null && q == null)
        {
            return true;
        }

        // One node is null
        if (p == null || q == null)
        {
            return false;
        }

        // Values are different
        if (p.val != q.val)
        {
            return false;
        }

        // Compare left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
