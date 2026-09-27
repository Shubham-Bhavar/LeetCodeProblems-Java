```java
/*
 * LeetCode: Pascal's Triangle II
 *
 * Problem:
 * Given an integer rowIndex, return the rowIndex-th (0-indexed)
 * row of Pascal's Triangle.
 *
 * Example 1:
 * Input:  rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input:  rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input:  rowIndex = 1
 * Output: [1,1]
 *
 * Follow-up:
 * Optimize the algorithm to use only O(rowIndex) extra space.
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * Every value in Pascal's Triangle can be calculated using:
 *
 *              n!
 * C(n, k) = -----------
 *            k!(n-k)!
 *
 * Instead of calculating factorials, we calculate each value
 * from the previous value:
 *
 * C(n, k) = C(n, k-1) * (n-k+1) / k
 *
 * Example:
 *
 * rowIndex = 4
 *
 * C(4,0) = 1
 *
 * C(4,1) = 1 * 4 / 1 = 4
 * C(4,2) = 4 * 3 / 2 = 6
 * C(4,3) = 6 * 2 / 3 = 4
 * C(4,4) = 4 * 1 / 4 = 1
 *
 * Result:
 * [1, 4, 6, 4, 1]
 *
 * ------------------------------------------------------------
 * Why long?
 * ------------------------------------------------------------
 *
 * We use long for the intermediate multiplication to avoid
 * integer overflow during:
 *
 * result.get(k - 1) * (rowIndex - k + 1)
 *
 * The final values fit within int for rowIndex <= 33.
 *
 * ------------------------------------------------------------
 * Time Complexity:
 * O(rowIndex)
 *
 * We calculate each element of the required row once.
 *
 * Space Complexity:
 * O(rowIndex)
 *
 * Only the required row is stored.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();

        // First element of every Pascal row is 1.
        row.add(1);

        long value = 1;

        for (int k = 1; k <= rowIndex; k++) {

            // Calculate C(rowIndex, k)
            value = value * (rowIndex - k + 1) / k;

            row.add((int) value);
        }

        return row;
    }
}
