
/*
 * Problem: 453. Minimum Moves to Equal Array Elements
 * Difficulty: Medium
 * Language: Java
 *
 * Approach:
 * 1. Find the minimum element in the array.
 * 2. Calculate the difference between every element
 *    and the minimum element.
 * 3. Add all differences to get minimum moves.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int moves = 0;

        for (int num : nums) {
            min = Math.min(min, num);
        }

        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }
}
