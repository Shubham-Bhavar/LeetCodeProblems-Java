/*You are climbing a staircase with n steps. At each move, you can climb either 1 step or 2 steps. 
Find the total number of distinct ways to reach the top.
Short Notes
Observation:
To reach step n, you can come from:
Step n - 1 (by taking 1 step)
Step n - 2 (by taking 2 steps)
Formula:
f(n)=f(n−1)+f(n−2)
Base Cases:
f(1) = 1
f(2) = 2
Pattern: Fibonacci Sequence*/

class Solution {
    public int climbStairs(int n) {

        // If there are 1 or 2 steps
        if (n <= 2) {
            return n;
        }

        int first = 1;   // Ways to reach step 1
        int second = 2;  // Ways to reach step 2

        // Calculate ways for remaining steps
        for (int i = 3; i <= n; i++) {
            int current = first + second;

            // Update previous values
            first = second;
            second = current;
        }

        return second;
    }
}
