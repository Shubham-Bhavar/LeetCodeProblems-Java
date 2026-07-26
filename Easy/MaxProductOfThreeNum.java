/**
 * Problem: Maximum Product of Three Numbers
 * Approach: Sorting
 *
 * Steps:
 * 1. Sort the array
 * 2. Compute:
 *    - product of last 3 elements
 *    - product of first 2 and last 1
 * 3. Return max of both
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) (ignoring sorting space)
 */

import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int option1 = nums[n-1] * nums[n-2] * nums[n-3];
        int option2 = nums[0] * nums[1] * nums[n-1];

        return Math.max(option1, option2);
    }
}
