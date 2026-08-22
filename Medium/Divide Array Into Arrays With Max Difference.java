/*
 * LeetCode 2966: Divide Array Into Arrays With Max Difference
 *
 * Given an integer array nums and an integer k, divide nums into
 * groups of exactly 3 elements.
 *
 * The difference between any two elements in the same group
 * must be less than or equal to k.
 *
 * Return the groups as a 2D array.
 * If it is impossible, return an empty array.
 *
 * Example:
 * nums = [1,3,4,8,7,9,3,5,1]
 * k = 2
 *
 * After sorting:
 * [1,1,3,3,4,5,7,8,9]
 *
 * Groups:
 * [1,1,3] -> 3 - 1 = 2 <= k
 * [3,4,5] -> 5 - 3 = 2 <= k
 * [7,8,9] -> 9 - 7 = 2 <= k
 *
 * Approach:
 * 1. Sort the array.
 * 2. Take every 3 consecutive elements as one group.
 * 3. Check the difference between the largest and smallest element.
 * 4. If the difference is greater than k, return an empty array.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

class Solution {

    public int[][] divideArray(int[] nums, int k) {

        // Sort the array
        Arrays.sort(nums);

        // Create result array with groups of size 3
        int[][] result = new int[nums.length / 3][3];

        // Process every group of 3 elements
        for (int i = 0; i < nums.length; i += 3) {

            // Check maximum difference in the group
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }

            // Add elements to the result
            result[i / 3][0] = nums[i];
            result[i / 3][1] = nums[i + 1];
            result[i / 3][2] = nums[i + 2];
        }

        return result;
    }
}
