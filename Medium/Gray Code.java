/*
    LeetCode 89 - Gray Code

    Problem:
    --------
    Given an integer n, return any valid n-bit Gray code sequence.

    A Gray code sequence:
    - Contains 2^n integers.
    - Starts with 0.
    - Contains every number from 0 to 2^n - 1 exactly once.
    - Adjacent numbers differ by exactly one bit.
    - The first and last numbers also differ by exactly one bit.

    Example 1:
    Input:
    n = 2

    Output:
    [0, 1, 3, 2]

    Binary:
    00 -> 01 -> 11 -> 10

    Example 2:
    Input:
    n = 1

    Output:
    [0, 1]

    Approach:
    ---------
    The Gray Code for an integer i can be generated using:

        i ^ (i >> 1)

    where:
    - ^  = XOR
    - >> = right shift

    For n bits, there are 2^n numbers.

    Generate Gray Code for every i from 0 to 2^n - 1.

    Time Complexity:
    O(2^n)

    Space Complexity:
    O(2^n)
*/

import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();

        int total = 1 << n;   // 2^n

        for (int i = 0; i < total; i++) {

            int gray = i ^ (i >> 1);

            result.add(gray);
        }

        return result;
    }
}
