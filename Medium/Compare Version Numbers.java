/*
 * LeetCode: 165. Compare Version Numbers
 *
 * Problem:
 * Given two version strings version1 and version2, compare them.
 *
 * Each version consists of revisions separated by '.'.
 * Leading zeros in a revision are ignored.
 *
 * Return:
 *   -1 if version1 < version2
 *    1 if version1 > version2
 *    0 if version1 == version2
 *
 * Example 1:
 * Input:
 * version1 = "1.2"
 * version2 = "1.10"
 *
 * Output:
 * -1
 *
 * Explanation:
 * 2 < 10
 *
 * Example 2:
 * Input:
 * version1 = "1.01"
 * version2 = "1.001"
 *
 * Output:
 * 0
 *
 * Explanation:
 * 01 and 001 both represent 1.
 *
 * Example 3:
 * Input:
 * version1 = "1.0"
 * version2 = "1.0.0.0"
 *
 * Output:
 * 0
 *
 * Missing revisions are treated as 0.
 *
 * ---------------------------------------------------------
 * Approach:
 * ---------------------------------------------------------
 *
 * Use two pointers to process each revision.
 *
 * For every revision:
 * 1. Read the number until '.'.
 * 2. Convert it to an integer.
 * 3. Compare the two revision values.
 * 4. If equal, move to the next revision.
 *
 * If one version has fewer revisions, its missing revisions
 * are considered 0.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

class Solution {

    public int compareVersion(String version1, String version2) {

        int i = 0;
        int j = 0;

        int n = version1.length();
        int m = version2.length();

        while (i < n || j < m) {

            int num1 = 0;
            int num2 = 0;

            // Read revision from version1
            while (i < n && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            // Read revision from version2
            while (j < m && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            // Compare current revisions
            if (num1 < num2) {
                return -1;
            }

            if (num1 > num2) {
                return 1;
            }

            // Skip '.'
            if (i < n) {
                i++;
            }

            if (j < m) {
                j++;
            }
        }

        return 0;
    }
}
