/*
LeetCode 1255: Maximum Score Words Formed by Letters
Difficulty: Hard
Topics: Array, String, Backtracking, Bit Manipulation

Approach:
1. Count the available frequency of each letter.
2. Use backtracking to try including or skipping each word.
3. Return the maximum score among all valid combinations.

Time Complexity: O(2^n * L)
Space Complexity: O(n + 26)

n = number of words, L = total characters processed per combination.
*/

class Solution {
    private int maxScore = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];

        for (char c : letters) {
            freq[c - 'a']++;
        }

        backtrack(words, score, freq, 0, 0);

        return maxScore;
    }

    private void backtrack(String[] words, int[] score,
                           int[] freq, int index, int currentScore) {

        if (index == words.length) {
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        // Option 1: Skip the current word
        backtrack(words, score, freq, index + 1, currentScore);

        // Option 2: Try to use the current word
        String word = words[index];
        int wordScore = 0;
        boolean canForm = true;

        for (char c : word.toCharArray()) {
            int letter = c - 'a';
            freq[letter]--;
            wordScore += score[letter];

            if (freq[letter] < 0) {
                canForm = false;
            }
        }

        if (canForm) {
            backtrack(words, score, freq, index + 1,
                      currentScore + wordScore);
        }

        // Restore letters for other combinations
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
    }
}
