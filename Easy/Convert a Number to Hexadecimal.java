/*
 * LeetCode 405: Convert a Number to Hexadecimal
 *
 * Problem:
 * Given a 32-bit integer num, return its hexadecimal representation.
 *
 * For negative numbers, use the two's complement representation.
 *
 * The hexadecimal result:
 * - Must contain lowercase letters.
 * - Must not contain leading zeros.
 * - "0" should be returned for num = 0.
 *
 * Example 1:
 * Input:  num = 26
 * Output: "1a"
 *
 * Example 2:
 * Input:  num = -1
 * Output: "ffffffff"
 *
 * Constraints:
 * -2^31 <= num <= 2^31 - 1
 *
 * Approach:
 * 1. Store hexadecimal characters in an array.
 * 2. Get the last 4 bits using num & 15.
 * 3. Convert those 4 bits into a hexadecimal character.
 * 4. Shift the number right by 4 bits using >>>.
 * 5. Reverse the result because digits are generated from right to left.
 *
 * Why use >>>?
 * The unsigned right shift >>> is important for negative numbers.
 * It treats the integer as a 32-bit two's complement value and
 * eventually removes all bits after 8 hexadecimal digits.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {

    public String toHex(int num) {

        // Special case
        if (num == 0) {
            return "0";
        }

        // Hexadecimal characters
        char[] hex = "0123456789abcdef".toCharArray();

        StringBuilder result = new StringBuilder();

        while (num != 0) {

            // Get the last 4 bits
            int digit = num & 15;

            // Convert to hexadecimal character
            result.append(hex[digit]);

            // Unsigned right shift by 4 bits
            num >>>= 4;
        }

        // Digits are generated in reverse order
        return result.reverse().toString();
    }
}
