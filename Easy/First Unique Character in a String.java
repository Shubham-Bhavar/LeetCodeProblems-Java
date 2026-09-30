/*
 * ============================================================
 * LeetCode 387: First Unique Character in a String
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * Given a string s, find the first non-repeating character
 * and return its index.
 *
 * If there is no non-repeating character, return -1.
 *
 * The string contains only lowercase English letters.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * s = "leetcode"
 *
 * Output:
 * 0
 *
 * Explanation:
 * 'l' occurs only once and is the first non-repeating character.
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * s = "loveleetcode"
 *
 * Output:
 * 2
 *
 * Explanation:
 * 'l' occurs more than once,
 * 'o' occurs more than once,
 * 'v' occurs only once.
 *
 * Therefore, the answer is index 2.
 *
 * ------------------------------------------------------------
 * Example 3:
 * ------------------------------------------------------------
 *
 * Input:
 * s = "aabb"
 *
 * Output:
 * -1
 *
 * Explanation:
 * Every character appears more than once.
 *
 * ------------------------------------------------------------
 * Constraints:
 * ------------------------------------------------------------
 *
 * 1 <= s.length <= 10^5
 * s consists of only lowercase English letters.
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * We use an integer array of size 26.
 *
 * Step 1:
 * Count how many times each character appears.
 *
 * Step 2:
 * Traverse the string from left to right.
 *
 * The first character whose frequency is 1 is the answer.
 *
 * If no character has frequency 1, return -1.
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(1)
 *
 * The frequency array always contains only 26 elements.
 *
 * ============================================================
 */

class Solution {

    public int firstUniqChar(String s) {

        // Store frequency of each character
        int[] count = new int[26];

        // Step 1: Count every character
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Step 2: Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {

            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // No unique character found
        return -1;
    }
}
