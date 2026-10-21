/*
 * Problem: 1079. Letter Tile Possibilities
 * Difficulty: Medium
 * Topics: String, Backtracking
 *
 * Approach:
 * 1. Count the frequency of each character.
 * 2. Try using each available character to form a sequence.
 * 3. Every time a character is used, decrease its frequency.
 * 4. Count the new sequence and recursively explore longer sequences.
 * 5. Restore the frequency to backtrack.
 *
 * Time Complexity: O(n * n!)
 * Space Complexity: O(n)
 */

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];

        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }

        return backtrack(freq);
    }

    private int backtrack(int[] freq) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }

            count++;
            freq[i]--;

            count += backtrack(freq);

            freq[i]++;
        }

        return count;
    }
}