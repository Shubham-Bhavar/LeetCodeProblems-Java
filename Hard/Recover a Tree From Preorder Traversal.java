/*
 * ============================================================
 * LeetCode 1028: Recover a Tree From Preorder Traversal
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * We perform a preorder DFS traversal of a binary tree.
 *
 * For every node:
 *
 *     - Output D dashes, where D is the depth of the node.
 *     - Then output the value of the node.
 *
 * The root has depth 0.
 *
 * If a node has only one child, that child is guaranteed to be
 * the LEFT child.
 *
 * Given the traversal string, reconstruct the original binary
 * tree and return its root.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * "1-2--3--4-5--6--7"
 *
 * Output:
 * [1,2,5,3,4,6,7]
 *
 * Tree:
 *
 *           1
 *         /   \
 *        2     5
 *       / \   / \
 *      3   4 6   7
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * "1-2--3---4-5--6---7"
 *
 * Output:
 * [1,2,5,3,null,6,null,4,null,7]
 *
 * ------------------------------------------------------------
 * Example 3:
 * ------------------------------------------------------------
 *
 * Input:
 * "1-401--349---90--88"
 *
 * Output:
 * [1,401,null,349,88,90]
 *
 * ------------------------------------------------------------
 * Constraints:
 * ------------------------------------------------------------
 *
 * Number of nodes is in [1, 1000].
 * 1 <= Node.val <= 10^9
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * We use a Stack.
 *
 * The stack represents the path from the root to the current
 * node.
 *
 * For every node:
 *
 * 1. Count the number of '-' characters.
 *    This gives the node's depth.
 *
 * 2. Read the node's value.
 *
 * 3. Remove nodes from the stack until its size equals
 *    the current depth.
 *
 * 4. The node remaining at the top of the stack is the parent.
 *
 * 5. If the parent's left child is empty, attach the new node
 *    as the left child.
 *
 * 6. Otherwise, attach it as the right child.
 *
 * 7. Push the new node onto the stack.
 *
 * ------------------------------------------------------------
 * Why does this work?
 * ------------------------------------------------------------
 *
 * Consider:
 *
 *     1-2--3--4-5
 *
 * Depths:
 *
 *     1 → depth 0
 *     2 → depth 1
 *     3 → depth 2
 *     4 → depth 2
 *     5 → depth 1
 *
 * When we reach node 5:
 *
 *     Stack = [1, 2, 4]
 *
 * Node 5 has depth 1.
 *
 * We remove nodes until stack size becomes 1:
 *
 *     Stack = [1]
 *
 * Therefore, 1 is the parent of 5.
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 *
 * Each node is pushed and popped from the stack at most once.
 *
 * Space Complexity: O(h)
 *
 * where h is the height of the tree.
 *
 * ============================================================
 */

class Solution {

    public TreeNode recoverFromPreorder(String traversal) {

        // Stack stores the current path from root to node
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();

        int i = 0;
        int n = traversal.length();

        while (i < n) {

            // ------------------------------------------------
            // Step 1: Find the depth by counting '-'
            // ------------------------------------------------
            int depth = 0;

            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // ------------------------------------------------
            // Step 2: Read the node value
            // ------------------------------------------------
            int value = 0;

            while (i < n && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(value);

            // ------------------------------------------------
            // Step 3: Move stack back to the correct depth
            // ------------------------------------------------
            while (stack.size() > depth) {
                stack.pop();
            }

            // ------------------------------------------------
            // Step 4: Connect node with its parent
            // ------------------------------------------------
            if (!stack.isEmpty()) {

                TreeNode parent = stack.peek();

                if (parent.left == null) {
                    // First child is always the left child
                    parent.left = node;
                } else {
                    // Second child is the right child
                    parent.right = node;
                }
            }

            // ------------------------------------------------
            // Step 5: Add current node to the path
            // ------------------------------------------------
            stack.push(node);
        }

        // The bottom of the stack is the root.
        // We can simply return the first node using stack.get(0).
        return stack.get(0);
    }
}
