/*
LeetCode: Number of Special Characters I

Problem:
A letter is special if it appears in both lowercase and
uppercase in the given string.

Example:
Input:  word = "aaAbcBC"
Output: 3

Special letters: a, b, c
*/

class Solution {
    public int numberOfSpecialChars(String word) {

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        // Store lowercase and uppercase letters
        for (char ch : word.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                lower[ch - 'a'] = true;
            } else {
                upper[ch - 'A'] = true;
            }
        }

        int count = 0;

        // Check letters present in both cases
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count;
    }
}
