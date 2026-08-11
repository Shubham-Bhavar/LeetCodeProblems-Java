/*
Question:
Given an integer n, form a new integer x by removing all
zero digits while maintaining the original order.

Find the sum of all non-zero digits.

Return x * sum.

Example:
Input:  n = 10203004
Output: 12340

Explanation:
Non-zero digits = 1, 2, 3, 4
x = 1234
sum = 1 + 2 + 3 + 4 = 10
Answer = 1234 * 10 = 12340
*/

class Solution {
    public long sumAndMultiply(int n) {

        int num = 0;
        int sum = 0;
        int place = 1;

        while (n > 0) {

            // Extract the last digit
            int digit = n % 10;

            // Remove the last digit
            n /= 10;

            // Ignore zero digits
            if (digit == 0) {
                continue;
            }

            // Build the number using place value
            num = num + digit * place;
            place = place * 10;

            // Add digit to sum
            sum += digit;
        }

        return (long) num * sum;
    }
}
