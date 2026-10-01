/*
 * ============================================================
 * LeetCode 1347: Minimum Number of Steps to Make Two Strings Anagram
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * Given two strings s and t of the same length, in one step
 * we can replace any character of t with another character.
 *
 * Return the minimum number of replacements needed to make
 * t an anagram of s.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * s = "bab"
 * t = "aba"
 *
 * Output:
 * 1
 *
 * Explanation:
 * Replace one 'a' in t with 'b':
 *
 * "aba" -> "bba"
 *
 * Now both strings contain:
 *     a -> 1
 *     b -> 2
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * s = "leetcode"
 * t = "practice"
 *
 * Output:
 * 5
 *
 * ------------------------------------------------------------
 * Example 3:
 * ------------------------------------------------------------
 *
 * Input:
 * s = "anagram"
 * t = "mangaar"
 *
 * Output:
 * 0
 *
 * They are already anagrams.
 *
 * ------------------------------------------------------------
 * Constraints:
 * ------------------------------------------------------------
 *
 * 1 <= s.length <= 5 * 10^4
 * s.length == t.length
 * s and t contain lowercase English letters.
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * Count the characters of s.
 *
 * Then subtract the characters of t.
 *
 * If a character has a positive count, s needs more copies
 * of that character.
 *
 * The total positive count is the number of replacements
 * needed.
 *
 * ------------------------------------------------------------
 * Example:
 *
 * s = "bab"
 * t = "aba"
 *
 * Count difference:
 *
 * b -> s has 2, t has 1 -> need 1 b
 * a -> s has 1, t has 2 -> extra 1 a
 *
 * We only count the characters that s needs.
 *
 * Answer = 1
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Only 26 lowercase letters are stored.
 *
 * ============================================================
 */

class Solution {

    public int minSteps(String s, String t) {

        int[] count = new int[26];

        // Count characters in s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Remove characters available in t
        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        // Count characters that are still needed
        int steps = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                steps += count[i];
            }
        }

        return steps;
    }
}
