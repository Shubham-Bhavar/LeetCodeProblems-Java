/*
 * LeetCode 1302: Deepest Leaves Sum
 *
 * Problem:
 * Given the root of a binary tree, return the sum of the
 * values of its deepest leaves.
 *
 * Example 1:
 * Input:
 * root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 *
 * Output:
 * 15
 *
 * Explanation:
 * The deepest leaves are 7 and 8.
 * 7 + 8 = 15
 *
 * Example 2:
 * Input:
 * root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 *
 * Output:
 * 19
 *
 * Constraints:
 * 1 <= number of nodes <= 10^4
 * 1 <= Node.val <= 100
 *
 * Approach:
 * Use BFS (level order traversal).
 *
 * For every level:
 * - Reset the sum to 0.
 * - Add the values of all nodes in that level.
 * - Add their children to the queue.
 *
 * When BFS finishes, the sum from the last level
 * is the sum of the deepest leaves.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int sum = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            // Reset sum for the current level
            sum = 0;

            for (int i = 0; i < levelSize; i++) {

                TreeNode current = queue.poll();

                sum += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return sum;
    }
}
