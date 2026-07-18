/*
Question:
Given an array nums, in one operation you can increment any element by 1.
Return minimum operations required to make array strictly increasing.
*/

class Solution {
    public int minOperations(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int needed = nums[i - 1] - nums[i] + 1;
                nums[i] += needed;
                count += needed;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums = {1,1,1};
        System.out.println(obj.minOperations(nums)); // 3
    }
}
