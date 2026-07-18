// Problem: Number of Pairs
// Approach: Count frequency of each number.
// For each count -> pairs = count / 2, leftover = count % 2
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

class Solution {
    public int[] numberOfPairs(int[] nums) {

        // frequency array (0 to 100 range)
        int[] freq = new int[101];

        // count frequency
        for (int num : nums) {
            freq[num]++;
        }

        int pairs = 0;
        int leftover = 0;

        // calculate pairs and leftovers
        for (int count : freq) {
            pairs += count / 2;     // 2 same numbers = 1 pair
            leftover += count % 2;  // remaining single elements
        }

        return new int[]{pairs, leftover};
    }
}
