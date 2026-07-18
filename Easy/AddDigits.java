/*
Question:
Given an integer num, repeatedly add all its digits
until the result has only one digit, and return it.

Example:
38 -> 3 + 8 = 11
11 -> 1 + 1 = 2
Output: 2
*/

class Solution {
    public int addDigits(int num) {

        // If number is 0, return 0
        if (num == 0) {
            return 0;
        }

        // Digital Root Formula (O(1))
        return 1 + (num - 1) % 9;
    }
}
