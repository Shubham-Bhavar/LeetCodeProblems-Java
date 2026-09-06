/*
LeetCode 2391 - Minimum Amount of Time to Collect Garbage

Approach:
1. Count the pickup time for M, P and G.
2. Find the last house where each garbage type exists.
3. Add travel time only up to that last house.
4. Total = pickup time + required travel time.

Time Complexity: O(n * 10) -> O(n)
Space Complexity: O(1)
*/

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) 
    {
        int total = 0;

        int lastM = 0;
        int lastP = 0;
        int lastG = 0;

        for(int i = 0; i < garbage.length; i++)
        {
            String s = garbage[i];

            // Pickup time
            total += s.length();

            // Last house for each garbage type
            if(s.indexOf('M') != -1)
                lastM = i;

            if(s.indexOf('P') != -1)
                lastP = i;

            if(s.indexOf('G') != -1)
                lastG = i;
        }

        // Travel time for each truck
        for(int i = 0; i < lastM; i++)
            total += travel[i];

        for(int i = 0; i < lastP; i++)
            total += travel[i];

        for(int i = 0; i < lastG; i++)
            total += travel[i];

        return total;
    }
}
