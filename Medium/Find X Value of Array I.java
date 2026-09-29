/*
 * ============================================================
 * LeetCode: Find the Number of Ways to Make the Product
 *           of the Remaining Elements Have Each Remainder
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * You are given an array of positive integers nums and a
 * positive integer k.
 *
 * You can remove a prefix and a suffix from nums, as long as
 * the remaining array is non-empty.
 *
 * Every possible remaining array is a contiguous subarray.
 *
 * For every x from 0 to k - 1, find how many possible remaining
 * subarrays have a product whose remainder modulo k is x.
 *
 * Return an array result of size k.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * nums = [1,2,3,4,5]
 * k = 3
 *
 * Output:
 * [9,2,4]
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * nums = [1,2,4,8,16,32]
 * k = 4
 *
 * Output:
 * [18,1,2,0]
 *
 * ------------------------------------------------------------
 * Example 3:
 * ------------------------------------------------------------
 *
 * Input:
 * nums = [1,1,2,1,1]
 * k = 2
 *
 * Output:
 * [9,6]
 *
 * ------------------------------------------------------------
 * Constraints:
 * ------------------------------------------------------------
 *
 * 1 <= nums[i] <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= k <= 5
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * Removing a prefix and suffix leaves a NON-EMPTY CONTIGUOUS
 * SUBARRAY.
 *
 * So the problem becomes:
 *
 * Count the product modulo k for every possible subarray.
 *
 * Since k <= 5, there are only k possible remainders:
 *
 * 0, 1, 2, ..., k - 1
 *
 * We maintain:
 *
 * dp[r] = number of subarrays ending at the previous position
 *         whose product % k == r
 *
 * For every new number:
 *
 * 1. Start a new subarray containing only nums[i].
 *
 * 2. Extend every previous subarray by nums[i].
 *
 * If previous product % k = r:
 *
 * new remainder = (r * (nums[i] % k)) % k
 *
 * ------------------------------------------------------------
 * Example:
 * ------------------------------------------------------------
 *
 * nums = [1, 2, 3], k = 3
 *
 * For 1:
 *
 * [1] -> remainder 1
 *
 * For 2:
 *
 * [2] -> remainder 2
 * [1,2] -> remainder 2
 *
 * For 3:
 *
 * [3] -> remainder 0
 * [2,3] -> remainder 0
 * [1,2,3] -> remainder 0
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * There are k states for every element.
 *
 * Time Complexity:
 * O(n * k)
 *
 * Since k <= 5, this is effectively O(n).
 *
 * Space Complexity:
 * O(k)
 *
 * ============================================================
 */

class Solution {

    public long[] countSubarrays(int[] nums, int k) {

        /*
         * dp[r] = number of subarrays ending at the current
         * position having product % k == r.
         */
        long[] dp = new long[k];

        /*
         * Answer for every possible remainder.
         */
        long[] result = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            int value = num % k;

            /*
             * Start a new subarray containing only num.
             */
            next[value]++;

            /*
             * Extend all previous subarrays by num.
             */
            for (int remainder = 0; remainder < k; remainder++) {

                if (dp[remainder] > 0) {

                    int newRemainder =
                            (remainder * value) % k;

                    next[newRemainder] += dp[remainder];
                }
            }

            /*
             * All subarrays ending here contribute
             * to the final answer.
             */
            for (int remainder = 0; remainder < k; remainder++) {
                result[remainder] += next[remainder];
            }

            /*
             * Move to the next position.
             */
            dp = next;
        }

        return result;
    }
}
