/*
 * LeetCode 495: Teemo Attacking
 *
 * Problem:
 * Teemo attacks Ashe at different times.
 * Each attack poisons Ashe for `duration` seconds.
 *
 * If another attack happens before the current poison ends,
 * the poison timer is reset.
 *
 * Return the total number of seconds Ashe is poisoned.
 *
 * Example 1:
 * Input:  timeSeries = [1,4], duration = 2
 * Output: 4
 *
 * Explanation:
 * Attack at 1 -> poisoned for [1,2]
 * Attack at 4 -> poisoned for [4,5]
 *
 * Total = 4 seconds.
 *
 * Example 2:
 * Input:  timeSeries = [1,2], duration = 2
 * Output: 3
 *
 * Explanation:
 * Attack at 1 -> [1,2]
 * Attack at 2 -> [2,3]
 *
 * Seconds 1, 2, 3 are poisoned.
 *
 * Approach:
 * For every pair of consecutive attacks:
 *
 * If the time gap is smaller than duration:
 *     Only the gap contributes new poisoned seconds.
 *
 * Otherwise:
 *     The complete duration contributes.
 *
 * Formula:
 * added time = min(duration, timeSeries[i] - timeSeries[i - 1])
 *
 * Finally, add duration for the last attack.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int total = 0;

        for (int i = 1; i < timeSeries.length; i++) {

            int gap = timeSeries[i] - timeSeries[i - 1];

            total += Math.min(duration, gap);
        }

        // Last attack always contributes the full duration
        total += duration;

        return total;
    }
}
