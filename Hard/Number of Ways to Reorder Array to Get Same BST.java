/*
LeetCode 1569: Number of Ways to Reorder Array to Get Same BST
Difficulty: Hard
Topics: Dynamic Programming, Tree, Combinatorics

Approach:
1. Use the first element as the root and divide remaining numbers into left and right subtrees.
2. Recursively count valid reorderings for both subtrees.
3. Multiply both counts by the ways to interleave left and right elements,
   then subtract 1 to exclude the original ordering.

Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007;
    private long[][] combinations;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Precompute combinations C(n, r)
        combinations = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            combinations[i][0] = 1;
            combinations[i][i] = 1;

            for (int j = 1; j < i; j++) {
                combinations[i][j] =
                    (combinations[i - 1][j - 1]
                    + combinations[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) ((countWays(list) - 1 + MOD) % MOD);
    }

    private long countWays(List<Integer> nums) {
        int size = nums.size();

        if (size <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < size; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = countWays(left);
        long rightWays = countWays(right);

        long waysToInterleave =
            combinations[size - 1][left.size()];

        return (((waysToInterleave * leftWays) % MOD)
                * rightWays) % MOD;
    }
}
