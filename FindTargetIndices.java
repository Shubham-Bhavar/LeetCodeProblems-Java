/*
Question:
Given an array nums and a target,
return indices where target appears AFTER sorting nums.

Return indices in increasing order.
*/

import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums); // sort array

        List<Integer> result = new ArrayList<>();

        // find indices where nums[i] == target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }
}
