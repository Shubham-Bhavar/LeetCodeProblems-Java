
/*
 * Problem: 3886. Sum of Sortable Integers
 * Difficulty: Hard
 * Topics: Array
 *
 * Approach:
 * 1. Check every divisor k of n.
 * 2. Each group must be sortable using cyclic rotations.
 * 3. The maximum of each group must be <= the minimum
 *    of the next group.
 *
 * Time Complexity: O(n * d), where d is the number of divisors of n.
 * Space Complexity: O(1)
 */

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int previousMax = Integer.MIN_VALUE;

            for (int start = 0; start < n; start += k) {
                int drops = 0;
                int min = nums[start];
                int max = nums[start];

                for (int j = start; j < start + k; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);

                    int next = (j == start + k - 1)
                            ? start : j + 1;

                    if (nums[j] > nums[next]) {
                        drops++;
                    }
                }

                if (drops > 1 || previousMax > min) {
                    valid = false;
                    break;
                }

                previousMax = max;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
