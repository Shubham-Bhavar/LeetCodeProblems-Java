/**
 * LeetCode 3633: Earliest Finish Time for Land and Water Rides I
 *
 * Approach:
 * 1. Try every possible pair of land and water rides.
 * 2. Calculate the finish time when taking the land ride first.
 * 3. Calculate the finish time when taking the water ride first.
 * 4. Return the minimum finish time among all possible combinations.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */

class Solution {
    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minFinishTime = Integer.MAX_VALUE;

        // Try every combination of land and water rides
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Land ride first, then water ride
                int landFinish = landStartTime[i] + landDuration[i];

                int waterFinish = Math.max(
                        landFinish, waterStartTime[j]
                ) + waterDuration[j];

                minFinishTime = Math.min(
                        minFinishTime, waterFinish
                );

                // Water ride first, then land ride
                int waterFirstFinish =
                        waterStartTime[j] + waterDuration[j];

                int landFinishAfterWater = Math.max(
                        waterFirstFinish, landStartTime[i]
                ) + landDuration[i];

                minFinishTime = Math.min(
                        minFinishTime, landFinishAfterWater
                );
            }
        }

        return minFinishTime;
    }
}
