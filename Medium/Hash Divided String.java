/*
 * LeetCode 3271: Hash Divided String
 *
 * Problem:
 * Divide string s into substrings of length k.
 * For each substring, calculate the sum of character values,
 * where 'a' = 0, 'b' = 1, ..., 'z' = 25.
 *
 * Take sum % 26 and convert the result into a character.
 * Append each resulting character to build the answer.
 *
 * Example 1:
 * Input:  s = "abcd", k = 2
 * Output: "bf"
 *
 * Example 2:
 * Input:  s = "mxz", k = 3
 * Output: "i"
 *
 * Constraints:
 * 1 <= k <= 100
 * k <= s.length() <= 1000
 * s.length() is divisible by k.
 * s contains only lowercase English letters.
 *
 * Approach:
 * 1. Process each substring of length k.
 * 2. Calculate the sum of its character values.
 * 3. Find sum % 26.
 * 4. Convert the result to a character and append it.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the result.
 */

class Solution {
    public String stringHash(String s, int k) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i += k) {

            int sum = 0;

            // Calculate hash sum for the current substring
            for (int j = i; j < i + k; j++) {
                sum += s.charAt(j) - 'a';
            }

            // Convert the hash value into a character
            char hashedChar = (char) ('a' + (sum % 26));

            result.append(hashedChar);
        }

        return result.toString();
    }
}
