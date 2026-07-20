// Problem: Find the Index of the First Occurrence in a String
// Approach (Beginner Friendly):
// Check each position in haystack and try to match needle
// Time Complexity: O(n * m)

class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // loop through haystack
        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            // check substring match
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // if full match found
            if (j == m) {
                return i;
            }
        }

        return -1; // not found
    }
}
