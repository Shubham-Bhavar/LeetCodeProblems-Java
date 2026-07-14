/*
Question:
Given an array nums with unique integers,
find all missing numbers between min(nums) and max(nums).

Return sorted list of missing numbers.
*/

import java.util.*;

class Solution {
    public List<Integer> findMissingNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // put all numbers in a set for fast lookup
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // check for missing numbers in range
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
