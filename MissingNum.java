/*
268. Missing Number

Given array nums containing numbers from 0 to n,
find the missing number.
*/

public class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        int total = n * (n + 1) / 2;

        int sum = 0;

        // find sum of array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return total - sum;
    }
}
