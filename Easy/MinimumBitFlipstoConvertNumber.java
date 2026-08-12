/*
Question:
Given two integers start and goal, return the minimum number
of bit flips required to convert start into goal.

Key Idea:
XOR gives 1 at positions where the bits are different.

Therefore:
start ^ goal

Then count the number of set bits (1s).

Example:
start = 10  -> 1010
goal  = 7   -> 0111

1010
0111
----
1101

There are 3 set bits, so the answer is 3.
*/

class Solution {
    public int minBitFlips(int start, int goal) {

        // XOR gives 1 where bits are different
        int xor = start ^ goal;

        // Count the number of set bits
        int count = 0;

        while (xor > 0) {

            // Check the last bit
            count += xor & 1;

            // Move to the next bit
            xor = xor >> 1;
        }

        return count;
    }
}
