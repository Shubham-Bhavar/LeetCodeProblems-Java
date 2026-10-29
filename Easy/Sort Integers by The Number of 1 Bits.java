
/*
 * Problem: 1356. Sort Integers by The Number of 1 Bits
 * Difficulty: Easy
 *
 * Approach:
 * 1. Count the number of set bits in each integer.
 * 2. Sort by bit count in ascending order.
 * 3. If bit counts are equal, sort by integer value.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);

            if (bitsA != bitsB) {
                return bitsA - bitsB;
            }

            return a - b;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }
}
