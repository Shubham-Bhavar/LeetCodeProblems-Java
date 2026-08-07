/*
Q) Count how many devices can be tested.

Rule:
- If battery[i] > 0 → test it
- After testing → all next elements reduce by 1
- Battery never goes below 0

-----------------------------------------------------

Optimized Idea:
Instead of actually decreasing all elements,
we keep track of how many times reduction happened.

effective value = battery[i] - count

If effective value > 0 → we can test it

-----------------------------------------------------

Time: O(n)
Space: O(1)
*/

class Solution {

    public int countTestedDevices(int[] battery) {

        int count = 0; // number of tested devices

        for (int i = 0; i < battery.length; i++) {

            // effective battery after reductions
            if (battery[i] - count > 0) {
                count++;
            }
        }

        return count;
    }
}
