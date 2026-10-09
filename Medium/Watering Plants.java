/*
 * LeetCode 2079: Watering Plants
 *
 * Problem:
 * Plants are arranged in a row from index 0 to n - 1.
 * The river is located at position -1.
 *
 * Each plant needs plants[i] units of water.
 * The watering can has a capacity of capacity.
 *
 * Water plants from left to right.
 * If there is not enough water for the next plant,
 * return to the river and refill the watering can.
 *
 * Return the total number of steps needed to water all plants.
 *
 * Example 1:
 * Input:  plants = [2,2,3,3], capacity = 5
 * Output: 14
 *
 * Example 2:
 * Input:  plants = [1,1,1,4,2,3], capacity = 4
 * Output: 30
 *
 * Example 3:
 * Input:  plants = [7,7,7,7,7,7,7], capacity = 8
 * Output: 49
 *
 * Constraints:
 * 1 <= n <= 1000
 * 1 <= plants[i] <= 10^6
 * max(plants[i]) <= capacity <= 10^9
 *
 * Approach:
 * 1. Start with a full watering can.
 * 2. For each plant, check whether enough water is available.
 * 3. If not, walk back to the river and return to the plant.
 * 4. Water the plant and reduce the remaining water.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int wateringPlants(int[] plants, int capacity) {

        int steps = 0;
        int water = capacity;

        for (int i = 0; i < plants.length; i++) {

            // Refill if there is not enough water
            if (water < plants[i]) {
                steps += 2 * i + 1;
                water = capacity;
            } else {
                steps++;
            }

            // Water the current plant
            water -= plants[i];
        }

        return steps;
    }
}
