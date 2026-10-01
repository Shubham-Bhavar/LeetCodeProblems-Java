/*
 * LeetCode 894: All Possible Full Binary Trees
 *
 * A full binary tree has either:
 * - 0 children
 * - 2 children
 *
 * Therefore, the number of nodes must be odd.
 *
 * Example:
 * Input: n = 3
 * Output: [[0,0,0]]
 *
 * Approach:
 * 1. If n is even, return empty list.
 * 2. If n == 1, create one node.
 * 3. Try every possible odd number of nodes
 *    for the left subtree.
 * 4. Remaining nodes go to the right subtree.
 * 5. Combine every left tree with every right tree.
 *
 * Time: Output-dependent
 * Space: Output-dependent
 */

import java.util.*;

class Solution {

    public List<TreeNode> allPossibleFBT(int n) {

        List<TreeNode> result = new ArrayList<>();

        // Full binary tree cannot have even number of nodes
        if (n % 2 == 0) {
            return result;
        }

        // Base case
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }

        // Try different sizes for left subtree
        for (int leftNodes = 1; leftNodes < n; leftNodes += 2) {

            int rightNodes = n - 1 - leftNodes;

            List<TreeNode> leftTrees =
                    allPossibleFBT(leftNodes);

            List<TreeNode> rightTrees =
                    allPossibleFBT(rightNodes);

            // Combine left and right trees
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(0);

                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        return result;
    }
}
