/*
LeetCode 1780: Check if Number is a Sum of Powers of Three
Difficulty: Medium
Topics: Math, Greedy

Approach:
1. Convert n into base 3.
2. If any base-3 digit is 2, return false.
3. Otherwise, return true because each power of 3 is used at most once.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }

        return true;
    }
}
