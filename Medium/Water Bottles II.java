/*
LeetCode 3100 - Water Bottles II

Problem:
You have numBottles full bottles.

- Drink a full bottle -> get 1 empty bottle.
- Exchange numExchange empty bottles -> get 1 full bottle.
- After every exchange, numExchange increases by 1.

Return the maximum number of bottles you can drink.

Example:
Input:  numBottles = 13, numExchange = 6
Output: 15

Approach:
- Drink all available full bottles.
- Keep track of empty bottles.
- If enough empty bottles are available, exchange them for 1 full bottle.
- Increase numExchange after every exchange.
- Repeat until another exchange is not possible.
*/

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {

        int ans = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {

            empty -= numExchange;  // exchange empty bottles
            numExchange++;         // exchange value increases

            ans++;                 // drink the new full bottle
            empty++;               // it becomes empty
        }

        return ans;
    }
}
