/*
LeetCode 128 - Longest Consecutive Sequence

Problem:
Given an unsorted array of integers nums, return the length
of the longest consecutive elements sequence.

The algorithm must run in O(n) time.

Example 1:
Input:  [100,4,200,1,3,2]
Output: 4

Explanation:
Longest sequence = [1,2,3,4]

Example 2:
Input:  [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input:  [1,0,1,2]
Output: 3


Approach:
1. Store all numbers in a HashSet.
2. For every number, check if it is the START of a sequence.
   A number is a start if (num - 1) is not present.
3. If it is a start, keep checking:
       num + 1
       num + 2
       num + 3 ...
4. Keep track of the maximum length.

Why HashSet?
- Searching in a HashSet takes O(1) average time.
- Duplicates are automatically ignored.

Time Complexity: O(n) average
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        // Store all numbers
        for(int num : nums)
        {
            set.add(num);
        }

        int longest = 0;

        // Find the start of every sequence
        for(int num : set)
        {
            if(!set.contains(num - 1))
            {
                int current = num;
                int length = 1;

                // Count consecutive numbers
                while(set.contains(current + 1))
                {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
