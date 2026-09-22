/*
    LeetCode 191 - Number of 1 Bits

    Problem:
    --------
    Given a positive integer n, return the number of set bits
    (1s) in its binary representation.

    Example 1:
    Input: n = 11
    Binary: 1011
    Output: 3

    Example 2:
    Input: n = 128
    Binary: 10000000
    Output: 1

    Example 3:
    Input: n = 2147483645
    Binary: 1111111111111111111111111111101
    Output: 30

    Constraints:
    ------------
    1 <= n <= 2^31 - 1
*/

class Solution {

    public int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {

            // Check the last bit
            if ((n & 1) == 1) {
                count++;
            }

            // Move to the next bit
            n = n >>> 1;
        }

        return count;
    }
}
