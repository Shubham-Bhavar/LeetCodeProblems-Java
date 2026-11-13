
/*
 * LeetCode 2483: Minimum Penalty for a Shop
 *
 * Problem:
 * Find the earliest closing hour that gives
 * the minimum penalty.
 *
 * Approach:
 * Greedy (Single Pass)
 *
 * Step-by-step Explanation:
 * 1. Initially, assume the shop closes at hour 0.
 * 2. Count all Y characters as the initial penalty.
 * 3. Traverse the customer string.
 * 4. If character is Y, penalty decreases by 1
 *    because keeping the shop open avoids a penalty.
 * 5. If character is N, penalty increases by 1
 *    because keeping the shop open causes a penalty.
 * 6. Update the best closing hour whenever
 *    we find a smaller penalty.
 * 7. Return the earliest closing hour.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int bestClosingTime(String customers) {

        int penalty = 0;

        // Initially, shop closes at hour 0.
        // All Y customers contribute to penalty.
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestHour = 0;

        // Check every possible closing hour.
        for (int i = 0; i < customers.length(); i++) {

            if (customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            // Update only when penalty is smaller.
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}
