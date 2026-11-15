
/*
 * LeetCode 201: Bitwise AND of Numbers Range
 *
 * Problem:
 * Given two integers left and right, return the bitwise
 * AND of all numbers in the inclusive range [left, right].
 *
 * Approach: Common Prefix using Bit Manipulation
 *
 * Explanation:
 * 1. Initialize shift = 0.
 * 2. Right-shift left and right until both become equal.
 * 3. Each right shift removes one bit from the right.
 * 4. The remaining equal bits represent the common
 *    binary prefix of all numbers in the range.
 * 5. Left-shift the common prefix by shift positions
 *    to restore the removed trailing zeros.
 * 6. Return the result.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        int shift = 0;

        while (left != right) {

            left >>= 1;
            right >>= 1;

            shift++;
        }

        return left << shift;
    }
}
