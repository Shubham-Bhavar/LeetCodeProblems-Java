/*
    LeetCode 7 - Reverse Integer

    Problem:
    --------
    Given a signed 32-bit integer x, return x with its digits reversed.

    If reversing x causes the value to go outside the signed 32-bit
    integer range [-2^31, 2^31 - 1], return 0.

    The solution must not use 64-bit integers.

    Example 1:
    Input: 123
    Output: 321

    Example 2:
    Input: -123
    Output: -321

    Example 3:
    Input: 120
    Output: 21

    Approach:
    ---------
    1. Extract the last digit using % 10.
    2. Remove the last digit using / 10.
    3. Before adding the digit to reversed, check for overflow.
    4. Add the digit to reversed.

    Time Complexity: O(log10(x))
    Space Complexity: O(1)
*/

class Solution {
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            // Check positive overflow
            if (reversed > Integer.MAX_VALUE / 10 ||
                (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check negative overflow
            if (reversed < Integer.MIN_VALUE / 10 ||
                (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }
}
