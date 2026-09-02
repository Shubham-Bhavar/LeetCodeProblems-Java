/*
LeetCode 3736 - Minimum Moves to Equal Array Elements III

Problem:
In one move, we can increase any element by 1.
Find the minimum moves required to make all elements equal.

Approach:
- Since we can only increase elements, the final value must be
  the maximum value in the array.
- For every element, moves needed = max - nums[i].
- Add all these moves.
*/

class Solution {
    public int minMoves(int[] nums) {

        int max = 0;
        int moves = 0;

        // Find maximum element
        for(int num : nums) {
            max = Math.max(max, num);
        }

        // Calculate required moves
        for(int num : nums) {
            moves += max - num;
        }

        return moves;
    }
}
