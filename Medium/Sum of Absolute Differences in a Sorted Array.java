
/*
 * LeetCode 1685: Sum of Absolute Differences in a Sorted Array
 *
 * Problem:
 * Find the sum of absolute differences between each element
 * and all other elements.
 *
 * Approach:
 * Use prefix sum to calculate left and right differences.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int total = 0;
        for (int num : nums)
            total += num;

        int prefix = 0;

        for (int i = 0; i < n; i++) {

            int left = nums[i] * i - prefix;

            int right = (total - prefix - nums[i])
                      - nums[i] * (n - i - 1);

            ans[i] = left + right;

            prefix += nums[i];
        }

        return ans;
    }
}
