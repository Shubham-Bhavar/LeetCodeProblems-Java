/*
 * LeetCode 657: Robot Return to Origin
 *
 * Problem:
 * A robot starts at (0, 0).
 * U = Up, D = Down, L = Left, R = Right.
 * Return true if the robot returns to the origin
 * after performing all moves.
 *
 * Approach:
 * Count horizontal and vertical movements.
 * Opposite movements cancel each other.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }

        return x == 0 && y == 0;
    }
}