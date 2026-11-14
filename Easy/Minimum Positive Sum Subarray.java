
/*
 * LeetCode 3364: Minimum Positive Sum Subarray
 *
 * Problem:
 * Find the minimum positive sum of a subarray
 * whose length is between l and r.
 *
 * Approach:
 * Prefix Sum + Nested Loops
 *
 * Step-by-step Explanation:
 * 1. Create a prefix sum array.
 * 2. Store the cumulative sum of elements.
 * 3. Use two loops to generate subarrays.
 * 4. Calculate the subarray length.
 * 5. Check whether the length is between l and r.
 * 6. Calculate the subarray sum using prefix sum.
 * 7. If the sum is positive, update the minimum.
 * 8. Return -1 if no positive sum is found.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();

        int[] prefix = new int[n + 1];

        // Build prefix sum array.
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int minSum = Integer.MAX_VALUE;

        // Generate all subarrays.
        for (int i = 0; i < n; i++) {

            for (int j = i + l; j <= n && j <= i + r; j++) {

                int sum = prefix[j] - prefix[i];

                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
