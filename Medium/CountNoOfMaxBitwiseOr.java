/*Q) Given an integer array nums, find the maximum possible bitwise OR of any subset.

Return the number of different non-empty subsets whose bitwise OR equals this maximum value.*/

class Solution {
    int count = 0;
    int maxOR = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            maxOR |= num;
        }
        backtrack(nums, 0, 0);
        return count;
    }

    void backtrack(int[] nums, int index, int currentOR) {
        if (index == nums.length) {
            if (currentOR == maxOR) count++;
            return;
        }

        backtrack(nums, index + 1, currentOR | nums[index]);
        backtrack(nums, index + 1, currentOR);
    }
}
