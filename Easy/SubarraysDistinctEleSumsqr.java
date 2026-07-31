/*
Question (Short):
For all subarrays of nums, find number of distinct elements.
Return sum of squares of these counts.
*/

import java.util.*;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int result = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < n; j++) {
                set.add(nums.get(j));      // add element
                int distinct = set.size(); // distinct count
                result += distinct * distinct; // add square
            }
        }

        return result;
    }
}
