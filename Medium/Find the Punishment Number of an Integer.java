/*
 * ============================================================
 * LeetCode 2698: Find the Punishment Number of an Integer
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * Given a positive integer n, find its punishment number.
 *
 * For every i from 1 to n:
 *
 * 1. Calculate i * i.
 * 2. Convert it to a string.
 * 3. Partition the string into contiguous parts.
 * 4. If the sum of those parts equals i, then i is valid.
 * 5. Add i * i to the answer.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * n = 10
 *
 * Output:
 * 182
 *
 * Valid numbers:
 *
 * 1  -> 1 * 1 = 1
 * 9  -> 9 * 9 = 81  -> 8 + 1 = 9
 * 10 -> 10 * 10 = 100 -> 10 + 0 = 10
 *
 * Answer:
 *
 * 1 + 81 + 100 = 182
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * n = 37
 *
 * Output:
 * 1478
 *
 * Valid numbers:
 *
 * 1  -> 1
 * 9  -> 81  -> 8 + 1
 * 10 -> 100 -> 10 + 0
 * 36 -> 1296 -> 1 + 29 + 6
 *
 * Answer:
 *
 * 1 + 81 + 100 + 1296 = 1478
 *
 * ------------------------------------------------------------
 * Constraints:
 * ------------------------------------------------------------
 *
 * 1 <= n <= 1000
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * For every number i:
 *
 *     square = i * i
 *
 * We need to check whether the digits of square can be
 * divided into parts whose sum equals i.
 *
 * Example:
 *
 *     i = 36
 *     square = 1296
 *
 * Possible partition:
 *
 *     1 + 29 + 6 = 36
 *
 * We use recursion to try every possible substring.
 *
 * At every position, we:
 *
 * 1. Take one digit.
 * 2. Take two digits.
 * 3. Take three digits...
 *
 * and check whether the remaining digits can produce the
 * required sum.
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * n <= 1000, so the number of digits in i*i is small.
 *
 * Time Complexity: O(n * 2^d)
 *
 * where d is the number of digits in i*i.
 *
 * Space Complexity: O(d)
 *
 * for recursion.
 *
 * ============================================================
 */

class Solution {

    public int punishmentNumber(int n) {

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            int square = i * i;

            if (canPartition(String.valueOf(square), i, 0)) {
                answer += square;
            }
        }

        return answer;
    }

    /*
     * Check whether the square string can be partitioned
     * so that the sum of all parts equals target.
     */
    private boolean canPartition(String s, int target, int index) {

        // All digits have been used
        if (index == s.length()) {
            return target == 0;
        }

        int number = 0;

        // Try every possible next substring
        for (int i = index; i < s.length(); i++) {

            number = number * 10 + (s.charAt(i) - '0');

            // This part is already larger than target
            if (number > target) {
                break;
            }

            // Recursively check the remaining digits
            if (canPartition(s, target - number, i + 1)) {
                return true;
            }
        }

        return false;
    }
}
