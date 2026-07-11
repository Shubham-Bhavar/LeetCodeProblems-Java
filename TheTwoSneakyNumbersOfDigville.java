/*
Question:
Given an array nums containing numbers from 0 to n-1,
two numbers appear twice. Find those two duplicates.

Approach:
Use HashSet to track seen elements.
*/

import java.util.*;

class Solution {
    public int[] findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>(); // store seen elements
        int[] res = new int[2];
        int idx = 0;

        for (int num : nums) {
            if (set.contains(num)) { // already seen → duplicate
                res[idx++] = num;
            } else {
                set.add(num); // add new element
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums = {0,1,1,0};
        System.out.println(Arrays.toString(obj.findDuplicates(nums))); // [1,0]
    }
}
