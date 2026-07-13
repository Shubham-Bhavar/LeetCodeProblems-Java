/*
Question:
You are given an integer n.

Define its mirror distance as:
abs(n - reverse(n))

where reverse(n) is the number formed by reversing digits of n.

Return the mirror distance.
*/

class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        int reversed = 0;

        // reverse the number
        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        // return absolute difference
        return Math.abs(original - reversed);
    }
}
