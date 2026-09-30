/*
 * ============================================================
 * LeetCode 383: Ransom Note
 * ============================================================
 *
 * Problem:
 * ------------------------------------------------------------
 * Given two strings ransomNote and magazine, return true if
 * ransomNote can be constructed using the letters from
 * magazine.
 *
 * Each letter in magazine can be used only once.
 *
 * Both strings contain only lowercase English letters.
 *
 * ------------------------------------------------------------
 * Example 1:
 * ------------------------------------------------------------
 *
 * Input:
 * ransomNote = "a"
 * magazine = "b"
 *
 * Output:
 * false
 *
 * ------------------------------------------------------------
 * Example 2:
 * ------------------------------------------------------------
 *
 * Input:
 * ransomNote = "aa"
 * magazine = "ab"
 *
 * Output:
 * false
 *
 * Explanation:
 * We need two 'a' characters, but magazine contains only one.
 *
 * ------------------------------------------------------------
 * Example 3:
 * ------------------------------------------------------------
 *
 * Input:
 * ransomNote = "aa"
 * magazine = "aab"
 *
 * Output:
 * true
 *
 * Explanation:
 * magazine contains two 'a' characters.
 *
 * ------------------------------------------------------------
 * Constraints:
 * ------------------------------------------------------------
 *
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 *
 * ------------------------------------------------------------
 * Approach:
 * ------------------------------------------------------------
 *
 * Since there are only 26 lowercase English letters, we can
 * use an integer array of size 26.
 *
 * Step 1:
 * Count every character in magazine.
 *
 * Step 2:
 * For every character in ransomNote:
 * - Decrease its count.
 * - If the count becomes negative, magazine does not contain
 *   enough copies of that character.
 *
 * ------------------------------------------------------------
 * Complexity:
 * ------------------------------------------------------------
 *
 * Time Complexity: O(n + m)
 *
 * Space Complexity: O(1)
 *
 * The array always has only 26 elements.
 *
 * ============================================================
 */

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        // Count frequency of each character in magazine
        int[] count = new int[26];

        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }

        // Use characters from magazine to build ransomNote
        for (char ch : ransomNote.toCharArray()) {

            count[ch - 'a']--;

            // Not enough copies of this character
            if (count[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
