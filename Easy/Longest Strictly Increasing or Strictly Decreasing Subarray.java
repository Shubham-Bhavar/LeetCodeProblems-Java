
/*
 * LeetCode 3105: Longest Strictly Increasing or Strictly Decreasing Subarray
 *
 * Approach:
 * Track increasing and decreasing subarray lengths.
 * Reset the respective count whenever the condition breaks.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }

            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }

        return maxLen;
    }
}
