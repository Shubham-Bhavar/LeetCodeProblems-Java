
/*
 * LeetCode 3843: First Element with Unique Frequency
 *
 * Problem Statement:
 * Given an integer array nums, return the first element
 * from left to right whose frequency is unique.
 *
 * If no such element exists, return -1.
 *
 * Approach: Two HashMaps
 *
 * Step-by-Step Explanation:
 *
 * 1. Create a HashMap to count the frequency of each number.
 *
 * 2. Create another HashMap to count how many numbers
 *    have the same frequency.
 *
 * 3. Traverse the array from left to right.
 *
 * 4. Check whether the frequency of the current number
 *    occurs exactly once.
 *
 * 5. If yes, return that number.
 *
 * 6. If no element has a unique frequency, return -1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int firstUniqueFreq(int[] nums) {

        // Step 1: Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Count how many numbers have each frequency
        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int count : freq.values()) {
            freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
        }

        // Step 3: Find the first element with unique frequency
        for (int num : nums) {

            int count = freq.get(num);

            if (freqCount.get(count) == 1) {
                return num;
            }
        }

        // No element has a unique frequency
        return -1;
    }
}
