
/*
 * Problem: 1433. Check If a String Can Break Another String
 * Difficulty: Medium
 * Language: Java
 *
 * Approach:
 * 1. Convert both strings into character arrays.
 * 2. Sort both arrays.
 * 3. Check if s1 can break s2.
 * 4. Check if s2 can break s1.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        boolean first = true;
        boolean second = true;

        for (int i = 0; i < a.length; i++) {

            if (a[i] < b[i]) {
                first = false;
            }

            if (b[i] < a[i]) {
                second = false;
            }
        }

        return first || second;
    }
}
