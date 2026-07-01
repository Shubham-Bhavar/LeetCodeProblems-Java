// Question:
// A mountain is stable if previous mountain's height > threshold.
// Return indices of all stable mountains.

import java.util.ArrayList;

class Solution {
    public int[] stableMountains(int[] height, int threshold) {

        ArrayList<Integer> result = new ArrayList<>();

        // start from index 1 because index 0 has no previous mountain
        for (int i = 1; i < height.length; i++) {

            // check previous mountain condition
            if (height[i - 1] > threshold) {
                result.add(i);
            }
        }

        // convert ArrayList to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
