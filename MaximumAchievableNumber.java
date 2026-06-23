
/*Problem: The Maximum Achievable Number

Description:
Given two integers num and t, return the maximum possible value of x
that can become equal to num after applying the given operation
at most t times.

Approach:
Each operation increases the maximum achievable value by 2.
Therefore, the answer is:
num + (2 * t)*/

class Solution {
    public int theMaximumAchievableX(int num, int t) {
        
        // Each operation changes the gap between x and num by 2
        
        // Therefore, after t operations:
        // x = num + 2*t
        //for simplification x-t=num+1;
        
        return num + (2 * t);
    }
}
