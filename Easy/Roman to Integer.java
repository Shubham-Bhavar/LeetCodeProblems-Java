/*
LeetCode 13 - Roman to Integer

Problem:
Given a Roman numeral, convert it to an integer.

Roman Values:
I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000

Examples:

Input: "III"
Output: 3

Input: "LVIII"
Output: 58

Input: "MCMXCIV"
Output: 1994

Approach:
- Check the current Roman value with the next value.
- If current value is smaller than next value, subtract it.
- Otherwise, add it.

Example:
IV = -1 + 5 = 4
IX = -1 + 10 = 9

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int romanToInt(String s) {

        int ans = 0;

        for(int i = 0; i < s.length(); i++)
        {
            int curr = value(s.charAt(i));

            if(i + 1 < s.length() &&
               curr < value(s.charAt(i + 1)))
            {
                ans -= curr;
            }
            else
            {
                ans += curr;
            }
        }

        return ans;
    }

    // Returns the integer value of a Roman symbol
    private int value(char c)
    {
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;

        return 1000; // M
    }
}
