/*
Problem: Score of a String

Description:
The score of a string is the sum of the absolute difference
between the ASCII values of adjacent characters.

Approach:
- Traverse the string.
- Find the absolute difference between adjacent characters.
- Add all differences to get the score.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int scoreOfString(String s) {

        int score = 0;

        // Traverse adjacent character pairs
        for (int i = 0; i < s.length() - 1; i++) {

            // Calculate absolute ASCII difference
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }

        return score;
    }
}
