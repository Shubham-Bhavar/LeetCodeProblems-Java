
/*
 * LeetCode 3041: Maximize Consecutive Elements in an Array After Modification
 *
 * Problem Statement:
 * Increase each element by at most 1 and select the maximum
 * number of elements that form consecutive integers after sorting.
 *
 * Approach: Sorting + Dynamic Programming
 *
 * Step-by-Step Explanation:
 *
 * 1. Sort the array.
 *
 * 2. Use two DP states:
 *    dp1 = Longest consecutive sequence ending at nums[i].
 *    dp2 = Longest consecutive sequence ending at nums[i] + 1.
 *
 * 3. For each number:
 *    - Keep it unchanged.
 *    - Increase it by 1.
 *
 * 4. Update the DP states using previous values.
 *
 * 5. Track the maximum answer.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space
 */

import java.util.Arrays;

class Solution {

    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        int dp1 = 0;
        int dp2 = 0;

        int prev = -1;
        int ans = 0;

        for (int num : nums) {

            int newDp1 = 1;
            int newDp2 = 1;

            if (num == prev) {

                newDp1 = dp1;
                newDp2 = dp1 + 1;

            } else if (num == prev + 1) {

                newDp1 = dp2 + 1;
                newDp2 = dp1 + 1;
            }

            dp1 = newDp1;
            dp2 = newDp2;

            prev = num;

            ans = Math.max(ans, Math.max(dp1, dp2));
        }

        return ans;
    }
}
