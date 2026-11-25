
/*
 * LeetCode 283: Move Zeroes
 *
 * Problem:
 * Move all zeroes to the end while maintaining
 * the relative order of non-zero elements.
 *
 * Approach: Two Pointers
 *
 * 1. Use index to track the next non-zero position.
 * 2. Traverse the array.
 * 3. If an element is non-zero, place it at index.
 * 4. Fill all remaining positions with zero.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
