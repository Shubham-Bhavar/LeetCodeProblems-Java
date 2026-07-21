// Problem: Length of Last Word
// Approach: Traverse from end
// 1. Skip trailing spaces
// 2. Count characters of last word

class Solution {
    public int lengthOfLastWord(String s) {

        int length = 0;
        int i = s.length() - 1;

        // Step 1: skip spaces at end
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: count last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
