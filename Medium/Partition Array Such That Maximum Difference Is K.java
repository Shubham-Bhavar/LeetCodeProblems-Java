```java id="e3d1a7"
/*
LeetCode 2294 - Partition Array Such That Maximum Difference Is K

Problem:
Given an integer array nums and an integer k, partition all
elements into the minimum number of subsequences such that:

maximum value - minimum value <= k

Example:
Input:  nums = [3,6,1,2,5], k = 2
Output: 2

After sorting:
[1,2,3,5,6]

Groups:
[1,2,3] -> 3 - 1 = 2
[5,6]   -> 6 - 5 = 1

Answer = 2


Approach:
1. Sort the array.
2. Start a new subsequence with the smallest unused element.
3. Keep adding elements while:
       nums[i] - start <= k
4. When the difference becomes greater than k,
   start a new subsequence.
5. Continue until all elements are processed.

Why Greedy works:
After sorting, putting as many consecutive elements as possible
into the current group gives the maximum chance to minimize
the total number of groups.

Time Complexity: O(n log n)
Space Complexity: O(1) extra space
*/

import java.util.*;

class Solution {
    public int partitionArray(int[] nums, int k) {

        Arrays.sort(nums);

        int groups = 1;
        int start = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            // Current element cannot fit in this group
            if(nums[i] - start > k)
            {
                groups++;
                start = nums[i];
            }
        }

        return groups;
    }
}
```
