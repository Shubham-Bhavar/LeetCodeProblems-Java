/*
Question:
You are given an integer array nums and an integer k.
You can perform an operation where you choose an index i
and decrease nums[i] by 1.

Return the minimum number of operations required
to make the sum of the array divisible by k.
*/

class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;

        // calculate total sum
        for (int num : nums) {
            sum += num;
        }

        // remainder = minimum operations needed
        return sum % k;
    }
}
