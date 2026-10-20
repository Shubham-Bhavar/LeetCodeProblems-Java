
/*
 * Problem: 654. Maximum Binary Tree
 * Difficulty: Medium
 * Topics: Array, Divide and Conquer, Tree, Binary Tree
 *
 * Approach:
 * 1. Find the maximum element in the current subarray.
 * 2. Create a tree node with that maximum value.
 * 3. Recursively build the left subtree from elements before
 *    the maximum element.
 * 4. Recursively build the right subtree from elements after
 *    the maximum element.
 *
 * Time Complexity: O(n^2) worst case
 * Space Complexity: O(n) for recursion and the tree.
 */

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIndex = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = buildTree(nums, left, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, right);

        return root;
    }
}
