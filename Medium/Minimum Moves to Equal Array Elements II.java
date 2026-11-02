
/*
 * LeetCode 462 - Minimum Moves to Equal Array Elements II
 *
 * Difficulty: Medium
 * Approach: Sorting + Median
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space (excluding sorting stack)
 */

import java.util.Arrays;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}
