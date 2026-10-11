/*
 * LeetCode 761: Special Binary String
 *
 * Problem:
 * A special binary string has equal numbers of 0s and 1s,
 * and every prefix contains at least as many 1s as 0s.
 *
 * Swap consecutive special substrings to obtain the
 * lexicographically largest possible string.
 *
 * Example 1:
 * Input:  s = "11011000"
 * Output: "11100100"
 *
 * Example 2:
 * Input:  s = "10"
 * Output: "10"
 *
 * Constraints:
 * 1 <= s.length <= 50
 * s contains only '0' and '1'.
 *
 * Approach:
 * 1. Split s into special substrings using a balance counter.
 * 2. Recursively maximize each substring's inner part.
 * 3. Sort the resulting substrings in descending order.
 * 4. Join them to form the largest string.
 *
 * Time Complexity: O(n^2) approximately
 * Space Complexity: O(n^2) including recursive strings
 */

import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> parts = new ArrayList<>();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                balance++;
            } else {
                balance--;
            }

            // Found one complete special substring
            if (balance == 0) {
                String inner = s.substring(start + 1, i);
                String special = "1"
                        + makeLargestSpecial(inner)
                        + "0";

                parts.add(special);
                start = i + 1;
            }
        }

        // Sort in descending lexicographical order
        parts.sort(Collections.reverseOrder());

        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            result.append(part);
        }

        return result.toString();
    }
}
