/*
 * LeetCode 611: Valid Triangle Number
 *
 * Problem:
 * Given an integer array nums, return the number of triplets
 * chosen from the array that can make triangles if we take them
 * as side lengths of a triangle.
 *
 * A valid triangle must satisfy:
 *
 *     a + b > c
 *
 * where c is the largest side.
 *
 * Example 1:
 * Input:  nums = [2,2,3,4]
 * Output: 3
 *
 * Valid combinations:
 * [2,2,3]
 * [2,3,4] using first 2
 * [2,3,4] using second 2
 *
 * Example 2:
 * Input:  nums = [4,2,3,4]
 * Output: 4
 *
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 *
 * Approach:
 * 1. Sort the array.
 * 2. Fix the largest side at index k.
 * 3. Use two pointers:
 *      left = 0
 *      right = k - 1
 *
 * 4. If nums[left] + nums[right] > nums[k]:
 *      Every index between left and right can form a triangle
 *      with nums[right] and nums[k].
 *
 *      So, add:
 *          right - left
 *
 *      Then move right leftward.
 *
 * 5. Otherwise, the sum is too small, so move left forward.
 *
 * Time Complexity:
 * O(n^2)
 *
 * Space Complexity:
 * O(1) extra space
 * (Ignoring the sorting implementation.)
 */

import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);

        int count = 0;
        int n = nums.length;

        // Fix the largest side
        for (int k = n - 1; k >= 2; k--) {

            int left = 0;
            int right = k - 1;

            while (left < right) {

                if (nums[left] + nums[right] > nums[k]) {

                    // All elements from left to right - 1
                    // can form a valid triangle with right and k
                    count += right - left;

                    right--;

                } else {

                    // Need a larger left value
                    left++;
                }
            }
        }

        return count;
    }
}
