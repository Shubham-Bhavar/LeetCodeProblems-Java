/*
========================================================
LeetCode 67 - Add Binary
========================================================

Problem:
--------
Given two binary strings a and b, return their sum as
a binary string.

Example 1:
----------
Input:
a = "11"
b = "1"

Output:
"100"

Example 2:
----------
Input:
a = "1010"
b = "1011"

Output:
"10101"

--------------------------------------------------------
Approach:
--------------------------------------------------------

1. Start from the last character of both strings.

2. Add the two binary digits and carry.

3. Calculate:
       sum = digitA + digitB + carry

4. The result digit is:
       sum % 2

5. The new carry is:
       sum / 2

6. Move both pointers to the left.

7. Continue until both strings and carry are finished.

8. Since we calculate from right to left, use
   StringBuilder and reverse the result at the end.

--------------------------------------------------------
Binary Addition:
--------------------------------------------------------

0 + 0 = 0
0 + 1 = 1
1 + 0 = 1
1 + 1 = 10  -> digit = 0, carry = 1

--------------------------------------------------------
Complexity:
--------------------------------------------------------

Time Complexity  : O(max(n, m))
Space Complexity : O(max(n, m))

========================================================
*/

class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder result = new StringBuilder();

        // Continue while digits or carry are present
        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            // Add digit from a
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            // Add digit from b
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Add current binary digit
            result.append(sum % 2);

            // Calculate carry
            carry = sum / 2;
        }

        // We calculated from right to left
        return result.reverse().toString();
    }
}
