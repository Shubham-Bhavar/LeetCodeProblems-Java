/*
 * LeetCode 413: Arithmetic Slices
 *
 * Problem:
 * Given an integer array nums, return the number of arithmetic
 * subarrays containing at least 3 elements.
 *
 * An arithmetic subarray has the same difference between
 * every two consecutive elements.
 *
 * Example 1:
 * Input:  nums = [1,2,3,4]
 * Output: 3
 *
 * Explanation:
 * [1,2,3]
 * [2,3,4]
 * [1,2,3,4]
 *
 * Example 2:
 * Input:  nums = [1]
 * Output: 0
 *
 * Approach:
 * Let dp represent the number of arithmetic slices ending
 * at the current index.
 *
 * If:
 * nums[i] - nums[i-1] == nums[i-1] - nums[i-2]
 *
 * then the current element extends all previous arithmetic
 * slices and also creates one new slice of length 3.
 *
 * Therefore:
 * dp = dp + 1
 *
 * Otherwise, reset dp to 0.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int dp = 0;

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] - nums[i - 1] ==
                nums[i - 1] - nums[i - 2]) {

                dp++;
                count += dp;

            } else {
                dp = 0;
            }
        }

        return count;
    }
}
