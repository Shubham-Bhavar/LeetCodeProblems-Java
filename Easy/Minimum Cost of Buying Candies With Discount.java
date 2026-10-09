/*
 * LeetCode 2144: Minimum Cost of Buying Candies With Discount
 *
 * Problem:
 * For every two candies purchased, one additional candy is free.
 *
 * The free candy's cost must be less than or equal to the
 * minimum cost of the two purchased candies.
 *
 * Return the minimum total cost to buy all candies.
 *
 * Example 1:
 * Input:  cost = [1,2,3]
 * Output: 5
 *
 * Example 2:
 * Input:  cost = [6,5,7,9,2,2]
 * Output: 23
 *
 * Example 3:
 * Input:  cost = [5,5]
 * Output: 10
 *
 * Approach:
 * 1. Sort the costs in descending order.
 * 2. Buy the two most expensive remaining candies.
 * 3. Take the third candy for free.
 * 4. Repeat this process.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1) auxiliary space, excluding sorting.
 */

import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int total = 0;
        int n = cost.length;

        // Traverse from the most expensive candy
        for (int i = n - 1; i >= 0; i--) {

            // Every third candy is free
            if ((n - 1 - i) % 3 != 2) {
                total += cost[i];
            }
        }

        return total;
    }
}
