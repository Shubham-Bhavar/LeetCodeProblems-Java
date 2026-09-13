```java
/*
========================================================
LeetCode 45 - Jump Game II
========================================================

Problem:
--------
Given an array nums, each nums[i] tells us the maximum
number of steps we can jump forward from index i.

Return the minimum number of jumps needed to reach
the last index.

Example:
nums = [2,3,1,1,4]

Output:
2

Path:
0 -> 1 -> 4

========================================================
Approach: Greedy
========================================================

1. Keep track of the farthest index we can reach.
2. Keep track of the end of the current jump range.
3. When we reach the end of the current range,
   we must make another jump.
4. Update the range using the farthest position.

========================================================
*/

class Solution {

    public int jump(int[] nums) {

        int jumps = 0;
        int end = 0;
        int far = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // Find the farthest position
            far = Math.max(far, i + nums[i]);

            // Current jump range is finished
            if (i == end) {
                jumps++;
                end = far;
            }
        }

        return jumps;
    }
}
```
