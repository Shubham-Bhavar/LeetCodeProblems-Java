/**
 * LeetCode 2785: Sort Vowels in a String
 *
 * Approach:
 * 1. Collect all vowels from the string.
 * 2. Sort the vowels by ASCII value.
 * 3. Replace the vowel positions with sorted vowels.
 * 4. Keep all consonants in their original positions.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
import java.util.Arrays;
class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        StringBuilder vowels = new StringBuilder();

        // Collect vowels
        for (char c : chars) {
            if (isVowel(c)) {
                vowels.append(c);
            }
        }

        // Sort vowels by ASCII value
        char[] sortedVowels = vowels.toString().toCharArray();
        Arrays.sort(sortedVowels);

        // Replace vowels while preserving consonants
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                chars[i] = sortedVowels[index++];
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
