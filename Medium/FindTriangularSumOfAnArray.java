/*
PROBLEM: Triangular Sum of an Array

Given an integer array nums, return the triangular sum.

Process:
- Create a new array where each element is (nums[i] + nums[i+1]) % 10
- Replace nums with new array
- Repeat until only one element remains

Return that element.

Example:
Input: [1,2,3,4,5]
Output: 8
*/

class Solution {

    public int triangularSum(int[] nums) {

        int n = nums.length;

        // Reduce array size step by step
        for (int size = n; size > 1; size--) {

            // Update values using adjacent sum
            for (int i = 0; i < size - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }

        // Final remaining element
        return nums[0];
    }
}
