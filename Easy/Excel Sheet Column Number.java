/*
 * LeetCode 171: Excel Sheet Column Number
 *
 * Problem:
 * Given a string columnTitle representing an Excel column title,
 * return its corresponding column number.
 *
 * Examples:
 * A  -> 1
 * B  -> 2
 * ...
 * Z  -> 26
 * AA -> 27
 * AB -> 28
 *
 * Example 1:
 * Input:  columnTitle = "A"
 * Output: 1
 *
 * Example 2:
 * Input:  columnTitle = "AB"
 * Output: 28
 *
 * Example 3:
 * Input:  columnTitle = "ZY"
 * Output: 701
 *
 * Approach:
 * Treat the column title like a number system with base 26.
 *
 * For every character:
 * 1. Convert character to its value:
 *      A = 1, B = 2, ..., Z = 26
 * 2. Multiply the previous answer by 26.
 * 3. Add the current character value.
 *
 * Formula:
 * answer = answer * 26 + (character - 'A' + 1)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int titleToNumber(String columnTitle) {

        int answer = 0;

        for (char ch : columnTitle.toCharArray()) {

            int value = ch - 'A' + 1;

            answer = answer * 26 + value;
        }

        return answer;
    }
}
