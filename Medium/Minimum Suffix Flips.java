/*
LeetCode: Minimum Suffix Flips
Difficulty: Medium
Topics: String, Greedy

Approach:
1. Start with all bits as '0'.
2. Whenever the target bit differs from the current bit,
   flip the suffix and increase operations.
3. Track the current bit after each flip.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int minFlips(String target) {
        int operations = 0;
        char current = '0';

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != current) {
                operations++;
                current = (current == '0') ? '1' : '0';
            }
        }

        return operations;
    }
}
