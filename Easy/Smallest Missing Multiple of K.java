/*
 * LeetCode 3718: Smallest Missing Multiple of K
 *
 * Question:
 * Find the smallest positive multiple of k missing from nums.
 *
 * Approach:
 * 1. Store all array elements in a HashSet.
 * 2. Check k, 2k, 3k, and so on.
 * 3. Return the first multiple not found in the set.
 *
 * Time Complexity: O(n + m), where m is the number of multiples checked.
 * Space Complexity: O(n)
 */

import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        int x = k;
        while (set.contains(x))
            x += k;

        return x;
    }
}
