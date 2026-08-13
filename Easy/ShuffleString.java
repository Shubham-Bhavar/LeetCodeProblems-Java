/*
Question:
Given a string s and an integer array indices of the same length,
shuffle the string such that:

The character at position i moves to position indices[i].

Return the shuffled string.

Example:
Input:  s = "codeleet"
        indices = [4,5,6,7,0,2,1,3]

Output: "leetcode"
*/

class Solution {
    public String restoreString(String s, int[] indices) {

        char[] result = new char[s.length()];

        // Place each character at its required position
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }

        // Convert character array to string
        return new String(result);
    }
}
