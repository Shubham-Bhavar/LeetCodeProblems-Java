
/*
 * LeetCode 3227 - Vowels Game in a String
 *
 * Difficulty: Medium
 * Approach: Count Vowels + Game Theory
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean doesAliceWin(String s) {
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                return true;
            }
        }

        return false;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }
}
