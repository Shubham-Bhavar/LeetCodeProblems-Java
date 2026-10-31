
/*
 * LeetCode 451: Sort Characters By Frequency
 *
 * Approach: HashMap + PriorityQueue (Max Heap)
 *
 * 1. Count the frequency of each character.
 * 2. Store characters in a Max Heap based on frequency.
 * 3. Remove characters from the heap and append each
 *    character according to its frequency.
 *
 * Time Complexity: O(n + k log k)
 * Space Complexity: O(n + k)
 */

import java.util.*;

class Solution {
    public String frequencySort(String s) {

        // Count character frequencies
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Create Max Heap based on frequency
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        pq.addAll(map.keySet());

        StringBuilder result = new StringBuilder();

        // Build the result in decreasing frequency order
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int count = map.get(ch);

            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
