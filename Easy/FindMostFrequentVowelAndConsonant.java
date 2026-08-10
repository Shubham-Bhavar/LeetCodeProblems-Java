/*
Q) Given a string s of lowercase letters.

Find:
1. Maximum frequency among vowels (a, e, i, o, u)
2. Maximum frequency among consonants

Return sum of both.

If no vowel or consonant exists, consider its frequency = 0.
*/

class Solution {
    public int maxFreqSum(String s) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxVowel = 0;
        int maxConsonant = 0;

        // Traverse all characters
        for (int i = 0; i < 26; i++) {

            char ch = (char) (i + 'a');

            // Check vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                maxVowel = Math.max(maxVowel, freq[i]);
            } else {
                maxConsonant = Math.max(maxConsonant, freq[i]);
            }
        }

        return maxVowel + maxConsonant;
    }
}
