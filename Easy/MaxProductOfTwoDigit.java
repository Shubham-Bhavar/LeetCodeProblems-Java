/**
 * Problem: Maximum Product of Two Digits
 * Platform: LeetCode
 *
 * Description:
 * Given an integer n, return the maximum product of any two digits.
 *
 * Approach:
 * - Extract digits using modulo (% 10)
 * - Track the two largest digits
 * - Return their product
 *
 * Time Complexity: O(d)  (d = number of digits, max 10)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxProduct(int n) {
        int max1 = 0, max2 = 0;

        while (n > 0) {
            int digit = n % 10;

            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }

            n /= 10;
        }

        return max1 * max2;
    }
}
