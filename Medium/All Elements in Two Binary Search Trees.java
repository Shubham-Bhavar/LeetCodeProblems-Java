/*
 * LeetCode 1305: All Elements in Two Binary Search Trees
 *
 * Problem:
 * Given two BSTs, return all their elements in ascending order.
 *
 * Example 1:
 * Input:  root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 *
 * Example 2:
 * Input:  root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *
 * Constraints:
 * Each tree contains 0 to 5000 nodes.
 * -10^5 <= Node.val <= 10^5
 *
 * Approach:
 * 1. Inorder traverse both trees to get sorted lists.
 * 2. Merge both lists in ascending order.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

import java.util.*;

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Merge the two sorted lists
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }

        while (i < list1.size()) {
            result.add(list1.get(i++));
        }

        while (j < list2.size()) {
            result.add(list2.get(j++));
        }

        return result;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
