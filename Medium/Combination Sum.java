/*
LeetCode 39. Combination Sum

Difficulty: Medium

Problem Statement:
Given an array of distinct integers candidates and a target integer target,
return all unique combinations of candidates where the chosen numbers
sum to target.

The same number can be chosen unlimited times.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []

Approach:
Use Backtracking.

1. Start from index 0.
2. Choose a candidate and subtract it from target.
3. The same candidate can be chosen again, so use the same index.
4. If target becomes 0, a valid combination is found.
5. If target becomes negative, stop that path.
6. Backtrack by removing the last chosen number.
7. Start the next recursive call from the current index to avoid duplicates.

Key Idea:
Choose -> Explore -> Backtrack

Time Complexity:
O(N^(T/M)) approximately, where:
N = number of candidates
T = target
M = smallest candidate

Space Complexity:
O(T/M) for the recursion/combination path
*/

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            current.add(candidates[i]);

            // Same number can be used multiple times
            backtrack(
                candidates,
                target - candidates[i],
                i,
                current,
                result
            );

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}
