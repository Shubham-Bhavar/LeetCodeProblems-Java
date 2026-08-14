/*
Question:
Given an integer n, split it into n ones.
The cost of splitting x into a and b is a * b.

Return the minimum total cost.

Example:
Input: n = 4
Output: 6

Explanation:
4 -> 1 + 3, cost = 3
3 -> 1 + 2, cost = 2
2 -> 1 + 1, cost = 1

Total cost = 3 + 2 + 1 = 6
*/

class Solution {
    public int minCost(int n) {

        int cost = 0;

        // Add costs from n-1 down to 1
        for (int i = n - 1; i >= 1; i--) {
            cost += i;
        }

        return cost;
    }
}
