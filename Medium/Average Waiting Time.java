
/*
 * LeetCode 1701: Average Waiting Time
 *
 * Approach: Greedy
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public double averageWaitingTime(int[][] customers) {

        long currentTime = 0;
        long totalWaitingTime = 0;

        for (int[] customer : customers) {

            int arrival = customer[0];
            int preparationTime = customer[1];

            // Chef starts when the customer arrives or becomes idle.
            currentTime = Math.max(currentTime, arrival);

            // Finish preparing the current order.
            currentTime += preparationTime;

            // Calculate the customer's total waiting time.
            totalWaitingTime += currentTime - arrival;
        }

        return (double) totalWaitingTime / customers.length;
    }
}
