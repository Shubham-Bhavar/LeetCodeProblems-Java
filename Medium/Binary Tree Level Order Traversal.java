/*
 * LeetCode 102: Binary Tree Level Order Traversal
 *
 * Problem:
 * Given the root of a binary tree, return the level order
 * traversal of its nodes' values.
 *
 * Traverse the tree:
 * - From left to right
 * - Level by level
 *
 * Example 1:
 * Input:
 * root = [3,9,20,null,null,15,7]
 *
 * Output:
 * [[3],[9,20],[15,7]]
 *
 * Example 2:
 * Input:
 * root = [1]
 *
 * Output:
 * [[1]]
 *
 * Example 3:
 * Input:
 * root = []
 *
 * Output:
 * []
 *
 * Constraints:
 * 0 <= number of nodes <= 2000
 * -1000 <= Node.val <= 1000
 *
 * Approach:
 * Use BFS with a Queue.
 *
 * 1. Put the root into the queue.
 * 2. Find the number of nodes in the current level.
 * 3. Remove exactly those nodes from the queue.
 * 4. Store their values in a list.
 * 5. Add their children to the queue.
 * 6. Repeat until the queue becomes empty.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                TreeNode current = queue.poll();

                currentLevel.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
}
