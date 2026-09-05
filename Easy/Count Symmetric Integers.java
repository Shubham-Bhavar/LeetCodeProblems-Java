/*
===========================================================
LeetCode 2843 - Count Symmetric Integers
===========================================================

Problem:
Given two positive integers low and high, count the integers
in the range [low, high] that are symmetric.

An integer is symmetric if:
- It has an even number of digits.
- The sum of the first half of its digits is equal to the
  sum of the second half.

Example:
Input:  low = 1, high = 100
Output: 9

Symmetric numbers:
11, 22, 33, 44, 55, 66, 77, 88, 99

-----------------------------------------------------------
Approach:
-----------------------------------------------------------
1. Check every number from low to high.
2. Convert the number into a string.
3. If the number of digits is odd, ignore it.
4. Find the sum of the first half of the digits.
5. Find the sum of the second half.
6. If both sums are equal, increase the answer.

-----------------------------------------------------------
Example:
-----------------------------------------------------------

x = 1212

First half:
1 + 2 = 3

Second half:
1 + 2 = 3

Therefore, 1212 is symmetric.

-----------------------------------------------------------
Time Complexity: O((high - low + 1) * d)
Space Complexity: O(d)

where d <= 5
-----------------------------------------------------------
*/

class Solution {
    public int countSymmetricIntegers(int low, int high) 
    {
        int ans = 0;

        for(int num = low; num <= high; num++)
        {
            String s = String.valueOf(num);

            // Odd number of digits can never be symmetric
            if(s.length() % 2 != 0)
                continue;

            int n = s.length() / 2;

            int firstSum = 0;
            int secondSum = 0;

            // Sum of first half
            for(int i = 0; i < n; i++)
            {
                firstSum += s.charAt(i) - '0';
            }

            // Sum of second half
            for(int i = n; i < s.length(); i++)
            {
                secondSum += s.charAt(i) - '0';
            }

            if(firstSum == secondSum)
            {
                ans++;
            }
        }

        return ans;
    }
}
