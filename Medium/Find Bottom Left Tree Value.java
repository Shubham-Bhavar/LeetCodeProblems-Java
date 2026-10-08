/*
 * LeetCode 513: Find Bottom Left Tree Value
 *
 * Problem:
 * Given the root of a binary tree, return the leftmost value
 * in the last row of the tree.
 *
 * Example 1:
 * Input:  root = [2,1,3]
 * Output: 1
 *
 * Example 2:
 * Input:  root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
 *
 * Approach:
 * Use BFS (Level Order Traversal).
 *
 * For every level:
 * - The first node is the leftmost node of that level.
 * - Store that value.
 *
 * After BFS finishes, the stored value belongs to the last level.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int answer = root.val;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode current = queue.poll();

                // First node of the current level
                if (i == 0) {
                    answer = current.val;
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return answer;
    }
}
