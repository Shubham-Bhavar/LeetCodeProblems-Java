/*
Question: Ant on the Boundary

The ant starts at position 0 (boundary).

For each value:
- Positive number -> move right.
- Negative number -> move left.

Return how many times the ant returns to position 0.
*/

class Solution {

    public int returnToBoundaryCount(int[] nums) {
        int position = 0;
        int count = 0;

        for (int num : nums) {
            position += num;

            if (position == 0) {
                count++;
            }
        }

        return count;
    }
}
