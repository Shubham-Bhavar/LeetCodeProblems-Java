/*
Question:
Given a string s, remove every digit and the closest
non-digit character to its left.

Example:
Input:  s = "cb34"
Output: ""

Explanation:
c b 3 4
  ↑
3 removes b

c 4
  ↑
4 removes c

Result = ""
*/

class Solution {
    public String clearDigits(String s) {

        StringBuilder result = new StringBuilder();

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Add letters to the result
            if (Character.isLetter(ch)) {
                result.append(ch);
            }

            // Remove the closest letter on the left
            else {
                result.deleteCharAt(result.length() - 1);
            }
        }

        return result.toString();
    }
}
