
/*
 * LeetCode 213: House Robber II
 *
 * Problem:
 * Given an array of houses arranged in a circle,
 * find the maximum money that can be robbed without
 * robbing two adjacent houses.
 *
 * Approach: Dynamic Programming + Space Optimization
 *
 * Explanation:
 * 1. Since houses are arranged in a circle, the first
 *    and last houses are adjacent.
 *
 * 2. We cannot rob both the first and last houses.
 *
 * 3. Divide the problem into two cases:
 *    Case 1: Rob houses from index 0 to n - 2.
 *            Exclude the last house.
 *
 *    Case 2: Rob houses from index 1 to n - 1.
 *            Exclude the first house.
 *
 * 4. For each case, apply normal House Robber DP:
 *    - prev1 stores the maximum money up to the
 *      previous house.
 *    - prev2 stores the maximum money up to the
 *      house before the previous one.
 *
 * 5. At every house, choose between:
 *    - Skipping the current house.
 *    - Robbing the current house.
 *
 * 6. Return the maximum result from both cases.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int case1 = robRange(nums, 0, n - 2);

        int case2 = robRange(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robRange(int[] nums, int start, int end) {

        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {

            int take = nums[i] + prev2;

            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
