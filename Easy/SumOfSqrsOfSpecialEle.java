/**
 * Problem: Sum of Squares of Special Elements
 * Platform: LeetCode
 *
 * Description:
 * An element nums[i] (1-indexed) is special if i divides n.
 * Return sum of squares of all such elements.
 *
 * Approach:
 * - Iterate i from 1 to n
 * - Check if n % i == 0
 * - Add square of nums[i-1] to sum
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += nums[i - 1] * nums[i - 1];
            }
        }

        return sum;
    }
}
