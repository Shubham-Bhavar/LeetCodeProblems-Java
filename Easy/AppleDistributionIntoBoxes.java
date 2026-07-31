/*
Question (Short):
Given apple[] (total apples in packs) and capacity[] (box capacities),
find minimum number of boxes needed such that total capacity
>= total apples.
*/

import java.util.*;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;

        // Total apples
        for (int a : apple) {
            totalApples += a;
        }

        // Sort capacities in descending order
        Arrays.sort(capacity);

        int count = 0;
        int currentCapacity = 0;

        // Pick largest boxes first
        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            count++;

            if (currentCapacity >= totalApples) {
                return count;
            }
        }

        return count; // always possible as per constraint
    }
}
