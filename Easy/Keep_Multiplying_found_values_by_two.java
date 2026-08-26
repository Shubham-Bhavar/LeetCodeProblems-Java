/*
Question:
Given an array nums and an integer original,
keep multiplying original by 2 while it exists in nums.
Return the final value of original.

Approach:
1. Store all array elements in a HashSet.
2. Check whether original exists in the HashSet.
3. If it exists, multiply original by 2.
4. Repeat until original is not found.
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findFinalValue(int[] nums, int original) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
