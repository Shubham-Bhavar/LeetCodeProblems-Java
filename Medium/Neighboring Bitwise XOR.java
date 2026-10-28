/*
 * LeetCode 2683: Neighboring Bitwise XOR
 *
 * Question:
 * Check whether a valid original binary array exists
 * for the given derived array.
 *
 * Approach:
 * 1. XOR all elements of derived.
 * 2. Every original element appears twice.
 * 3. If total XOR is 0, return true; otherwise, false.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;

        for (int num : derived)
            xor ^= num;

        return xor == 0;
    }
}
