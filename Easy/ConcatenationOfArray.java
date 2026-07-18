/*
Question:
Given an integer array nums,
create an array ans of length 2*n
where ans contains nums twice.

Example:
Input: [1,2,1]
Output: [1,2,1,1,2,1]
*/

class Solution {
    public int[] getConcatenation(int[] nums) {

        // Original array length
        int n = nums.length;

        // New array of size 2*n
        int[] ans = new int[2 * n];

        // Copy elements twice
        for (int i = 0; i < n; i++) {

            // First copy
            ans[i] = nums[i];

            // Second copy
            ans[i + n] = nums[i];
        }

        return ans;
    }
}
