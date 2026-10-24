/**
 * LeetCode 2091: Removing Minimum and Maximum From Array
 *
 * Approach:
 * 1. Find the indices of the minimum and maximum elements.
 * 2. Calculate deletions from the front, back, and both sides.
 * 3. Return the minimum number of deletions.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = 0, max = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[min]) min = i;
            if (nums[i] > nums[max]) max = i;
        }

        int left = Math.min(min, max);
        int right = Math.max(min, max);

        return Math.min(
            Math.min(right + 1, n - left),
            left + 1 + n - right
        );
    }
}
