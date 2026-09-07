/*
LeetCode 442 - Find All Duplicates in an Array

Problem:
Given an array nums of length n where:
- 1 <= nums[i] <= n
- Each number appears once or twice

Return all numbers that appear twice.

Example:
Input:  [4,3,2,7,8,2,3,1]
Output: [2,3]

Approach:
- For every number x, use index x - 1.
- If nums[x - 1] is positive, make it negative.
- If nums[x - 1] is already negative, x is a duplicate.

Why?
The first occurrence marks its corresponding index as negative.
The second occurrence finds that index already negative.

Time Complexity: O(n)
Space Complexity: O(1) excluding output
*/

import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) 
    {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]) - 1;

            if(nums[index] < 0)
            {
                ans.add(Math.abs(nums[i]));
            }
            else
            {
                nums[index] = -nums[index];
            }
        }

        return ans;
    }
}
