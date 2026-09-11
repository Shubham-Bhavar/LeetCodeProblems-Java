```java id="5q3m9x"
/*
LeetCode 3461 - Check If Digits Are Equal in String After Operations I

Problem:
Given a string s containing digits, repeatedly perform this operation:

For every pair of consecutive digits:
    new digit = (first digit + second digit) % 10

Continue until exactly two digits remain.

Return true if the final two digits are equal.

Example:
Input:  s = "3902"

Operation 1:
3 + 9 = 12 % 10 = 2
9 + 0 =  9 % 10 = 9
0 + 2 =  2 % 10 = 2

"3902" -> "292"

Operation 2:
2 + 9 = 11 % 10 = 1
9 + 2 = 11 % 10 = 1

"292" -> "11"

Final digits are equal, so answer = true.


Approach:
1. Convert the string into a character array.
2. While the length is greater than 2:
   - Calculate the next digits.
   - Store them in the same array.
   - Reduce the effective length by 1.
3. Compare the final two digits.

Time Complexity: O(n^2)
Space Complexity: O(n)
*/

class Solution {
    public boolean hasSameDigits(String s) {

        char[] digits = s.toCharArray();

        int n = digits.length;

        while(n > 2)
        {
            for(int i = 0; i < n - 1; i++)
            {
                int first = digits[i] - '0';
                int second = digits[i + 1] - '0';

                int sum = (first + second) % 10;

                digits[i] = (char)(sum + '0');
            }

            n--;
        }

        return digits[0] == digits[1];
    }
}
```
