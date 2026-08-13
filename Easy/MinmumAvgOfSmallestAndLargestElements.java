/*
Question:
Given an even-sized integer array nums, repeatedly remove
the smallest and largest elements.

For every pair, calculate:

(minElement + maxElement) / 2

Return the minimum average.

Example:
Input:  nums = [7,8,3,4,15,13,4,1]
Output: 5.5
*/

import java.util.Arrays;

class Solution {
    public double minimumAverage(int[] nums) {

        // Sort the array
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        double minAverage = Double.MAX_VALUE;

        // Process smallest and largest elements
        while (left < right) {

            double average = (nums[left] + nums[right]) / 2.0;

            // Find minimum average
            minAverage = Math.min(minAverage, average);

            // Move to the next pair
            left++;
            right--;
        }

        return minAverage;
    }
}
