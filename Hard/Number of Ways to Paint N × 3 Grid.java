/*
 * LeetCode 1411: Number of Ways to Paint N × 3 Grid
 *
 * Problem:
 * You have an n x 3 grid.
 *
 * Each cell can be:
 * - Red
 * - Yellow
 * - Green
 *
 * No two adjacent cells can have the same color.
 *
 * Return the number of valid ways to paint the entire grid.
 *
 * Answer must be modulo 10^9 + 7.
 *
 * Example 1:
 * Input:  n = 1
 * Output: 12
 *
 * Example 2:
 * Input:  n = 5000
 * Output: 30228214
 *
 * Approach:
 *
 * For every row, there are only two possible patterns:
 *
 * 1. ABA pattern
 *    Example: R Y R
 *
 *    First and third colors are the same.
 *    Number of ways = 6
 *
 * 2. ABC pattern
 *    Example: R Y G
 *
 *    All three colors are different.
 *    Number of ways = 6
 *
 * For the next row:
 *
 * ABA -> ABA : 3 ways
 * ABA -> ABC : 2 ways
 *
 * ABC -> ABA : 2 ways
 * ABC -> ABC : 2 ways
 *
 * Therefore:
 *
 * newABA = oldABA * 3 + oldABC * 2
 * newABC = oldABA * 2 + oldABC * 2
 *
 * Initial row:
 * ABA = 6
 * ABC = 6
 *
 * Final answer = ABA + ABC
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int numOfWays(int n) {

        long MOD = 1_000_000_007;

        // For the first row
        long aba = 6;
        long abc = 6;

        for (int row = 2; row <= n; row++) {

            long newAba =
                    (aba * 3 + abc * 2) % MOD;

            long newAbc =
                    (aba * 2 + abc * 2) % MOD;

            aba = newAba;
            abc = newAbc;
        }

        return (int) ((aba + abc) % MOD);
    }
}
