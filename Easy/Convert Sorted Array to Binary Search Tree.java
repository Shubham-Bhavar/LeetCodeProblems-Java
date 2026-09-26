/*
    LeetCode 108 - Convert Sorted Array to Binary Search Tree

    Problem:
    --------
    Given a sorted array in ascending order, convert it into a
    height-balanced Binary Search Tree (BST).

    A height-balanced BST is a tree where the heights of the
    left and right subtrees of every node differ by at most 1.

    Example 1:
    Input:
    nums = [-10, -3, 0, 5, 9]

    Output:
    [0, -3, 9, -10, null, 5]

    Example 2:
    Input:
    nums = [1, 3]

    Output:
    [3, 1]

    Approach:
    ---------
    1. Find the middle element of the current array range.
    2. Make it the root.
    3. Elements on the left form the left subtree.
    4. Elements on the right form the right subtree.
    5. Repeat recursively.

    Why middle?
    ------------
    Choosing the middle element keeps the number of nodes on
    both sides approximately equal, producing a height-balanced BST.

    Time Complexity:
    O(n)

    Every element is used exactly once.

    Space Complexity:
    O(log n)

    Recursive call stack for a balanced tree.
*/

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {

        // No elements remaining
        if (left > right) {
            return null;
        }

        // Find middle element
        int mid = left + (right - left) / 2;

        // Create root
        TreeNode root = new TreeNode(nums[mid]);

        // Build left subtree
        root.left = buildTree(nums, left, mid - 1);

        // Build right subtree
        root.right = buildTree(nums, mid + 1, right);

        return root;
    }
}
