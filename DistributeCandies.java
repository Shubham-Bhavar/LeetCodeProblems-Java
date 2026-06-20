/*
Question:
Alice has n candies where candyType[i] represents the type of
the ith candy. She can eat only n/2 candies.

Return the maximum number of different candy types she can eat.

Example:
Input: [1,1,2,2,3,3]
Output: 3
*/

import java.util.*;

class Solution {
    public int distributeCandies(int[] candyType) {

        // Store unique candy types
        HashSet<Integer> types = new HashSet<>();

        for (int candy : candyType) {
            types.add(candy);
        }

        // Return minimum of:
        // 1. Unique types
        // 2. Candies she can eat (n/2)
        return Math.min(types.size(), candyType.length / 2);
    }
}
