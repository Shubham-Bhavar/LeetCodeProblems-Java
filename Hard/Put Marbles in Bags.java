/*
* Problem: 2551. Put Marbles in Bags
* Difficulty: Hard
* Approach: Greedy + Sorting
* Time Complexity: O(n log n)
* Space Complexity: O(n)
*/
import java.util.Arrays;

class Solution {

    public long putMarbles(int[] weights, int k) {

        int n = weights.length;

        if (k == 1 || k == n) {
            return 0;
        }

        long[] pairs = new long[n - 1];

        // Calculate adjacent pair sums
        for (int i = 0; i < n - 1; i++) {
            pairs[i] = (long) weights[i] + weights[i + 1];
        }

        // Sort pair sums
        Arrays.sort(pairs);

        long minScore = 0;
        long maxScore = 0;

        // Select smallest and largest k-1 pair sums
        for (int i = 0; i < k - 1; i++) {
            minScore += pairs[i];
            maxScore += pairs[n - 2 - i];
        }

        return maxScore - minScore;
    }
}
