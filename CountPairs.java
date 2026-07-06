// Problem:
// Given a list of integers nums and an integer target,
// return the number of pairs (i, j) such that:
// 0 <= i < j < nums.size() AND nums[i] + nums[j] < target.

import java.util.*;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        
        // Step 1: Sort the list (REQUIRED for two-pointer approach)
        Collections.sort(nums);

        int left = 0;                      // Start pointer
        int right = nums.size() - 1;       // End pointer
        int count = 0;                     // Stores number of valid pairs

        // Step 2: Use two-pointer technique
        while (left < right) {
            
            // If sum is less than target
            if (nums.get(left) + nums.get(right) < target) {
                
                // All elements from left+1 to right will form valid pairs
                count += (right - left);

                // Move left pointer forward
                left++;
            } else {
                // If sum >= target, decrease right pointer
                right--;
            }
        }

        // Step 3: Return result
        return count;
    }
}
