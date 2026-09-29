/*
 * LeetCode 153: Find Minimum in Rotated Sorted Array
 *
 * Problem:
 * An array of length n is sorted in ascending order and then rotated
 * between 1 and n times.
 *
 * Given the rotated sorted array nums containing unique elements,
 * return the minimum element.
 *
 * The solution must run in O(log n) time.
 *
 * Example 1:
 * Input:  nums = [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input:  nums = [4,5,6,7,0,1,2]
 * Output: 0
 *
 * Example 3:
 * Input:  nums = [11,13,15,17]
 * Output: 11
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * -5000 <= nums[i] <= 5000
 * All elements are unique.
 */

class Solution {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            /*
             * If nums[mid] > nums[right],
             * the minimum must be on the right side.
             */
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            /*
             * Otherwise, the minimum is at mid or
             * somewhere on the left side.
             */
            else {
                right = mid;
            }
        }

        // left == right, pointing to the minimum element.
        return nums[left];
    }
}
