
/*
 * LeetCode 841 - Keys and Rooms
 *
 * Difficulty: Medium
 * Approach: DFS (Depth First Search)
 *
 * Time Complexity: O(n + k)
 * Space Complexity: O(n)
 *
 * n = number of rooms
 * k = total number of keys
 */

import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(0, rooms, visited);

        for (boolean room : visited) {
            if (!room) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;

        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
