/**
 * LeetCode 3517: Smallest Palindromic Rearrangement I
 *
 * Approach:
 * 1. Count the frequency of each character.
 * 2. Build the first half in ascending order.
 * 3. Find the middle character if the length is odd.
 * 4. Append the reversed first half to form the palindrome.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        // Count character frequencies
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        char mid = '\0';

        // Build the first half in lexicographical order
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                half.append((char) ('a' + i));
            }

            if (freq[i] % 2 == 1) {
                mid = (char) ('a' + i);
            }
        }

        String firstHalf = half.toString();
        String secondHalf = new StringBuilder(firstHalf)
                .reverse()
                .toString();

        // Construct the smallest palindrome
        if (mid != '\0') {
            return firstHalf + mid + secondHalf;
        }

        return firstHalf + secondHalf;
    }
}
```
