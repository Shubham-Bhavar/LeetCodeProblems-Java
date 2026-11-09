
/*
 * LeetCode 1606: Find Servers That Handled Most Number of Requests
 *
 * Approach: TreeSet + PriorityQueue
 * Time Complexity: O(n log k)
 * Space Complexity: O(k)
 */

import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        // Initially, all servers are available.
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Stores {finishTime, serverId}.
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];
        int maxRequests = 0;

        for (int i = 0; i < arrival.length; i++) {

            // Release all servers whose requests have finished.
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] server = busy.poll();
                available.add(server[1]);
            }

            if (available.isEmpty()) {
                continue;
            }

            // Find the next available server starting from i % k.
            int start = i % k;

            Integer server = available.ceiling(start);

            // Wrap around if no server is available after start.
            if (server == null) {
                server = available.first();
            }

            available.remove(server);

            // Assign the request to this server.
            count[server]++;
            maxRequests = Math.max(maxRequests, count[server]);

            // Add server to the busy queue.
            busy.offer(new int[]{
                arrival[i] + load[i],
                server
            });
        }

        // Collect all servers with the maximum request count.
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}
