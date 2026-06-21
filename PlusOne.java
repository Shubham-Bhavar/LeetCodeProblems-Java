/*
LeetCode 66 - Plus One

Given an integer array digits representing a large integer,
increment the integer by one and return the resulting array.
*/

class Solution {
    public int[] plusOne(int[] digits) {

        // Start from the last digit
        for (int i = digits.length - 1; i >= 0; i--) {

            // If digit is less than 9, increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If digit is 9, set it to 0 (carry)
            digits[i] = 0;
        }

        // All digits were 9, create a new array
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}
