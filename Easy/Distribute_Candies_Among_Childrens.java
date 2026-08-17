/*
LeetCode: Distribute Candies Among Children I

Question:
You are given two positive integers n and limit.

Return the total number of ways to distribute n candies among
3 children such that no child gets more than limit candies.

Example:
Input: n = 5, limit = 2
Output: 3

Explanation:
The valid distributions are:
(1, 2, 2)
(2, 1, 2)
(2, 2, 1)
*/

class Solution {
    public long distributeCandies(int n, int limit) {
        long count = 0;

        for (int a = 0; a <= limit; a++) {
            for (int b = 0; b <= limit; b++) {

                // Remaining candies go to the third child
                int c = n - a - b;

                // Check if the third child also satisfies the limit
                if (c >= 0 && c <= limit) {
                    count++;
                }
            }
        }

        return count;
    }
}
