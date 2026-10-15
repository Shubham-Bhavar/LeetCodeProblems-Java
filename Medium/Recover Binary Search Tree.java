/*LeetCode 99 — Recover Binary Search Tree

Difficulty: Medium
Topics: Tree, Depth-First Search, Binary Search Tree, Binary Tree
Approach: Inorder Traversal
Time Complexity: O(n)
Space Complexity: O(h) for recursion, where h is the tree height.

Problem

Two nodes of a Binary Search Tree (BST) are swapped by mistake. Recover the tree without changing its structure.
Logic

Inorder traversal of a valid BST produces values in ascending order.

If two nodes are swapped, the inorder sequence contains one or two violations.

Store the misplaced nodes in first and second.

Swap their values to restore the BST.

Example

Input:  [1,3,null,null,2]

Inorder before recovery: 3, 2, 1
Misplaced nodes: 3 and 1

Output: [3,1,null,null,2]

Complexity Analysis

Time Complexity: O(n), because each node is visited once.

Auxiliary Space: O(h), due to recursive calls.

Follow-up: This recursive solution does not use constant extra space. To achieve O(1) auxiliary space, use Morris inorder traversal, which temporarily modifies tree links and restores them during traversal.
Java Solution*/

class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // Find the two misplaced nodes using inorder traversal
        inorder(root);

        // Swap their values to recover the BST
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Visit the left subtree
        inorder(root.left);

        // Detect a violation of BST inorder order
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }

        // Update the previous node
        prev = root;

        // Visit the right subtree
        inorder(root.right);
    }
}

