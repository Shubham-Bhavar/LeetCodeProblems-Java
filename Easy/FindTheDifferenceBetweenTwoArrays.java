/*
Question:
Return a list where:
1. First list contains distinct elements present in nums1 but not in nums2.
2. Second list contains distinct elements present in nums2 but not in nums1.

Time Complexity: O(n + m)
Space Complexity: O(n + m)
*/

import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }

        for (int num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(list1);
        ans.add(list2);

        return ans;
    }
}
