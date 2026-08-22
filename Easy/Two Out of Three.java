/*
 * Question: Two Out of Three
 *
 * Given three integer arrays, return all distinct values
 * that are present in at least two out of the three arrays.
 *
 * Example:
 * nums1 = [1,1,3,2]
 * nums2 = [2,3]
 * nums3 = [3]
 *
 * Result = [2,3]
 *
 * Approach:
 * 1. Convert each array into a HashSet.
 *    HashSet automatically removes duplicates.
 *
 * 2. Check every value in set1.
 *    If it exists in set2 or set3, add it to result.
 *
 * 3. Check every value in set2.
 *    If it exists in set1 or set3, add it to result.
 *
 * 4. Convert the result HashSet into an ArrayList.
 *
 * Time Complexity: O(n1 + n2 + n3)
 * Space Complexity: O(n1 + n2 + n3)
 */

import java.util.*;

class Solution {

    public List<Integer> twoOutOfThree(
            int[] nums1, int[] nums2, int[] nums3) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        // Add nums1 elements
        for (int num : nums1) {
            set1.add(num);
        }

        // Add nums2 elements
        for (int num : nums2) {
            set2.add(num);
        }

        // Add nums3 elements
        for (int num : nums3) {
            set3.add(num);
        }

        // Check values from the first array
        for (int num : set1) {
            if (set2.contains(num) || set3.contains(num)) {
                result.add(num);
            }
        }

        // Check values from the second array
        for (int num : set2) {
            if (set1.contains(num) || set3.contains(num)) {
                result.add(num);
            }
        }

        // Convert Set to List
        return new ArrayList<>(result);
    }
}
