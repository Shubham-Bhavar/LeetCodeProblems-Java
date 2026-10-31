/*
 * Problem: 905. Sort Array By Parity
 * Difficulty: Easy
 *
 * Approach:
 * Move all even numbers to the beginning
 * and odd numbers to the end.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0) {

                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;

                index++;
            }
        }

        return nums;
    }
}
