// Problem: Longest Common Prefix
// Approach (Beginner Friendly):
// Compare characters of first string with all other strings
// Time Complexity: O(n * m)

class Solution {
    public String longestCommonPrefix(String[] strs) {

        // edge case
        if (strs == null || strs.length == 0) return "";

        String first = strs[0];

        // loop through characters of first string
        for (int i = 0; i < first.length(); i++) {

            char ch = first.charAt(i);

            // compare with other strings
            for (int j = 1; j < strs.length; j++) {

                // if index out of bound OR mismatch
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return first.substring(0, i);
                }
            }
        }

        return first; // all matched
    }
}
