/*
 * Problem: Maximum Good Integer
 *
 * Given:
 * num = required number of digits
 * sum = required sum of digits
 *
 * Find the number with exactly num digits and digit sum sum
 * that maximizes the sum of squared digits.
 * If multiple answers have the same score, return the largest.
 *
 * Approach: Greedy
 * 1. If sum > num * 9, no valid number exists.
 * 2. Place as many 9s as possible from left to right.
 * 3. Place the remaining sum as the next digit.
 * 4. Fill the remaining positions with zeros.
 *
 * Time Complexity: O(num)
 * Space Complexity: O(num) for the result string.
 */

class Solution {
    public String maxGoodNumber(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            result.append(digit);
            sum -= digit;
        }

        return result.toString();
    }
}
