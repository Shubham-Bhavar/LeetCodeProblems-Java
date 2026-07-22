// Problem: Find common elements count between two arrays
// Approach: Use HashSet for fast lookup

import java.util.*;

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // store elements
        for (int x : nums1) set1.add(x);
        for (int x : nums2) set2.add(x);

        int count1 = 0, count2 = 0;

        // check nums1 in nums2
        for (int x : nums1) {
            if (set2.contains(x)) count1++;
        }

        // check nums2 in nums1
        for (int x : nums2) {
            if (set1.contains(x)) count2++;
        }

        return new int[]{count1, count2};
    }
}
