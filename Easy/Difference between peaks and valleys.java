
/*
 * LeetCode 4088 - Difference Between Peaks and Valleys
 *
 * Approach:
 * Traverse the array and identify peaks and valleys.
 * Add peak values and subtract valley values.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int peakValleyDifference(int[] nums) {
        int ans = 0;

        // Check elements that have neighbors on both sides
        for (int i = 1; i < nums.length - 1; i++) {

            // A peak is greater than both neighboring elements
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                ans += nums[i];
            }

            // A valley is smaller than both neighboring elements
            else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                ans -= nums[i];
            }
        }

        return ans;
    }
}
