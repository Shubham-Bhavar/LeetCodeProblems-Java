
/*
 * LeetCode 1963. Minimum Number of Swaps to Make the String Balanced
 *
 * Problem:
 * Find the minimum swaps required to make the bracket string balanced.
 *
 * Approach:
 * 1. Track the current balance of brackets.
 * 2. Increment balance for '[' and decrement for ']'.
 * 3. Track the maximum negative balance.
 * 4. Calculate the minimum swaps using (maxImbalance + 1) / 2.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minSwaps(String s) {
        int balance = 0;
        int maxImbalance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                balance++;
            } else {
                balance--;
            }

            maxImbalance = Math.max(maxImbalance, -balance);
        }

        return (maxImbalance + 1) / 2;
    }
}
