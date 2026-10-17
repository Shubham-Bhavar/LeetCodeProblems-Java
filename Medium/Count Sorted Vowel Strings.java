/*
LeetCode 1641: Count Sorted Vowel Strings
Difficulty: Medium
Topics: Math, Dynamic Programming, Combinatorics

Approach:
1. Initialize counts for the five vowels as 1.
2. For each position, update counts from right to left.
3. The sum of all counts gives the answer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int countVowelStrings(int n) {
        int[] dp = {1, 1, 1, 1, 1};

        for (int i = 1; i < n; i++) {
            for (int j = 3; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }

        int answer = 0;

        for (int count : dp) {
            answer += count;
        }

        return answer;
    }
}
