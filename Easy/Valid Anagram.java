/*
 * ============================================================
 * LeetCode 242: Valid Anagram
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * Given two strings s and t, return true if t is an anagram
 * of s, and false otherwise.
 *
 * An anagram is a word or phrase formed by rearranging the
 * letters of another word or phrase using all the original
 * letters exactly once.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * s = "anagram"
 * t = "nagaram"
 *
 * Output:
 * true
 *
 * Explanation:
 * Both strings contain:
 * a -> 3
 * n -> 1
 * g -> 1
 * r -> 1
 * m -> 1
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * s = "rat"
 * t = "car"
 *
 * Output:
 * false
 *
 * Explanation:
 * The characters are different.
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * Use an integer array of size 26.
 *
 * For every character in s:
 *     increase its frequency.
 *
 * For every character in t:
 *     decrease its frequency.
 *
 * If s and t are anagrams, every frequency must become 0.
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(1)
 *
 * The frequency array always contains only 26 elements.
 *
 * ============================================================
 */

class Solution {

    public boolean isAnagram(String s, String t) {

        // Anagrams must have the same length
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int[] count = new int[26];

        // Count characters from s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Remove characters using t
        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        // Every frequency must be zero
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
