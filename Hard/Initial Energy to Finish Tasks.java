/*
LeetCode 1665: Minimum Initial Energy to Finish Tasks
Difficulty: Hard
Topics: Greedy, Sorting

Approach:
1. Sort tasks by (minimum - actual) in descending order.
2. Process tasks in that order.
3. Ensure energy is sufficient to start each task and update the required initial energy.

Time Complexity: O(n log n)
Space Complexity: O(log n) for sorting overhead.
*/

import java.util.Arrays;

class Solution {
    public int minimumEffort(int[][] tasks) {
        // Sort by minimum - actual in descending order
        Arrays.sort(tasks, (a, b) ->
            Integer.compare(b[1] - b[0], a[1] - a[0])
        );

        int energy = 0;
        int initialEnergy = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            // Ensure enough energy to start this task
            initialEnergy = Math.max(initialEnergy, energy + minimum);

            // Spend energy to complete the task
            energy += actual;
        }

        return initialEnergy;
    }
}
