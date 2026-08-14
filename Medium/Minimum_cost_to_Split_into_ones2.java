/*
Question:
Given an integer n, split it into n ones.

The cost of splitting x into a and b is a * b.

Return the minimum total cost.

Example:
n = 4

4 -> 1 + 3  cost = 3
3 -> 1 + 2  cost = 2
2 -> 1 + 1  cost = 1

Total = 6
*/

class Solution {
    public int minCost(int n) {

        return n * (n - 1) / 2;
    }
}
