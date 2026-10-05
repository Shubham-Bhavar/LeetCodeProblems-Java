/*
 * LeetCode 403: Frog Jump
 *
 * Problem:
 * A frog wants to cross a river by jumping on stones.
 *
 * If the frog's previous jump was k units, the next jump can be:
 * - k - 1
 * - k
 * - k + 1
 *
 * The frog can only move forward.
 * The first jump must be exactly 1 unit.
 *
 * Return true if the frog can reach the last stone.
 *
 * Example 1:
 * Input:
 * [0,1,3,5,6,8,12,17]
 *
 * Output:
 * true
 *
 * Example 2:
 * Input:
 * [0,1,2,3,4,8,9,11]
 *
 * Output:
 * false
 *
 * Constraints:
 * 2 <= stones.length <= 2000
 * stones is sorted in strictly increasing order.
 *
 * Approach:
 * 1. For every stone, store all possible jump sizes
 *    that can reach that stone.
 * 2. Initially, the frog reaches stone 0 with jump 0.
 * 3. For every possible jump k:
 *      Try k - 1, k, and k + 1.
 * 4. If the destination stone exists, store the new jump size there.
 * 5. If the last stone gets any valid jump, return true.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        // Map stone position -> possible jump sizes
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        // Starting position
        map.get(0).add(0);

        for (int stone : stones) {

            for (int jump : map.get(stone)) {

                // Try jump - 1, jump, jump + 1
                for (int nextJump = jump - 1;
                     nextJump <= jump + 1;
                     nextJump++) {

                    if (nextJump <= 0) {
                        continue;
                    }

                    int nextPosition = stone + nextJump;

                    // If a stone exists at this position
                    if (map.containsKey(nextPosition)) {
                        map.get(nextPosition).add(nextJump);
                    }
                }
            }
        }

        // If the last stone has at least one possible jump
        return !map.get(stones[n - 1]).isEmpty();
    }
}
