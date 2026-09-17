/*
LeetCode 46. Permutations

Difficulty: Medium

Problem Statement:
Given an array nums of distinct integers, return all the possible
permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]

Output:
[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]

Output:
[[0,1],[1,0]]

Example 3:
Input: nums = [1]

Output:
[[1]]

Approach:
Use Backtracking.

1. Create an empty list for the current permutation.
2. Try every number in the array.
3. Skip the number if it is already used.
4. Add the number to the current permutation.
5. Recursively generate the remaining elements.
6. Remove the last element to backtrack.
7. When the permutation contains all elements, add it to the result.

Key Idea:
Choose -> Explore -> Undo

Time Complexity: O(n * n!)
Space Complexity: O(n) auxiliary space
*/

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {

            if (current.contains(num)) {
                continue;
            }

            current.add(num);

            backtrack(nums, current, result);

            current.remove(current.size() - 1);
        }
    }
}