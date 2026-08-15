/*
Question:
Find the minimum number of bit flips required to make
the XOR of all elements equal to k.

Example:
nums = [2,1,3,4], k = 1
Output = 2
*/

class Solution {
    public int minOperations(int[] nums, int k) {

        int xor = 0;

        // Find XOR of all elements
        for (int num : nums) {
            xor ^= num;
        }

        // Bits that need to be changed
        int required = xor ^ k;

        int count = 0;

        // Count set bits
        while (required > 0) {
            count += required & 1;
            required >>= 1;
        }

        return count;
    }
}
