// Question:
// Create target array by inserting nums[i] at index[i]

import java.util.*;

class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> list = new ArrayList<>();

        // insert elements one by one
        for (int i = 0; i < nums.length; i++) {

            list.add(index[i], nums[i]); // insert at given position
        }

        // convert list to array
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
