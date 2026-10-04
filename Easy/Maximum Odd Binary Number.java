/*
 * LeetCode 2864: Maximum Odd Binary Number
 *
 * Problem:
 * You are given a binary string s containing at least one '1'.
 *
 * Rearrange the bits so that the resulting binary number is
 * the maximum odd binary number possible.
 *
 * The resulting string may contain leading zeros.
 *
 * Example 1:
 * Input:  s = "010"
 * Output: "001"
 *
 * Example 2:
 * Input:  s = "0101"
 * Output: "1001"
 *
 * Constraints:
 * 1 <= s.length <= 100
 * s contains only '0' and '1'.
 * s contains at least one '1'.
 *
 * Approach:
 * 1. Count the number of '1's.
 * 2. Keep one '1' at the last position to make the number odd.
 * 3. Put all remaining '1's at the beginning.
 * 4. Put all zeros in the middle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;

        // Count number of 1s
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ones++;
            }
        }

        StringBuilder result = new StringBuilder();

        // Put all remaining 1s at the front
        for (int i = 0; i < ones - 1; i++) {
            result.append('1');
        }

        // Put all zeros in the middle
        for (int i = 0; i < s.length() - ones; i++) {
            result.append('0');
        }

        // Last digit must be 1 to make the number odd
        result.append('1');

        return result.toString();
    }
}
