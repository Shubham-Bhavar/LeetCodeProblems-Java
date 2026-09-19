    /*
        LeetCode 94 - Binary Tree Inorder Traversal

        Inorder Traversal:
        ------------------
        LEFT → ROOT → RIGHT

        Approach:
        ----------
        Use Stack to perform inorder traversal iteratively.

        Steps:
        1. Go as far left as possible.
        2. Push every node into stack.
        3. Pop the top node.
        4. Add its value to result.
        5. Move to its right child.
        6. Repeat.

        Time Complexity: O(n)
        Space Complexity: O(n)
    */
import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            // Step 1: Go to the leftmost node
            while (root != null) {

                stack.push(root);
                root = root.left;
            }

            // Step 2: Get the top node
            root = stack.pop();

            // Step 3: Visit the node
            result.add(root.val);

            // Step 4: Move to the right subtree
            root = root.right;
        }

        return result;
    }
}
