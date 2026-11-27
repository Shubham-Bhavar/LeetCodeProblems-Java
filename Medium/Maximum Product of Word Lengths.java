
/*
 * LeetCode 318: Maximum Product of Word Lengths
 *
 * Approach: Bit Manipulation
 *
 * 1. Create a bitmask for each word.
 * 2. Each bit represents one English letter.
 * 3. If (mask[i] & mask[j]) == 0,
 *    the words have no common letters.
 * 4. Calculate the maximum product of their lengths.
 *
 * Time Complexity: O(n * L + n^2)
 * Space Complexity: O(n)
 *
 * n = number of words
 * L = maximum word length
 */

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];

        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans,
                        words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }
}
