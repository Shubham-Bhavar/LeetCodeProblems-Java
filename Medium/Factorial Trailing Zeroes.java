/*
 * LeetCode: 172. Factorial Trailing Zeroes
 *
 * Problem:
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * A trailing zero is created by the factor:
 *     10 = 2 × 5
 *
 * In factorials, there are always more factors of 2 than factors
 * of 5. Therefore, the number of trailing zeroes depends on the
 * number of factors of 5.
 *
 * Example 1:
 * Input:  n = 3
 * Output: 0
 *
 * Example 2:
 * Input:  n = 5
 * Output: 1
 *
 * Explanation:
 * 5! = 120 → one trailing zero.
 *
 * Example 3:
 * Input:  n = 0
 * Output: 0
 *
 * ---------------------------------------------------------
 * Approach:
 * ---------------------------------------------------------
 *
 * Count how many multiples of:
 *
 *     5
 *     25
 *     125
 *     625
 *     ...
 *
 * are present in n!.
 *
 * Formula:
 *
 *     n / 5 + n / 25 + n / 125 + ...
 *
 * until 5^k > n.
 *
 * Example:
 *
 * n = 25
 *
 * 25 / 5  = 5
 * 25 / 25 = 1
 *
 * Total = 6 trailing zeroes.
 *
 * Time Complexity: O(log₅ n)
 * Space Complexity: O(1)
 */

class Solution {

    public int trailingZeroes(int n) {

        int count = 0;

        while (n > 0) {

            n = n / 5;

            count += n;
        }

        return count;
    }
}
