/*
 * Problem: 2872. Maximum Number of K-Divisible Components
 * Difficulty: Hard
 *
 * Approach:
 * 1. Build an adjacency list for the tree.
 * 2. Use DFS starting from node 0.
 * 3. Calculate the sum of each subtree.
 * 4. If a subtree sum is divisible by k,
 *    count it as a separate component.
 * 5. Return the total number of components.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    private List<Integer>[] graph;
    private int[] values;
    private long k;
    private int components;

    public int maxKDivisibleComponents(
        int n, int[][] edges, int[] values, int k
    ) {

        this.values = values;
        this.k = k;
        this.components = 0;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the tree
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(0, -1);

        return components;
    }

    private long dfs(int node, int parent) {

        long sum = values[node];

        // Visit all child nodes
        for (int child : graph[node]) {

            if (child == parent) {
                continue;
            }

            sum += dfs(child, node);
        }

        // If subtree sum is divisible by k
        if (sum % k == 0) {
            components++;
            return 0;
        }

        return sum;
    }
}
