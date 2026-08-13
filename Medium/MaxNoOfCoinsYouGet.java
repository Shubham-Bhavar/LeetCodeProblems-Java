/*
Question:
There are 3n piles of coins.

In each step:
1. Alice picks the largest pile.
2. You pick the next largest pile.
3. Bob gets the remaining smallest pile.

Find the maximum number of coins you can get.

Example:
Input: piles = [2,4,1,2,7,8]
Output: 9

Explanation:
Sorted piles = [1,2,2,4,7,8]

Alice takes 8, you take 7, Bob takes 1
Alice takes 4, you take 2, Bob takes 2

Your total = 7 + 2 = 9
*/

import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {

        // Sort piles in ascending order
        Arrays.sort(piles);

        int sum = 0;

        // Start from the second largest pile
        int index = piles.length - 2;

        // You get n piles
        int count = piles.length / 3;

        for (int i = 0; i < count; i++) {

            // Take the second largest available pile
            sum += piles[index];

            // Skip Alice's largest pile
            index -= 2;
        }

        return sum;
    }
}
