/**
 * Find the Smallest Stable Index
 *
 * Approach:
 * 1. Calculate suffix minimums from right to left.
 * 2. Traverse left to right while maintaining the prefix maximum.
 * 3. Return the first index where max - min <= k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int stableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = nums[0];

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
