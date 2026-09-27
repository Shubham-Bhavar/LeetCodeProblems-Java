/*
 * LeetCode 198: House Robber
 *
 * Problem:
 * You are a professional robber planning to rob houses along a street.
 * Each house contains a certain amount of money.
 *
 * The only restriction is:
 * You cannot rob two adjacent houses because the security systems
 * will alert the police.
 *
 * Given an integer array nums where nums[i] represents the money
 * in the i-th house, return the maximum amount of money you can rob
 * without robbing two adjacent houses.
 *
 * Example 1:
 * Input:  nums = [1,2,3,1]
 * Output: 4
 *
 * Explanation:
 * Rob house 1 and house 3:
 * 1 + 3 = 4
 *
 * Example 2:
 * Input:  nums = [2,7,9,3,1]
 * Output: 12
 *
 * Explanation:
 * Rob house 1, house 3 and house 5:
 * 2 + 9 + 1 = 12
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */

class Solution {

    public int rob(int[] nums) {

        // prev2 = maximum money from houses before previous house
        int prev2 = 0;

        // prev1 = maximum money from houses up to previous house
        int prev1 = 0;

        for (int money : nums) {

            // Option 1: Skip current house
            int skip = prev1;

            // Option 2: Rob current house
            // We can add it only to prev2 because
            // the previous house cannot be robbed.
            int rob = prev2 + money;

            // Take the better option
            int current = Math.max(skip, rob);

            // Move forward
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
