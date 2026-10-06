/*
 * LeetCode 77: Combinations
 *
 * Problem:
 * Given two integers n and k, return all possible combinations
 * of k numbers chosen from the range [1, n].
 *
 * The order does not matter.
 * For example, [1,2] and [2,1] are the same combination.
 *
 * Example 1:
 * Input:  n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 *
 * Example 2:
 * Input:  n = 1, k = 1
 * Output: [[1]]
 *
 * Approach:
 * 1. Use DFS + Backtracking.
 * 2. Start choosing numbers from 1.
 * 3. Add a number to the current combination.
 * 4. Recursively choose the next numbers.
 * 5. When k numbers are selected, add the combination to result.
 * 6. Remove the last number and try another choice.
 *
 * Time Complexity: O(C(n,k) * k)
 * Space Complexity: O(k) excluding the output.
 */

import java.util.*;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, n, k, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Combination is complete
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible number
        for (int i = start; i <= n; i++) {

            current.add(i);

            backtrack(i + 1, n, k, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}
