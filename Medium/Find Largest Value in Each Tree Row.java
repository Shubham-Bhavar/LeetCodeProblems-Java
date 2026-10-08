/*
 * LeetCode 515: Find Largest Value in Each Tree Row
 *
 * Problem:
 * Given the root of a binary tree, return an array containing
 * the largest value in each row (level) of the tree.
 *
 * Example 1:
 * Input:
 * root = [1,3,2,5,3,null,9]
 *
 * Output:
 * [1,3,9]
 *
 * Example 2:
 * Input:
 * root = [1,2,3]
 *
 * Output:
 * [1,3]
 *
 * Approach:
 * Use BFS (Level Order Traversal).
 *
 * For each level:
 * 1. Find how many nodes are present.
 * 2. Traverse all nodes of that level.
 * 3. Keep track of the maximum value.
 * 4. Add the maximum value to the result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {

                TreeNode current = queue.poll();

                maxValue = Math.max(maxValue, current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(maxValue);
        }

        return result;
    }
}
