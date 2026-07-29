/**
 * Problem: Find the Pivot Integer
 * Platform: LeetCode
 *
 * Description:
 * Find an integer x such that:
 * sum(1 → x) == sum(x → n)
 *
 * If such x exists, return it, otherwise return -1.
 *
 * Approach:
 * Total sum from 1 to n = n * (n + 1) / 2
 * Let left sum = sum(1 → x)
 * Let right sum = sum(x → n)
 *
 * Condition:
 * left == right
 *
 * => sum(1 → x) = totalSum - sum(1 → (x - 1))
 * => x^2 = totalSum
 *
 * So, we just check if totalSum is a perfect square.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int pivotInteger(int n) {
        int total = n * (n + 1) / 2;
        int x = (int) Math.sqrt(total);

        if (x * x == total) {
            return x;
        }
        return -1;
    }
}
