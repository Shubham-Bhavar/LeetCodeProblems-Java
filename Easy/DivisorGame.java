/*Question:
Alice and Bob take turns. Starting with a number n, a player chooses a divisor x such that:
0 < x < n
n % x == 0
Then replaces n with n - x.
If a player cannot make a move, they lose.
Goal: Return true if Alice wins, otherwise false.*/
class Solution 
{
    public boolean divisorGame(int n) 
     {

          // If n is even, Alice wins
          // If n is odd, Alice loses
         return n % 2 == 0;
     }
}
