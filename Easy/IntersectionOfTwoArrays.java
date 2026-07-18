/*
Problem:
Given two integer arrays nums1 and nums2,
return an array containing the unique elements
present in both arrays (intersection).
*/

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        // Store elements of nums1 in a HashSet
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        // Store common unique elements
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        // Convert HashSet to array
        int[] result = new int[set2.size()];
        int index = 0;

        for (int num : set2) {
            result[index++] = num;
        }

        return result;
    }
}
