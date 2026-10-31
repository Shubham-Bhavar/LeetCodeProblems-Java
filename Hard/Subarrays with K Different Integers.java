
/*
 * LeetCode 992: Subarrays with K Different Integers
 *
 * Approach: Sliding Window + HashMap
 *
 * 1. Count subarrays having at most k distinct integers.
 * 2. Count subarrays having at most k - 1 distinct integers.
 * 3. Subtract both counts to get exactly k distinct integers.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {

        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            // Shrink window if distinct count exceeds k
            while (map.size() > k) {

                int value = nums[left];

                map.put(value, map.get(value) - 1);

                if (map.get(value) == 0) {
                    map.remove(value);
                }

                left++;
            }

            // Count all valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}
