/*
 * LeetCode 292: Nim Game
 *
 * Problem:
 * There is a heap containing n stones.
 *
 * You and your friend take turns.
 * You go first.
 *
 * On each turn, a player can remove 1, 2, or 3 stones.
 * The player who removes the last stone wins.
 *
 * Return true if you can win assuming both players play optimally.
 *
 * Example 1:
 * Input:  n = 4
 * Output: false
 *
 * Example 2:
 * Input:  n = 1
 * Output: true
 *
 * Example 3:
 * Input:  n = 2
 * Output: true
 *
 * Constraints:
 * 1 <= n <= 2^31 - 1
 *
 * Approach:
 * The losing positions are:
 *
 * 4, 8, 12, 16, ...
 *
 * These are exactly the numbers divisible by 4.
 *
 * Why?
 * If n is a multiple of 4, whatever number (1, 2, or 3)
 * we remove, the opponent can remove enough stones to make
 * the remaining number a multiple of 4 again.
 *
 * Therefore:
 * - n % 4 == 0 -> Lose -> false
 * - Otherwise -> Win -> true
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
