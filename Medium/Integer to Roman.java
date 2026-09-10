/*
LeetCode 12 - Integer to Roman

Problem:
Given an integer, convert it to a Roman numeral.

Roman values:
I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000

Subtractive forms:
4   = IV
9   = IX
40  = XL
90  = XC
400 = CD
900 = CM

Example 1:
Input:  3749
Output: "MMMDCCXLIX"

Example 2:
Input:  58
Output: "LVIII"

Example 3:
Input:  1994
Output: "MCMXCIV"


Approach:
Use Greedy approach.

1. Store Roman values from largest to smallest.
2. For each value:
   - Add its Roman symbol while num >= value.
   - Subtract the value from num.
3. Continue until num becomes 0.

Important:
Include subtractive values like 900, 400, 90, 40, 9 and 4.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public String intToRoman(int num) {

        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < values.length; i++)
        {
            while(num >= values[i])
            {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }
}
