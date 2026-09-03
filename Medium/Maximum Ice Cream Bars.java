/*
LeetCode 1833 - Maximum Ice Cream Bars

Problem:
Given an array costs[] and coins, find the maximum number
of ice cream bars that can be bought.

The ice cream bars can be bought in any order.

IMPORTANT:
The problem requires using Counting Sort.

Approach:
1. Create a count[] array where index = price.
2. Store how many ice creams have each price.
3. Start from the cheapest price.
4. Buy as many ice creams as possible at that price.
5. Subtract the cost from coins.
6. Continue until coins are not enough.

Example:
costs = [1,3,2,4,1], coins = 7

Price frequencies:
1 -> 2
2 -> 1
3 -> 1
4 -> 1

Buy:
1 + 1 + 2 + 3 = 7

Answer = 4

Time Complexity: O(n + maxCost)
Space Complexity: O(maxCost)
*/

class Solution {
    public int maxIceCream(int[] costs, int coins) {

        int maxCost = 100000;

        // Counting Sort array
        int[] count = new int[maxCost + 1];

        // Count frequency of each price
        for (int cost : costs) {
            count[cost]++;
        }

        int ans = 0;

        // Start from cheapest ice cream
        for (int cost = 1; cost <= maxCost; cost++) {

            if (count[cost] == 0)
                continue;

            // Maximum ice creams we can buy at this price
            int canBuy = Math.min(count[cost], coins / cost);

            ans += canBuy;
            coins -= canBuy * cost;

            // Cannot afford the next ice cream
            if (coins < cost)
                break;
        }

        return ans;
    }
}
