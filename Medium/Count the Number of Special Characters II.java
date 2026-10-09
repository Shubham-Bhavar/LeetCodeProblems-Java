/*
 * LeetCode 3121: Count the Number of Special Characters II
 *
 * Problem:
 * A letter is special if:
 * 1. It appears in both lowercase and uppercase.
 * 2. Every lowercase occurrence appears before the first
 *    uppercase occurrence.
 *
 * Return the number of special letters.
 *
 * Example 1:
 * Input:  word = "aaAbcBC"
 * Output: 3
 *
 * Example 2:
 * Input:  word = "abc"
 * Output: 0
 *
 * Example 3:
 * Input:  word = "AbBCab"
 * Output: 0
 *
 * Constraints:
 * 1 <= word.length <= 200000
 *
 * Approach:
 * 1. Store the first uppercase position of every letter.
 * 2. Store the last lowercase position of every letter.
 * 3. A letter is special if both positions exist and
 *    the last lowercase position is before the first
 *    uppercase position.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1), because there are only 26 letters.
 */

class Solution {
    public int numberOfSpecialChars(String word) {

        int[] firstUpper = new int[26];
        int[] lastLower = new int[26];

        // -1 means the character does not exist
        java.util.Arrays.fill(firstUpper, -1);
        java.util.Arrays.fill(lastLower, -1);

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (Character.isUpperCase(ch)) {

                int index = ch - 'A';

                if (firstUpper[index] == -1) {
                    firstUpper[index] = i;
                }

            } else {

                int index = ch - 'a';
                lastLower[index] = i;
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {

            if (lastLower[i] != -1 &&
                firstUpper[i] != -1 &&
                lastLower[i] < firstUpper[i]) {

                count++;
            }
        }

        return count;
    }
}
