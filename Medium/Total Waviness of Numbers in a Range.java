/*
===========================================================
LeetCode - Total Waviness of Numbers in a Range
===========================================================

PROBLEM:
Given an inclusive range [num1, num2], calculate the total
waviness of all numbers in the range.

A digit is:
- PEAK   : greater than both immediate neighbors.
- VALLEY : less than both immediate neighbors.

First and last digits cannot be peaks or valleys.

Numbers with fewer than 3 digits have waviness = 0.

-----------------------------------------------------------
EXAMPLE:
-----------------------------------------------------------

num1 = 120
num2 = 130

120 -> 2 is a peak -> waviness = 1
121 -> 2 is a peak -> waviness = 1
130 -> 3 is a peak -> waviness = 1

Total = 3

-----------------------------------------------------------
LOGIC:
-----------------------------------------------------------

1. Check every number from num1 to num2.
2. Convert the number into a string.
3. Check every middle digit.
4. If it is a peak or valley, increase count.
5. Add the waviness of each number to the answer.

===========================================================
*/

class Solution {
    public int totalWaviness(int num1, int num2) {

        int ans = 0;

        for (int num = num1; num <= num2; num++) {

            String s = String.valueOf(num);

            // Less than 3 digits -> waviness = 0
            if (s.length() < 3) {
                continue;
            }

            for (int i = 1; i < s.length() - 1; i++) {

                int left = s.charAt(i - 1) - '0';
                int curr = s.charAt(i) - '0';
                int right = s.charAt(i + 1) - '0';

                // Peak
                if (curr > left && curr > right) {
                    ans++;
                }

                // Valley
                else if (curr < left && curr < right) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
