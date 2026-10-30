/*
 * Problem: 3970. Shortest Path With At Most K Consecutive Identical Characters
 * Difficulty: Medium
 * Topics: Graph, Dijkstra's Algorithm, Priority Queue
 *
 * Approach:
 * 1. Build a directed graph using an adjacency list.
 * 2. Use Dijkstra's algorithm with state (node, consecutiveCount).
 * 3. If adjacent labels are equal, increase consecutiveCount.
 * 4. Otherwise, reset consecutiveCount to 1.
 * 5. Skip paths where consecutiveCount exceeds k.
 *
 * Time Complexity: O(E * K * log(N * K))
 * Space Complexity: O(N * K + E)
 */

import java.util.*;

class Solution {

    static class State {
        int node;
        int count;
        int distance;

        State(int node, int count, int distance) {
            this.node = node;
            this.count = count;
            this.distance = distance;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.distance, b.distance)
        );

        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            int u = curr.node;
            int count = curr.count;
            int distance = curr.distance;

            if (distance != dist[u][count]) {
                continue;
            }

            if (u == n - 1) {
                return distance;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int weight = edge[1];

                int nextCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                if (nextCount > k) {
                    continue;
                }

                int nextDistance = distance + weight;

                if (nextDistance < dist[v][nextCount]) {
                    dist[v][nextCount] = nextDistance;

                    pq.offer(new State(
                        v,
                        nextCount,
                        nextDistance
                    ));
                }
            }
        }

        return -1;
    }
}
