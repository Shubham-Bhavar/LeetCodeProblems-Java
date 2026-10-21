/*
 * Problem: 3863. Minimum Operations to Sort a String
 * Difficulty: Medium
 * Topics: String, Greedy
 *
 * Approach:
 * 1. Check if the string is already sorted.
 * 2. Find the minimum and maximum characters.
 * 3. If the string length is 2 and it is unsorted, return -1.
 * 4. If the first character is the minimum or the last
 *    character is the maximum, return 1.
 * 5. If the minimum or maximum character appears in the
 *    middle, return 2.
 * 6. Otherwise, return 3.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char[] chars = s.toCharArray();
        char min = chars[0];
        char max = chars[0];
        boolean isSorted = true;

        for (int i = 1; i < n; i++) {
            min = (char) Math.min(min, chars[i]);
            max = (char) Math.max(max, chars[i]);

            if (chars[i] < chars[i - 1]) {
                isSorted = false;
            }
        }

        if (isSorted) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        if (chars[0] == min || chars[n - 1] == max) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {
            if (chars[i] == min || chars[i] == max) {
                return 2;
            }
        }

        return 3;
    }
}