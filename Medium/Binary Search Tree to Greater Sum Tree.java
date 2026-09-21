/*
    LeetCode 1038 - Binary Search Tree to Greater Sum Tree

    Problem:
    ----------
    Convert a Binary Search Tree into a Greater Sum Tree.

    Each node value becomes:
    
        original value + sum of all greater values

    Example:
    Input:  [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]

    Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

    Approach:
    ----------
    Use Reverse Inorder Traversal:

        RIGHT → ROOT → LEFT

    In a BST, reverse inorder visits nodes from
    largest value to smallest value.

    Maintain a running sum:

        sum = sum + root.val
        root.val = sum

    Time Complexity: O(n)
    Space Complexity: O(h)
*/

class Solution {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {

        if (root == null) {
            return null;
        }

        // Visit greater values first
        bstToGst(root.right);

        // Add current value to running sum
        sum += root.val;
        root.val = sum;

        // Visit smaller values
        bstToGst(root.left);

        return root;
    }
}
