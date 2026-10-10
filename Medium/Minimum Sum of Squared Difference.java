/*
 * LeetCode 2333: Minimum Sum of Squared Difference
 *
 * Problem:
 * Given two arrays nums1 and nums2, minimize the sum of
 * squared differences between corresponding elements.
 *
 * We can change elements of nums1 at most k1 times and
 * elements of nums2 at most k2 times. Each operation
 * increases or decreases one element by 1.
 *
 * Example 1:
 * Input: nums1 = [1,2,3,4], nums2 = [2,10,20,19],
 *        k1 = 0, k2 = 0
 * Output: 579
 *
 * Example 2:
 * Input: nums1 = [1,4,10,12], nums2 = [5,8,6,9],
 *        k1 = 1, k2 = 1
 * Output: 43
 *
 * Constraints:
 * 1 <= n <= 10^5
 * 0 <= nums1[i], nums2[i] <= 10^5
 * 0 <= k1, k2 <= 10^9
 *
 * Approach:
 * 1. Calculate absolute differences.
 * 2. Combine k1 and k2 into one operation budget.
 * 3. Binary search for the smallest maximum difference
 *    that can be achieved within the operation budget.
 * 4. Reduce differences above that limit and calculate
 *    the sum of their squares.
 *
 * Time Complexity: O(n log M)
 * Space Complexity: O(n)
 * M = maximum absolute difference.
 */

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        int maxDiff = 0;
        long operations = (long) k1 + k2;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // If all differences can be reduced to zero
        long totalDiff = 0;

        for (int d : diff) {
            totalDiff += d;
        }

        if (operations >= totalDiff) {
            return 0;
        }

        // Binary search for the maximum allowed difference
        int left = 0;
        int right = maxDiff;

        while (left < right) {
            int mid = left + (right - left) / 2;

            long required = 0;

            for (int d : diff) {
                if (d > mid) {
                    required += d - mid;
                }
            }

            if (required <= operations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int limit = left;
        long answer = 0;
        long used = 0;

        for (int d : diff) {
            int reduced = Math.min(d, limit);
            answer += (long) reduced * reduced;
            used += d - reduced;
        }

        // Spend remaining operations reducing differences
        // currently equal to the limit by one.
        long remaining = operations - used;

        answer -= remaining * (2L * limit - 1);

        return answer;
    }
}
