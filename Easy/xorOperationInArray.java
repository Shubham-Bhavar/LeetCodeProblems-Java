/*
Question:
Given n and start,
nums[i] = start + 2*i.

Return XOR of all elements of nums.

Example:
Input: n = 5, start = 0
Output: 8

nums = [0,2,4,6,8]
0 ^ 2 ^ 4 ^ 6 ^ 8 = 8
*/

class Solution {
    public int xorOperation(int n, int start) {

        // Store final XOR value
        int xor = 0;

        // Generate array elements logically
        for (int i = 0; i < n; i++) {

            // XOR current element
            xor ^= (start + 2 * i);
        }

        return xor;
    }
}
