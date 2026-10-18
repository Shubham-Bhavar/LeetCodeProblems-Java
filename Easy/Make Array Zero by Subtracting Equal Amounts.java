/*
LeetCode 2357: Make Array Zero by Subtracting Equal Amounts
Difficulty: Easy
Topics: Array, Hash Set, Greedy

Approach:
1. Store all non-zero values in a HashSet.
2. Count the distinct non-zero values.
3. Return the count because each operation can remove one distinct value level.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }

        return set.size();
    }
}
