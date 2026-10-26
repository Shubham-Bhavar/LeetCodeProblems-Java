/**
 * LeetCode 3622: Check Divisibility by Digit Sum and Product
 *
 * Approach:
 * 1. Calculate the sum of the digits of n.
 * 2. Calculate the product of the digits of n.
 * 3. Check whether n is divisible by their sum.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int digitSum = 0;
        int digitProduct = 1;

        while (num > 0) {
            int digit = num % 10;

            digitSum += digit;
            digitProduct *= digit;

            num /= 10;
        }

        return n % (digitSum + digitProduct) == 0;
    }
}
