/*
 * LeetCode 199: Binary Tree Right Side View
 *
 * Problem:
 * Given the root of a binary tree, imagine yourself standing
 * on the right side of the tree.
 *
 * Return the values of the nodes that are visible from the
 * right side, ordered from top to bottom.
 *
 * Example 1:
 * Input:
 * root = [1,2,3,null,5,null,4]
 *
 * Output:
 * [1,3,4]
 *
 * Example 2:
 * Input:
 * root = [1,2,3,4,null,null,null,5]
 *
 * Output:
 * [1,3,4,5]
 *
 * Example 3:
 * Input:
 * root = [1,null,3]
 *
 * Output:
 * [1,3]
 *
 * Example 4:
 * Input:
 * root = []
 *
 * Output:
 * []
 *
 * Constraints:
 * 0 <= number of nodes <= 100
 * -100 <= Node.val <= 100
 *
 * Approach:
 * Use BFS (Level Order Traversal).
 *
 * For every level of the tree:
 * - Visit all nodes in that level.
 * - The LAST node visited is the node visible from the right side.
 * - Add that node's value to the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Last node of the level is visible from the right
                if (i == levelSize - 1) {
                    result.add(current.val);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return result;
    }
}
