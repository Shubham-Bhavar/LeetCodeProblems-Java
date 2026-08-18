/*
Question:
Given a positive integer n, remove all zeros from its
decimal representation and return the resulting integer.

Example:
Input: 1020030
Output: 123

Explanation:
1020030 -> 123
*/

class Solution {
    public long removeZeros(long n) {
        long result = 0;
        long place = 1;

        while (n > 0) {
            long digit = n % 10;

            if (digit != 0) {
                result = digit * place + result;
                place *= 10;
            }

            n /= 10;
        }

        return result;
    }
}
