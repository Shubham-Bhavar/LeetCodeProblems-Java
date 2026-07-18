/*
Question:
Two string arrays are given.

Join all strings of each array and check
whether both final strings are equal.

Example:
word1 = ["ab", "c"]
word2 = ["a", "bc"]

Output: true
Because both become "abc"
*/

class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        // Join all strings from first array
        String s1 = String.join("", word1);

        // Join all strings from second array
        String s2 = String.join("", word2);

        // Compare both strings
        return s1.equals(s2);
    }
}
