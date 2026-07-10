/*
Question:
Given an integer array nums, choose four different indices such that
(a * b) - (c * d) is maximized.
Return the maximum product difference.

Approach:
Take 2 largest numbers and 2 smallest numbers.
*/

import java.util.*;

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return (nums[n-1] * nums[n-2]) - (nums[0] * nums[1]);
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {5,6,2,7,4};
        System.out.println(obj.maxProductDifference(nums)); // 34
    }
}
