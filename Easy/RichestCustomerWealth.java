/*You are given a 2D array accounts.

Each row represents a customer.
Each column represents money in a bank account.

Return the wealth of the richest customer.

Example
Input:
accounts = [[1,2,3],[3,2,1]]

Output:
6

Explanation:

Customer 1 = 1+2+3 = 6
Customer 2 = 3+2+1 = 6

Richest wealth = 6.*/


class Solution {
    public int maximumWealth(int[][] accounts) {

        // Store maximum wealth found so far
        int maxWealth = 0;

        // Traverse each customer
        for (int[] customer : accounts) {

            // Calculate current customer's wealth
            int wealth = 0;

            for (int money : customer) {
                wealth += money;
            }

            // Update maximum wealth
            maxWealth = Math.max(maxWealth, wealth);
        }

        return maxWealth;
    }
}
