
/*
 * LeetCode 1304 - Find N Unique Integers Sum up to Zero
 *
 * Difficulty: Easy
 * Approach: Pair each positive integer with its negative.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) - excluding the output array.
 */

class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;

        // Add positive and negative pairs
        for (int i = 1; i <= n / 2; i++) {
            result[index++] = i;
            result[index++] = -i;
        }

        // If n is odd, add zero
        if (n % 2 != 0) {
            result[index] = 0;
        }

        return result;
    }
}
