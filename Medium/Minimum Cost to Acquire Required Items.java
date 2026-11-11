
/*
 * LeetCode 3789. Minimum Cost to Acquire Required Items
 *
 * Description:
 * Find the minimum cost to satisfy the required quantities
 * of type 1 and type 2 items. Type 3 items contribute one
 * unit to both requirements, while type 1 and type 2 items
 * contribute only to their respective requirements.
 *
 * Approach: Greedy / Mathematics
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        // Option 1: Buy individual items
        long separateCost = (long) cost1 * need1
                          + (long) cost2 * need2;

        // Option 2: Buy common items and remaining individual items
        int common = Math.min(need1, need2);

        long mixedCost = (long) common * costBoth
                       + (long) (need1 - common) * cost1
                       + (long) (need2 - common) * cost2;

        // Option 3: Buy only type 3 items
        long bothCost = (long) Math.max(need1, need2) * costBoth;

        // Return the minimum cost
        return Math.min(separateCost,
               Math.min(mixedCost, bothCost));
    }
}
