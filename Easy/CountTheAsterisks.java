/*Q) You are given a string s, where every two consecutive '|' form a pair.

Return the number of '*' in s, excluding those '*' that are present between each pair of '|'.*/

class Solution {
    public int countAsterisks(String s) {
        int count = 0;
        boolean inside = false;

        for (char ch : s.toCharArray()) {
            if (ch == '|') {
                inside = !inside;
            } else if (ch == '*' && !inside) {
                count++;
            }
        }

        return count;
    }
}
