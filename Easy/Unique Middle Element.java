
/*
 * LeetCode 3978. Unique Middle Element
 *
 * Problem:
 * Check whether the middle element of an odd-length
 * array appears exactly once.
 *
 * Approach: Array Traversal
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isUnique(int[] nums) {

        int middle = nums[nums.length / 2];
        int count = 0;

        for (int num : nums) {
            if (num == middle) {
                count++;
            }
        }

        return count == 1;
    }
}
