
/*
 * Problem: 1829. Maximum XOR for Each Query
 * Difficulty: Medium
 * Topics: Array, Bit Manipulation, Prefix XOR
 *
 * Approach:
 * 1. The maximum possible XOR value is (1 << maximumBit) - 1.
 * 2. Calculate the XOR of all elements in nums.
 * 3. For each query, XOR the current XOR with the maximum value
 *    to get the required k.
 * 4. Remove the last element by XORing it out, processing
 *    the array from right to left.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the answer array.
 */

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];

        int maxXor = (1 << maximumBit) - 1;
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        for (int i = 0; i < n; i++) {
            answer[i] = xor ^ maxXor;
            xor ^= nums[n - 1 - i];
        }

        return answer;
    }
}
