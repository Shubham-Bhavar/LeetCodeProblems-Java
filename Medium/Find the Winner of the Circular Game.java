/*
LeetCode: Find the Winner of the Circular Game

Problem:
There are n friends sitting in a circle.
Starting from friend 1, count k friends clockwise.
The kth friend leaves the circle.
Continue until only one friend remains.

Return the number of the winning friend.

Approach:
1. This is a Josephus Problem.
2. Start with winner = 0 for 0-indexed positions.
3. For each number of friends from 2 to n:
   winner = (winner + k) % i
4. Convert the final 0-indexed position to 1-indexed
   by adding 1.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int findTheWinner(int n, int k) {

        int winner = 0;

        // Josephus formula
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }

        // Convert 0-indexed result to 1-indexed
        return winner + 1;
    }
}
