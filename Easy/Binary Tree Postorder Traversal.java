/*
LeetCode 145. Binary Tree Postorder Traversal

Difficulty: Easy

Problem Statement:
Given the root of a binary tree, return the postorder traversal
of its node values.

Postorder Traversal:
    Left -> Right -> Root

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Approach:
Use recursion.

1. If the root is null, return.
2. Visit the left subtree.
3. Visit the right subtree.
4. Add the root value to the result.

Key Idea:
    Left -> Right -> Root

Time Complexity: O(n)
Space Complexity: O(h)
where h is the height of the tree.
*/

import java.util.*;

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);

        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        // Visit Left
        postorder(root.left, result);

        // Visit Right
        postorder(root.right, result);

        // Visit Root
        result.add(root.val);
    }
}