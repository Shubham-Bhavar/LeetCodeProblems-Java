
/*
 * LeetCode 3841: Palindromic Path Queries in a Tree
 * Difficulty: Hard
 * Language: Java
 *
 * Approach:
 * - Euler Tour to identify subtree ranges.
 * - Bitmask to track character frequency parity.
 * - Fenwick Tree for efficient XOR updates.
 * - Binary Lifting to find the Lowest Common Ancestor (LCA).
 *
 * Time Complexity: O((n + q) * log n)
 * Space Complexity: O(n * log n)
 */

import java.util.*;

class Solution {
    int n, LOG, timer;
    List<Integer>[] tree;
    int[][] up;
    int[] depth, tin, tout, bit;
    char[] chars;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        chars = s.toCharArray();

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        bit = new int[n + 2];

        int[] parent = new int[n];
        int[] nodes = new int[n];
        int[] iter = new int[n];
        int[] prefix = new int[n];

        Arrays.fill(parent, -1);
        parent[0] = 0;
        up[0][0] = 0;
        nodes[0] = 0;
        tin[0] = ++timer;
        prefix[0] = mask(chars[0]);

        int top = 0;

        // Iterative DFS: build Euler Tour and LCA table.
        while (top >= 0) {
            int u = nodes[top];

            if (iter[top] < tree[u].size()) {
                int v = tree[u].get(iter[top]++);

                if (v == parent[u]) continue;

                parent[v] = u;
                up[0][v] = u;
                depth[v] = depth[u] + 1;

                for (int k = 1; k < LOG; k++) {
                    up[k][v] = up[k - 1][up[k - 1][v]];
                }

                prefix[v] = prefix[u] ^ mask(chars[v]);
                tin[v] = ++timer;

                nodes[++top] = v;
                iter[top] = 0;
            } else {
                tout[u] = timer;
                top--;
            }
        }

        // Initialize root-to-node prefix masks.
        for (int i = 0; i < n; i++) {
            rangeXor(tin[i], tin[i], prefix[i]);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");
            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);
                int delta = mask(chars[u]) ^ mask(c);

                if (delta != 0) {
                    rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int v = Integer.parseInt(parts[2]);
                int lca = getLCA(u, v);

                int pathMask = pointQuery(tin[u])
                             ^ pointQuery(tin[v])
                             ^ mask(chars[lca]);

                answer.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return answer;
    }

    // Represent a character using one of 26 bits.
    private int mask(char c) {
        return 1 << (c - 'a');
    }

    // XOR-update an interval in the Euler Tour.
    private void rangeXor(int left, int right, int value) {
        if (value == 0) return;

        updateBIT(left, value);
        updateBIT(right + 1, value);
    }

    private void updateBIT(int index, int value) {
        while (index <= n + 1) {
            bit[index] ^= value;
            index += index & -index;
        }
    }

    // Get the current prefix mask at an Euler Tour position.
    private int pointQuery(int index) {
        int result = 0;

        while (index > 0) {
            result ^= bit[index];
            index -= index & -index;
        }

        return result;
    }

    // Find the Lowest Common Ancestor using Binary Lifting.
    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int difference = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((difference & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }
}
