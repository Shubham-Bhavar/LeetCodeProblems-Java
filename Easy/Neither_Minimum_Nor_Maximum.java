/*
Question:
Given an array of distinct positive integers, return any number
which is neither the minimum nor the maximum value.

If no such number exists, return -1.

Example:
Input:  [3, 2, 1, 4]
Output: 2
*/

class Solution {
    public int findNonMinOrMax(int[] nums) {

        // If there are only 1 or 2 elements,
        // every element is either minimum or maximum.
        if (nums.length < 3) {
            return -1;
        }

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Return any element that is neither min nor max
        for (int num : nums) {
            if (num != min && num != max) {
                return num;
            }
        }

        return -1;
    }
}
