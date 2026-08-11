/*
Question:
Given an integer array nums and an integer pivot,
rearrange nums such that:

1. Elements smaller than pivot come first.
2. Elements equal to pivot come in the middle.
3. Elements greater than pivot come last.
4. Relative order must be maintained.

Example:
Input:  nums = [9,12,5,10,14,3,10], pivot = 10
Output: [9,5,3,10,10,12,14]
*/

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int n = nums.length;
        int[] result = new int[n];
        int index = 0;

        // Add elements smaller than pivot
        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }

        // Add elements equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }

        // Add elements greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }

        return result;
    }
}
