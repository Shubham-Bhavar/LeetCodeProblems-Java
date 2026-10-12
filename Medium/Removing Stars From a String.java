/*
 * LeetCode 2390: Removing Stars From a String
 *
 * Problem:
 * For every star '*', remove the closest non-star character
 * to its left and remove the star itself.
 * Return the final string without stars.
 *
 * Example 1:
 * Input:  s = "leet**cod*e"
 * Output: "lecoe"
 *
 * Example 2:
 * Input:  s = "erase*****"
 * Output: ""
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s contains lowercase letters and '*'.
 *
 * Approach:
 * 1. Traverse the string character by character.
 * 2. If it is a letter, append it to the StringBuilder.
 * 3. If it is '*', delete the last character.
 * 4. Return the resulting string.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
