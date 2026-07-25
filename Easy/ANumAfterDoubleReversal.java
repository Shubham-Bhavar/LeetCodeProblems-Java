/**
 * Problem: Check if Number is Same After Double Reversal
 * Platform: LeetCode
 *
 * Description:
 * Reversing an integer twice should give the original number.
 * However, numbers ending with 0 lose trailing zeros when reversed,
 * so they cannot return to the original value (except 0 itself).
 *
 * Approach:
 * - If num == 0 → return true
 * - If num ends with 0 → return false
 * - Otherwise → return true
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
    }
}
