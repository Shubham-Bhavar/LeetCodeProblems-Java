
/*
 * LeetCode 3420: Count Non-Decreasing Subarrays After K Operations
 *
 * Problem:
 * Count the number of subarrays that can be made
 * non-decreasing using at most k increment operations.
 *
 * Approach:
 * Sliding Window + Monotonic Deque
 *
 * Explanation:
 * 1. Traverse the array from right to left.
 * 2. Use a deque to maintain values in non-increasing order.
 * 3. Merge smaller values when a larger value is added.
 * 4. Calculate the minimum operations required.
 * 5. If operations exceed k, shrink the window
 *    from the right side.
 * 6. Count valid subarrays using (j - i + 1).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        long ans = 0;
        long cost = 0;

        int j = n - 1;

        // Store value and count in the deque.
        Deque<int[]> dq = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Merge smaller values into the current value.
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] last = dq.pollLast();

                int nextNum = last[0];
                int nextCount = last[1];

                count += nextCount;

                cost += (long) (num - nextNum) * nextCount;
            }

            // Add current value and its count.
            dq.offerLast(new int[]{num, count});

            // Shrink window if operations exceed k.
            while (cost > k) {

                int[] first = dq.pollFirst();

                int rightmostNum = first[0];
                int rightmostCount = first[1];

                cost -= rightmostNum - nums[j];

                j--;

                // Restore remaining elements.
                if (rightmostCount > 1) {
                    dq.offerFirst(
                        new int[]{rightmostNum, rightmostCount - 1}
                    );
                }
            }

            // Count valid subarrays.
            ans += j - i + 1;
        }

        return ans;
    }
}
