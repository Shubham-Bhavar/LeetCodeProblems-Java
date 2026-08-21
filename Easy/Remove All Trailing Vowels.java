/*
 * Question: Remove All Trailing Vowels
 *
 * Given a string consisting of lowercase English letters,
 * remove all vowels from the end of the string.
 *
 * Vowels: a, e, i, o, u
 *
 * Example:
 * Input:  "idea"
 * Output: "id"
 *
 * Approach:
 * Start from the last character.
 * Keep moving backward while the character is a vowel.
 * Return the remaining substring.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public String trimTrailingVowels(String s) {
        int i = s.length() - 1;

        // Skip all trailing vowels
        while (i >= 0 && isVowel(s.charAt(i))) {
            i--;
        }

        // Return the remaining string
        return s.substring(0, i + 1);
    }

    // Checks whether a character is a vowel
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u';
    }
}
