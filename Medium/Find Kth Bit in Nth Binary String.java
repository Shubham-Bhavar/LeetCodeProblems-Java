/*
* Problem: 1545. Find Kth Bit in Nth Binary String
* Difficulty: Medium
* Approach: Recursion + Divide and Conquer
*
* Time Complexity: O(n)
* Space Complexity: O(n) - Recursion Stack
*/
class Solution {

    public char findKthBit(int n, int k) {
        int length = (1 << n) - 1;

        return solve(n, k, length);
    }

    private char solve(int n, int k, int length) {

        // Base case
        if (n == 1) {
            return '0';
        }

        int mid = length / 2 + 1;

        // Middle bit is always 1
        if (k == mid) {
            return '1';
        }

        // Search in the left half
        if (k < mid) {
            return solve(n - 1, k, length / 2);
        }

        // Search in the right half and invert the result
        char bit = solve(n - 1, length - k + 1, length / 2);

        return bit == '0' ? '1' : '0';
    }
}
