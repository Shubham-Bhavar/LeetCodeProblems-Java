/*
LeetCode 80 - Remove Duplicates from Sorted Array II

Problem:
Given a sorted array nums, remove duplicates in-place such that
each unique element appears at most twice.

Return k, where the first k elements of nums contain the result.

Example 1:
Input:  [1,1,1,2,2,3]
Output: 5
nums = [1,1,2,2,3,_]

Example 2:
Input:  [0,0,1,1,1,1,2,3,3]
Output: 7
nums = [0,0,1,1,2,3,3,_,_]


Approach:
- Use a write pointer k.
- The first two elements are always allowed.
- From the 3rd element onward:
    If nums[i] != nums[k - 2],
    then we can keep nums[i].
- Why k - 2?
    If nums[i] == nums[k - 2], keeping it would make
    the same number appear more than twice.

Example:
[1,1,1,2,2,3]

Keep 1 -> [1]
Keep 1 -> [1,1]
Third 1:
    nums[i] == nums[k-2]
    so skip it.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {

        // If array has 2 or fewer elements
        if(nums.length <= 2)
            return nums.length;

        // First two elements are always allowed
        int k = 2;

        // Start checking from the 3rd element
        for(int i = 2; i < nums.length; i++)
        {
            // Allow nums[i] only if it won't create 3 duplicates
            if(nums[i] != nums[k - 2])
            {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
