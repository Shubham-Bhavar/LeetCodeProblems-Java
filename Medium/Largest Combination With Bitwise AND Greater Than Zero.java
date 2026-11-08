
/*
 * LeetCode 2275. Largest Combination With Bitwise AND Greater Than Zero
 *
 * Problem:
 * Find the largest combination of numbers whose bitwise AND is greater than zero.
 *
 * Approach:
 * 1. Check each bit position from 0 to 23.
 * 2. Count numbers having that bit set.
 * 3. Return the maximum count.
 *
 * Time Complexity: O(24 * n) = O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int largestCombination(int[] candidates) {
        int maxCount = 0;

        // Check all 24 possible bit positions
        for (int bit = 0; bit < 24; bit++) {
            int count = 0;

            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
