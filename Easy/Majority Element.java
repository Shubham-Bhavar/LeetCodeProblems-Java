```java
/*
========================================================
LeetCode 169 - Majority Element
========================================================

Problem:
--------
Given an array nums, find the element that appears more
than n / 2 times.

A majority element always exists.

Example:
nums = [2,2,1,1,1,2,2]

Output:
2

========================================================
Approach: Boyer-Moore Voting Algorithm
========================================================

1. Choose the first element as candidate.
2. If current element == candidate, increase count.
3. Otherwise decrease count.
4. If count becomes 0, choose the current element
   as the new candidate.
5. Since a majority element always exists, the final
   candidate is the majority element.

Time:  O(n)
Space: O(1)
========================================================
*/

class Solution {

    public int majorityElement(int[] nums) {

        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
```
