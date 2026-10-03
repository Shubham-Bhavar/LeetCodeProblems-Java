/*
 * LeetCode 397: Integer Replacement
 *
 * Approach:
 * - If n is even, divide by 2.
 * - If n is odd:
 *      - n == 3 -> subtract 1
 *      - If the second bit is 0 -> subtract 1
 *      - Otherwise -> add 1
 *
 * Important:
 * Use long because n can be Integer.MAX_VALUE.
 * n + 1 can become 2147483648, which does not fit in int.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int integerReplacement(int n) {
        long num = n;
        int count = 0;

        while (num != 1) {

            if (num % 2 == 0) {
                num /= 2;
            } else {
                if (num == 3) {
                    num--;
                } else if ((num & 2) == 0) {
                    num--;
                } else {
                    num++;
                }
            }

            count++;
        }

        return count;
    }
}
