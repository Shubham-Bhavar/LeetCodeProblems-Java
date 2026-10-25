/**
 * LeetCode 3689: Maximum Total Subarray Value I
 *
 * Approach:
 * The value of a subarray is its maximum element minus its minimum element.
 * Since subarrays can overlap and the same subarray can be chosen multiple
 * times, choose the entire array k times.
 *
 * The entire array has the maximum possible value:
 * max(nums) - min(nums).
 *
 * Therefore, the answer is k * (max(nums) - min(nums)).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return (long) k * (max - min);
    }
}
