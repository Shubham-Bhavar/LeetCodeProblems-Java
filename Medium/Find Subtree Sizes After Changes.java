
/*
 * LeetCode 3331: Find Subtree Sizes After Changes
 *
 * Approach:
 * 1. Build the original tree.
 * 2. Use DFS to find the closest ancestor with the same character.
 * 3. Store the updated parent of each node.
 * 4. Build the modified tree.
 * 5. Calculate subtree sizes in reverse DFS order.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        // Build original tree
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        int[] old = new int[n];

        Arrays.fill(last, -1);

        // DFS using enter and exit events
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {

            int node = stack.pop();

            if (node >= 0) {

                int ch = s.charAt(node) - 'a';

                old[node] = last[ch];

                if (last[ch] != -1) {
                    newParent[node] = last[ch];
                }

                last[ch] = node;

                // Exit event
                stack.push(~node);

                for (int child : tree[node]) {
                    stack.push(child);
                }

            } else {

                int originalNode = ~node;
                int ch = s.charAt(originalNode) - 'a';

                last[ch] = old[originalNode];
            }
        }

        // Build modified tree
        List<Integer>[] modified = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            modified[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            modified[newParent[i]].add(i);
        }

        // Get DFS order
        int[] order = new int[n];
        int index = 0;

        stack.push(0);

        while (!stack.isEmpty()) {

            int node = stack.pop();
            order[index++] = node;

            for (int child : modified[node]) {
                stack.push(child);
            }
        }

        // Calculate subtree sizes
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = n - 1; i > 0; i--) {
            int node = order[i];
            answer[newParent[node]] += answer[node];
        }

        return answer;
    }
}
