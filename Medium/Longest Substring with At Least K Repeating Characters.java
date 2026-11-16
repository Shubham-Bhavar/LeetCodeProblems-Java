
/*
 * LeetCode 395: Longest Substring with At Least K Repeating Characters
 *
 * Problem Statement:
 * Given a string s and an integer k, return the length of the
 * longest substring in which every character appears at least k times.
 *
 * If no valid substring exists, return 0.
 *
 * Approach: Divide and Conquer
 *
 * Step-by-Step Explanation:
 * 1. If the substring length is smaller than k, return 0.
 * 2. Create a frequency array to count each character.
 * 3. Find characters whose frequency is less than k.
 * 4. Such characters cannot belong to any valid substring.
 * 5. Split the string around these invalid characters.
 * 6. Recursively find the longest valid substring in each part.
 * 7. Return the maximum length.
 * 8. If every character appears at least k times, return the
 *    entire substring length.
 *
 * Time Complexity: O(n^2) worst case
 * Space Complexity: O(n) due to recursion.
 */

class Solution {

    public int longestSubstring(String s, int k) {

        // If substring length is smaller than k,
        // no character can satisfy the condition
        if (s.length() < k) {
            return 0;
        }

        // Count frequency of each character
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find characters that appear fewer than k times
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (freq[ch - 'a'] < k) {

                // Split the string around the invalid character
                int left = longestSubstring(s.substring(0, i), k);

                int right = longestSubstring(s.substring(i + 1), k);

                return Math.max(left, right);
            }
        }

        // Every character appears at least k times
        return s.length();
    }
}
