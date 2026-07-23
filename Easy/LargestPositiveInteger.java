/*
Question:
Given an integer array nums (without zeros), return the largest positive integer k
such that both k and -k exist in the array. If no such integer exists, return -1.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int ans = -1;

        for (int num : nums) {
            if (set.contains(-num)) {
                ans = Math.max(ans, Math.abs(num));
            }
        }

        return ans;
    }
}
