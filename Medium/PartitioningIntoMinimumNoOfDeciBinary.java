/*
Question:
Given a positive integer n as a string, return the minimum number
of positive deci-binary numbers needed to make their sum equal to n.

A deci-binary number contains only 0 and 1.

Key Idea:
The answer is equal to the maximum digit present in n.

Example:
n = "32"

Maximum digit = 3

Therefore, minimum number of deci-binary numbers = 3.
*/

class Solution {
    public int minPartitions(String n) {

        int maxDigit = 0;

        // Find the maximum digit
        for (int i = 0; i < n.length(); i++) {

            int digit = n.charAt(i) - '0';

            maxDigit = Math.max(maxDigit, digit);
        }

        return maxDigit;
    }
}
