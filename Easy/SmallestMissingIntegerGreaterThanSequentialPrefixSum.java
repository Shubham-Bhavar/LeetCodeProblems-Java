/*
Question:
Given an integer array nums, find the longest sequential prefix.

A prefix is sequential if:
nums[i] = nums[i - 1] + 1

Find the sum of the longest sequential prefix.
Then return the smallest integer greater than or equal to
that sum which is not present in nums.

Example:
Input:  nums = [1,2,3,2,5]
Output: 6
*/

class Solution {
    public int missingInteger(int[] nums) {

        // Find sum of the longest sequential prefix
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Check whether the sequence continues
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Start checking from the prefix sum
        int x = sum;

        // Find the smallest missing integer
        while (true) {
            boolean found = false;

            // Check if x exists in the array
            for (int num : nums) {
                if (num == x) {
                    found = true;
                    break;
                }
            }

            // If x is not present, return it
            if (!found) {
                return x;
            }

            x++;
        }
    }
}
