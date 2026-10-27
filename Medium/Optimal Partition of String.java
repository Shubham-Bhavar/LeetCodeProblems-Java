/*
 * LeetCode 2405: Optimal Partition of String
 *
 * Question:
 * Split the string into the minimum number of substrings
 * such that each substring contains unique characters.
 *
 * Approach:
 * 1. Use a boolean array to track visited characters.
 * 2. If a character repeats, start a new substring.
 * 3. Mark the character as visited.
 * 4. Return the total number of substrings.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];
        int count = 1;

        for (char c : s.toCharArray()) {
            int i = c - 'a';

            if (seen[i]) {
                count++;
                seen = new boolean[26];
            }

            seen[i] = true;
        }

        return count;
    }
}
