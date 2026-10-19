/*
LeetCode: Find the K-th Character in String
Difficulty: Easy
Topics: String, Simulation

Approach:
1. Start with word = "a".
2. For every character, append its next alphabet character.
3. Repeat until the string length is at least k, then return word.charAt(k - 1).

Time Complexity: O(k)
Space Complexity: O(k)
*/

class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while (word.length() < k) {
            int len = word.length();

            for (int i = 0; i < len; i++) {
                char next = (char) (word.charAt(i) + 1);
                word.append(next);
            }
        }

        return word.charAt(k - 1);
    }
}
