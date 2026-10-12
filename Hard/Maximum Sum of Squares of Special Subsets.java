/*
 * LeetCode 2897: Maximum Sum of Squares of Special Subsets
 *
 * Problem:
 * Perform bitwise AND and OR operations on pairs of elements.
 * Choose k elements from the final array to maximize the sum
 * of their squares. Return the answer modulo 10^9 + 7.
 *
 * Example 1:
 * Input:  nums = [2,6,5,8], k = 2
 * Output: 261
 *
 * Example 2:
 * Input:  nums = [4,5,4,7], k = 3
 * Output: 90
 *
 * Constraints:
 * 1 <= k <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * Approach:
 * 1. Count the occurrences of each bit across all numbers.
 * 2. Build k numbers by taking each available bit once per number.
 * 3. Calculate the sum of their squares modulo 10^9 + 7.
 *
 * Time Complexity: O(n * 30 + k * 30)
 * Space Complexity: O(30 + k)
 */

import java.util.*;

class Solution {
    public long maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;

        int[] bitCount = new int[31];

        // Count how many numbers contain each bit
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        long answer = 0;

        // Build the k largest possible numbers
        for (int i = 0; i < k; i++) {
            long value = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    value |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            answer = (answer + value * value % MOD) % MOD;
        }

        return answer;
    }
}
