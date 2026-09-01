/*
LeetCode - Count Subarrays Where Target Is Majority

Approach:
For every starting index, extend the subarray.
Keep count of how many times target appears.

For a subarray of length len:
target is majority if

targetCount * 2 > len

Example:
nums = [1,2,2,3], target = 2

[2,2] -> targetCount = 2, len = 2
2 * 2 > 2 -> true

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) 
    {
        long ans = 0;

        for(int i = 0; i < nums.length; i++)
        {
            int count = 0;

            for(int j = i; j < nums.length; j++)
            {
                if(nums[j] == target)
                {
                    count++;
                }

                int len = j - i + 1;

                if(count * 2 > len)
                {
                    ans++;
                }
            }
        }

        return ans;
    }
}
