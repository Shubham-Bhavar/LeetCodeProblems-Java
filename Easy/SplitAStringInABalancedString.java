/*
Question:
Given a balanced string s containing 'L' and 'R',
split it into maximum number of balanced substrings.

A substring is balanced if count of 'L' == count of 'R'.
*/

class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;   // result
        int balance = 0; // track L and R

        for (char ch : s.toCharArray()) {
            if (ch == 'L') balance++;
            else balance--;

            if (balance == 0) count++; // found balanced substring
        }

        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.balancedStringSplit("RLRRLLRLRL")); // 4
    }
}
