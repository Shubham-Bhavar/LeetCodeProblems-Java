
/*
 * LeetCode 1872 - Stone Game VIII
 *
 * Difficulty: Hard
 * Approach: Prefix Sum + Dynamic Programming
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        long[] prefix = new long[n];

        // Calculate prefix sums
        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // Start with the total sum
        long dp = prefix[n - 1];

        // Calculate the optimal score difference
        for (int i = n - 2; i >= 1; i--) {
            dp = Math.max(dp, prefix[i] - dp);
        }

        return (int) dp;
    }
}
