/*Given a 0-indexed array nums, build a new array ans such that:

ans[i] = nums[nums[i]]

Return ans.*/
class Solution {
    public int[] buildArray(int[] nums) {

        // Create answer array
        int[] ans = new int[nums.length];

        // Build array using given formula
        for (int i = 0; i < nums.length; i++) {

            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}
