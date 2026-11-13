
/*
 * LeetCode 1492: The kth Factor of n
 *
 * Problem:
 * Find the kth smallest factor of a given number n.
 * Return -1 if fewer than k factors exist.
 *
 * Approach:
 * Brute Force (Simple Loop)
 *
 * Step-by-step Explanation:
 * 1. Traverse numbers from 1 to n.
 * 2. Check if n is divisible by the current number.
 * 3. If divisible, it is a factor of n.
 * 4. Decrease k by 1 for every factor found.
 * 5. When k becomes 0, return the current factor.
 * 6. If the loop finishes, return -1.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int kthFactor(int n, int k) {

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {

                k--;

                if (k == 0) {
                    return i;
                }
            }
        }

        return -1;
    }
}
