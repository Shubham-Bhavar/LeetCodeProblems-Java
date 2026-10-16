/*
LeetCode 763: Partition Labels
Difficulty: Medium
Topics: Greedy, Hash Table, Two Pointers

Problem:
Partition the string into as many parts as possible so that
each character appears in at most one part.
Return the size of each partition.

Approach:
1. Store the last occurrence of every character.
2. Traverse the string and extend the current partition
   until its ending index reaches the farthest last occurrence.
3. Record the partition size and start the next partition.

Time Complexity: O(n)
Space Complexity: O(1), because there are only 26 lowercase letters.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];

        // Store the last index of each character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Extend the partition to include this character's last occurrence
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // Current partition is complete
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
