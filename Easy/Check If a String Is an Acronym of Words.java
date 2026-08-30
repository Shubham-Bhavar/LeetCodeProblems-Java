/*
LeetCode: Check If a String Is an Acronym of Words

Approach:
1. Check if number of words equals length of s.
2. Compare the first character of each word with s.
3. If any character does not match, return false.
4. If all characters match, return true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isAcronym(List<String> words, String s) {

        // Number of words must equal length of s
        if (words.size() != s.length()) {
            return false;
        }

        for (int i = 0; i < words.size(); i++) {

            // Compare first character of each word
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
