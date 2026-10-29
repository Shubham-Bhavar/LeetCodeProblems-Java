
/*
 * Problem: 1817. Finding the Users Active Minutes
 * Difficulty: Medium
 * Language: Java
 *
 * Approach:
 * 1. Store unique active minutes for each user using HashSet.
 * 2. Count each user's unique active minutes.
 * 3. Update the answer array based on each user's UAM.
 *
 * Time Complexity: O(n + k)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> users = new HashMap<>();

        for (int[] log : logs) {
            users.computeIfAbsent(log[0], x -> new HashSet<>())
                 .add(log[1]);
        }

        int[] answer = new int[k];

        for (Set<Integer> minutes : users.values()) {
            int uam = minutes.size();
            answer[uam - 1]++;
        }

        return answer;
    }
}
