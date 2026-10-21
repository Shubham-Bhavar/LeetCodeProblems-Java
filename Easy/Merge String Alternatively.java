/*
 * Problem: 1768. Merge Strings Alternately
 * Difficulty: Easy
 * Topics: Two Pointers, String
 *
 * Approach:
 * 1. Use two pointers to traverse both strings.
 * 2. Add one character from word1, then one from word2.
 * 3. If one string ends, append the remaining characters.
 * 4. Return the merged string.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i++));
            }

            if (j < word2.length()) {
                result.append(word2.charAt(j++));
            }
        }

        return result.toString();
    }
}