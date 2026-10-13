/*
 * LeetCode 1611: Minimum One Bit Operations to Make Integers Zero
 *
 * Approach: Bit Manipulation
 *
 * The minimum operations follow a Gray-code pattern.
 * Convert n to its Gray-code inverse using XOR of
 * n and all its right shifts.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minimumOneBitOperations(int n) {
        int result = 0;

        while (n > 0) {
            result ^= n;
            n >>= 1;
        }

        return result;
    }
}