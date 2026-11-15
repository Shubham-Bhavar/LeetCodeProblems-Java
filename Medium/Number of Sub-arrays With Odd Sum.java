
/*
 * LeetCode 1524: Number of Sub-arrays With Odd Sum
 *
 * Problem:
 * Count the number of subarrays having an odd sum.
 * Return the answer modulo 10^9 + 7.
 *
 * Approach: Prefix Sum + Parity Counting
 *
 * Explanation:
 * 1. Maintain evenCount and oddCount.
 * 2. Initially, evenCount = 1 because the empty prefix
 *    has an even sum (0).
 * 3. If the current prefix sum is odd:
 *    - Add evenCount to the result.
 *    - Increment oddCount.
 * 4. If the current prefix sum is even:
 *    - Add oddCount to the result.
 *    - Increment evenCount.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int numOfSubarrays(int[] arr) {

        final int MOD = 1_000_000_007;

        int evenCount = 1;
        int oddCount = 0;

        long result = 0;
        int prefixSum = 0;

        for (int num : arr) {

            prefixSum += num;

            if (prefixSum % 2 == 1) {
                result += evenCount;
                oddCount++;
            } else {
                result += oddCount;
                evenCount++;
            }

            result %= MOD;
        }

        return (int) result;
    }
}
