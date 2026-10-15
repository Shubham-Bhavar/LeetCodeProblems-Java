/*
LeetCode 60: Permutation Sequence
Difficulty: Medium
Topics: Math, Recursion, Combinatorics

Problem:
Given n and k, return the kth permutation sequence of numbers
from 1 to n in lexicographical order.

Approach:
1. Calculate factorial values from 0! to n!.
2. Store numbers from 1 to n in a list.
3. Convert k to zero-based indexing by subtracting 1.
4. Use factorial blocks to select each digit.
5. Remove each selected digit and build the result.

Time Complexity: O(n^2)
Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];

        // Calculate factorials and store numbers
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            numbers.add(i);
        }

        // Convert k to zero-based indexing
        k--;

        StringBuilder result = new StringBuilder();

        // Find each digit using factorial blocks
        for (int i = n; i >= 1; i--) {
            int index = k / factorial[i - 1];

            result.append(numbers.get(index));
            numbers.remove(index);

            k %= factorial[i - 1];
        }

        return result.toString();
    }
}
