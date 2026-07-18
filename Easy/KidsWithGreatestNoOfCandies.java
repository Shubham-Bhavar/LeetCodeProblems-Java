/*There are n kids.

You are given:

candies[i] = candies owned by the ith kid.
extraCandies = extra candies.

For each kid, check whether giving all extra candies to that kid makes them have the greatest number of candies.

Return a list of boolean values.

Example
Input:
candies = [2,3,5,1,3]
extraCandies = 3

Output:
[true,true,true,false,true]
Code*/
import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        // Find maximum candies among all kids
        int max = 0;

        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        // Store answers
        List<Boolean> result = new ArrayList<>();

        // Check each kid
        for (int candy : candies) {

            // If current kid can reach maximum
            result.add(candy + extraCandies >= max);
        }

        return result;
    }
}
