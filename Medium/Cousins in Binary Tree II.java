/*
 * Problem: 2641. Cousins in Binary Tree II
 * Difficulty: Medium
 *
 * Approach: BFS (Level Order Traversal)
 *
 * 1. Calculate the sum of all nodes at the next level.
 * 2. Subtract each parent's children sum from that level sum.
 * 3. Assign the remaining sum to both children.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        root.val = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int levelSum = 0;

            // Calculate sum of next level
            for (TreeNode node : queue) {
                if (node.left != null) {
                    levelSum += node.left.val;
                }

                if (node.right != null) {
                    levelSum += node.right.val;
                }
            }

            // Update next level
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                int siblingSum = 0;

                if (node.left != null) {
                    siblingSum += node.left.val;
                }

                if (node.right != null) {
                    siblingSum += node.right.val;
                }

                if (node.left != null) {
                    node.left.val = levelSum - siblingSum;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    node.right.val = levelSum - siblingSum;
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}
