/*
Question:
For each index i, find:
leftSum = sum of elements before i
rightSum = sum of elements after i

Return array where:
answer[i] = |leftSum - rightSum|
*/

import java.util.*;

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int totalSum = 0;

        // total sum of array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum -= nums[i]; // now this is rightSum
            ans[i] = Math.abs(leftSum - totalSum); // difference
            leftSum += nums[i]; // update leftSum
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums = {10,4,8,3};
        System.out.println(Arrays.toString(obj.leftRightDifference(nums)));
        // Output: [15,1,11,22]
    }
}
