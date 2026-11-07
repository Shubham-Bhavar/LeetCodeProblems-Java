/*889. Construct Binary Tree from Preorder and Postorder Traversal

Difficulty: Medium
Topic: Binary Tree / Recursion
Language: Java

Approach

Used recursion and a HashMap to construct the binary tree.

- Preorder traversal identifies the root node.
- Postorder traversal helps identify subtree boundaries.
- A HashMap stores postorder indices for fast lookup.
- Recursively construct the left and right subtrees.

Complexity

- Time: O(n)
- Space: O(n)

Key Concepts

- Binary Tree
- Preorder Traversal
- Postorder Traversal
- Recursion
- HashMap*/

import java.util.*;

class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return build(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] pre, int[] post, int left, int right) {

        if (left > right || preIndex >= pre.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preIndex++]);

        if (left == right) {
            return root;
        }

        int index = map.get(pre[preIndex]);
        int leftSize = index - left + 1;

        root.left = build(pre, post, left, index);
        root.right = build(pre, post, index + 1, right - 1);

        return root;
    }
}
