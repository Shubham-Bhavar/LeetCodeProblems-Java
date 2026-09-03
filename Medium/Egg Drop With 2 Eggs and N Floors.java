/*
LeetCode 1884 - Egg Drop With 2 Eggs and N Floors

Approach:
With 2 eggs, we use decreasing jumps.

If we have k moves:
- First drop at floor k
- Then k + (k-1)
- Then k + (k-1) + (k-2)
- ...

So with k moves, we can check:

k + (k-1) + ... + 1 floors.

Find the smallest k for which this sum is >= n.

Example:
n = 100

14 + 13 + 12 + ... + 1 = 105

Therefore answer = 14.
*/

class Solution {
    public int twoEggDrop(int n) 
    {
        int moves = 0;
        int floors = 0;

        while(floors < n)
        {
            moves++;
            floors += moves;
        }

        return moves;
    }
}
