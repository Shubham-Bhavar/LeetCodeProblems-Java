
/*
 * LeetCode 3947: Maximum Number of Items From Sale II
 *
 * Approach: Greedy + Sorting + Frequency Counting
 *
 * 1. Count frequency of every factor.
 * 2. Calculate free items for each item.
 * 3. Sort items by price.
 * 4. Buy beneficial copies costing less than
 *    twice the minimum price.
 * 5. Use remaining budget to buy cheapest items.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int maxNumberOfItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];
        int[] freeCount = new int[n + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Count multiples of every factor
        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = i; j <= n; j += i) {
                count += freq[j];
            }

            freeCount[i] = count - 1;
        }

        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1]));

        long minPrice = items[0][1];
        long remaining = budget;
        long freeBonus = 0;

        for (int[] item : items) {
            long price = item[1];

            if (price >= 2 * minPrice) {
                break;
            }

            long canBuy = Math.min(
                (long) freeCount[item[0]],
                remaining / price
            );

            freeBonus += canBuy;
            remaining -= canBuy * price;

            if (canBuy < freeCount[item[0]]) {
                break;
            }
        }

        return (int)(2 * freeBonus + remaining / minPrice);
    }
}
