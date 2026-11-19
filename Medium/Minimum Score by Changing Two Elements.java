
/*
 * LeetCode 2567: Minimum Score by Changing Two Elements
 *
 * Problem Statement:
 * Given an integer array nums, change exactly two elements
 * to minimize the sum of:
 * 1. High Score: Maximum absolute difference.
 * 2. Low Score: Minimum absolute difference.
 *
 * Approach: Sorting + Greedy
 *
 * Step-by-Step Explanation:
 *
 * 1. Sort the array in ascending order.
 *
 * 2. Change two elements to the same value.
 *    This makes the minimum absolute difference equal to 0.
 *
 * 3. To minimize the maximum difference, consider
 *    these three possibilities:
 *
 *    Case 1: Change the two smallest elements.
 *            Difference = nums[n - 3] - nums[0]
 *
 *    Case 2: Change the smallest and largest elements.
 *            Difference = nums[n - 2] - nums[1]
 *
 *    Case 3: Change the two largest elements.
 *            Difference = nums[n - 1] - nums[2]
 *
 * 4. Return the minimum of these three differences.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 *                   (depending on the sorting implementation)
 */

import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Step 2: Calculate all three possibilities
        int case1 = nums[n - 3] - nums[0];

        int case2 = nums[n - 2] - nums[1];

        int case3 = nums[n - 1] - nums[2];

        // Step 3: Return the minimum score
        return Math.min(case1, Math.min(case2, case3));
    }
}
