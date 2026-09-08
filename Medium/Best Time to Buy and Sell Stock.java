/*
LeetCode 121 - Best Time to Buy and Sell Stock

Problem:
Given an array prices where prices[i] is the stock price on the ith day,
choose one day to buy and a different future day to sell.

Return the maximum profit possible.
If no profit is possible, return 0.

Example 1:
Input:  prices = [7,1,5,3,6,4]
Output: 5

Example 2:
Input:  prices = [7,6,4,3,1]
Output: 0


Approach:
1. Keep track of the minimum price seen so far.
2. For every price, calculate the profit if we sell today.
3. Update the maximum profit.
4. Update the minimum price when a smaller price is found.

Formula:
profit = currentPrice - minimumPrice

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++)
        {
            // Update minimum buying price
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate profit if we sell today
            int profit = prices[i] - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
