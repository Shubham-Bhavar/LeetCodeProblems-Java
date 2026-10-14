
/*
 * LeetCode 1402: Reducing Dishes
 *
 * Problem:
 * Each dish takes 1 unit of time.
 * Like-time coefficient = cooking time * satisfaction.
 * Maximize the sum by choosing and ordering dishes.
 *
 * Approach: Greedy
 * 1. Sort satisfaction in ascending order.
 * 2. Start from the highest satisfaction.
 * 3. Add a dish while the running sum remains positive.
 * 4. Each selected dish increases the total by the
 *    current running sum.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(log n) auxiliary space for sorting
 * (implementation-dependent).
 */

import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int runningSum = 0;
        int total = 0;

        for (int i = satisfaction.length - 1; i >= 0; i--) {
            runningSum += satisfaction[i];

            if (runningSum <= 0) {
                break;
            }

            total += runningSum;
        }

        return total;
    }
}
