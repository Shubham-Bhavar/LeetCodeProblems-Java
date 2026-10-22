
/*
 * Problem: Minimum Operations to Sort an Array
 *
 * Approach:
 * 1. Find the index of 0.
 * 2. Check whether nums is a rotation of the ascending
 *    or descending sequence.
 * 3. Calculate the minimum operations for valid cases.
 * 4. Return -1 if sorting is impossible.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = 0;

        // Find the position of 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        boolean ascending = true;
        boolean descending = true;

        // Check both possible array patterns
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i - zero + n) % n) {
                ascending = false;
            }

            if (nums[i] != (zero - i + n) % n) {
                descending = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        // Minimum operations for ascending pattern
        if (ascending) {
            ans = Math.min(zero, n - zero + 2);
        }

        // Minimum operations for descending pattern
        if (descending) {
            ans = Math.min(ans, Math.min(n - zero, zero + 2));
        }

        // Return -1 if sorting is impossible
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
