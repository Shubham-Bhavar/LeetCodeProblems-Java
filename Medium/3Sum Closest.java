/*
LeetCode 16 - 3Sum Closest

Problem:
Given an integer array nums and an integer target,
find three different elements whose sum is closest to target.

Return the sum of those three integers.

Example 1:
Input:  nums = [-1,2,1,-4], target = 1
Output: 2

Example 2:
Input:  nums = [0,0,0], target = 1
Output: 0


Approach:
1. Sort the array.
2. Fix one number using i.
3. Use two pointers:
   - left = i + 1
   - right = nums.length - 1
4. Calculate the sum.
5. If the sum is closer to target, update answer.
6. If sum < target, move left forward.
7. If sum > target, move right backward.
8. If sum == target, return immediately.

Time Complexity: O(n^2)
Space Complexity: O(1) extra space
*/

import java.util.*;

class Solution {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length - 2; i++)
        {
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(sum - target) <
                   Math.abs(closest - target))
                {
                    closest = sum;
                }

                if(sum < target)
                {
                    left++;
                }
                else if(sum > target)
                {
                    right--;
                }
                else
                {
                    return sum;
                }
            }
        }

        return closest;
    }
}
