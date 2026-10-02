/*
 * LeetCode 1415: The k-th Lexicographical String of All Happy Strings
 *
 * A happy string:
 * - Contains only 'a', 'b', and 'c'
 * - No two adjacent characters are the same
 *
 * Return the k-th happy string in lexicographical order.
 * If there are fewer than k strings, return "".
 *
 * Example:
 * Input:  n = 3, k = 9
 * Output: "cab"
 *
 * Approach:
 * - Generate strings using DFS.
 * - Try 'a', 'b', and 'c'.
 * - Don't use the same character twice in a row.
 * - Every time a complete string is formed, decrease k.
 * - When k becomes 0, return that string.
 *
 * Time: O(3 * 2^(n - 1))
 * Space: O(n)
 */

class Solution {

    private int k;
    private String answer = "";

    public String getHappyString(int n, int k) {

        this.k = k;

        generate(n, "");

        return answer;
    }

    private void generate(int n, String s) {

        // Stop if answer is found
        if (!answer.equals("")) {
            return;
        }

        // Complete string
        if (s.length() == n) {
            k--;

            if (k == 0) {
                answer = s;
            }

            return;
        }

        // Try a, b, c
        for (char ch = 'a'; ch <= 'c'; ch++) {

            // Same adjacent character not allowed
            if (s.length() > 0 &&
                s.charAt(s.length() - 1) == ch) {
                continue;
            }

            generate(n, s + ch);
        }
    }
}
