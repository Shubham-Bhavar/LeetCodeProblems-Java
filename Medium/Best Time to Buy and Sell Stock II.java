/*
LeetCode 122 - Best Time to Buy and Sell Stock II

Problem:
Given an integer array prices where prices[i] is the stock price
on the ith day, you can buy and sell stocks multiple times.

You can hold at most one stock at a time.

Return the maximum profit possible.

Example 1:
Input:  prices = [7,1,5,3,6,4]
Output: 7

Explanation:
Buy at 1 and sell at 5  -> profit = 4
Buy at 3 and sell at 6  -> profit = 3
Total profit = 7


Example 2:
Input:  prices = [1,2,3,4,5]
Output: 4

Explanation:
Profit = (2-1) + (3-2) + (4-3) + (5-4)
       = 4


Example 3:
Input:  prices = [7,6,4,3,1]
Output: 0


Approach:
We can make a profit whenever today's price is greater than
yesterday's price.

So, add:
    prices[i] - prices[i-1]

whenever:
    prices[i] > prices[i-1]

Why?
Every increasing part can be treated as a separate buy-sell
transaction.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;

        for(int i = 1; i < prices.length; i++)
        {
            // If price increased, take the profit
            if(prices[i] > prices[i - 1])
            {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
