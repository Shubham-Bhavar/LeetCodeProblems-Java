/*
LeetCode 2120: Execution of All Suffix Instructions
Difficulty: Medium
Topics: String, Simulation

Problem:
For each instruction index, count how many instructions the robot
can execute before moving outside an n x n grid.

Approach:
1. Start from the given position for every instruction index.
2. Execute instructions one by one and update the robot's position.
3. Stop when the robot moves outside the grid.

Time Complexity: O(m^2)
Space Complexity: O(m) for the answer array
*/

class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int row = startPos[0];
            int col = startPos[1];
            int count = 0;

            for (int j = i; j < m; j++) {
                char move = s.charAt(j);

                // Execute the current instruction
                if (move == 'L') {
                    col--;
                } else if (move == 'R') {
                    col++;
                } else if (move == 'U') {
                    row--;
                } else if (move == 'D') {
                    row++;
                }

                // Stop if the robot moves outside the grid
                if (row < 0 || row >= n || col < 0 || col >= n) {
                    break;
                }

                count++;
            }

            answer[i] = count;
        }

        return answer;
    }
}
