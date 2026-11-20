
/*
 * LeetCode 3041: Maximize Consecutive Elements in an Array After Modification
 *
 * Problem Statement:
 * Given an array nums, we can increase any element by at most 1.
 * Select the maximum number of elements such that their final
 * values are consecutive after sorting.
 *
 * Approach: Sorting + Dynamic Programming
 *
 * Step-by-Step Explanation:
 *
 * 1. Sort the array in ascending order.
 *
 * 2. Create a DP array to store the maximum sequence length
 *    ending at each possible value.
 *
 * 3. For every number, consider two choices:
 *
 *    Choice 1: Keep num unchanged.
 *    Update dp[num] using dp[num - 1] + 1.
 *
 *    Choice 2: Increase num by 1.
 *    Update dp[num + 1] using dp[num] + 1.
 *
 * 4. Update the states using previous values so that
 *    the same element is not used twice.
 *
 * 5. Find and return the maximum DP value.
 *
 * Time Complexity: O(n log n + M)
 * Space Complexity: O(M)
 *
 * M = Maximum element in nums.
 */

import java.util.Arrays;

class Solution {

    public int maxSelectedElements(int[] nums) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Create DP array
        int max = nums[nums.length - 1];

        int[] dp = new int[max + 2];

        int ans = 0;

        // Step 3: Process each element
        for (int num : nums) {

            // Choice 1: Increase num by 1
            dp[num + 1] = Math.max(
                dp[num + 1],
                dp[num] + 1
            );

            // Choice 2: Keep num unchanged
            dp[num] = Math.max(
                dp[num],
                dp[num - 1] + 1
            );

            // Update answer
            ans = Math.max(ans, Math.max(dp[num], dp[num + 1]));
        }

        return ans;
    }
}
