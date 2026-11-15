
/*
 * LeetCode 41: First Missing Positive
 *
 * Problem:
 * Given an unsorted integer array nums, find the smallest
 * positive integer that is missing from the array.
 *
 * Requirements:
 * 1. O(n) time complexity.
 * 2. O(1) auxiliary space complexity.
 *
 * Approach: Cyclic Sort (Index Placement)
 *
 * Explanation:
 * 1. Traverse the array using a while loop.
 * 2. Every number x between 1 and nums.length belongs
 *    at index x - 1.
 * 3. If the number is valid and is not already at its
 *    correct index, swap it into its correct position.
 * 4. Ignore negative numbers, zero, numbers greater
 *    than array length, and duplicates.
 * 5. Traverse the array again.
 * 6. The first index where nums[i] != i + 1 gives
 *    the missing positive integer i + 1.
 * 7. If every number is correctly placed, return n + 1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int i = 0;

        while (i < n) {

            int correctIndex = nums[i] - 1;

            if (nums[i] > 0 && nums[i] <= n &&
                nums[i] != nums[correctIndex]) {

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
