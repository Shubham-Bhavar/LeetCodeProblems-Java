
/*
 * LeetCode 3360: Stone Removal Game
 *
 * Problem:
 * Alice removes 10 stones first.
 * Each next player removes 1 fewer stone
 * than the previous opponent.
 *
 * Approach: Simulation
 *
 * 1. Start with 10 stones to remove.
 * 2. Reduce the required stones by 1 each turn.
 * 3. If Alice cannot make a move, return false.
 * 4. If Bob cannot make a move, return true.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean aliceTurn = true;

        while (n >= remove) {
            n -= remove;
            remove--;
            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}
