/*
 * LeetCode 1910: Remove All Occurrences of a Substring
 *
 * Question:
 * Remove the leftmost occurrence of part repeatedly until
 * no occurrence remains.
 *
 * Approach:
 * 1. Find part in s.
 * 2. Remove it using substring().
 * 3. Repeat until part is not found.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int i = s.indexOf(part);
            s = s.substring(0, i) + s.substring(i + part.length());
        }
        return s;
    }
}
