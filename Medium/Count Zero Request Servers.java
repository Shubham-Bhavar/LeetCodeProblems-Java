
/*
 * Problem: 2747. Count Zero Request Servers
 * Difficulty: Medium
 * Approach: Sorting + Sliding Window
 * Time Complexity: O((L + Q) log(L + Q))
 * Space Complexity: O(L + Q + N)
 */

import java.util.*;

class Solution {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        int[] answer = new int[queries.length];
        int[] count = new int[n + 1];

        int left = 0;
        int right = 0;
        int activeServers = 0;

        for (int[] query : sortedQueries) {

            int time = query[0];
            int start = time - x;

            // Add logs within the current time window
            while (right < logs.length && logs[right][1] <= time) {

                int server = logs[right][0];

                if (count[server] == 0) {
                    activeServers++;
                }

                count[server]++;
                right++;
            }

            // Remove logs outside the current window
            while (left < right && logs[left][1] < start) {

                int server = logs[left][0];

                count[server]--;

                if (count[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            answer[query[1]] = n - activeServers;
        }

        return answer;
    }
}
