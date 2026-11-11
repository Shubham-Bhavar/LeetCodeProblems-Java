
/*
 * LeetCode 162. Find Peak Element
 *
 * Description:
 * Find an element that is strictly greater than its
 * adjacent elements and return its index.
 * If multiple peak elements exist, return any one of them.
 *
 * Approach: Binary Search
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak lies on the left side or at mid
                right = mid;
            } else {
                // Peak lies on the right side
                left = mid + 1;
            }
        }

        return left;
    }
}
