/*
LeetCode 3551: Minimum Swaps to Sort by Digit Sum
Difficulty: Medium
Topics: Sorting, Greedy, Array

Approach:
1. Sort the numbers by digit sum; if sums are equal, sort by value.
2. Track each number's original index.
3. Count the minimum swaps using cycle detection.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        // Store number and its original index
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by digit sum, then by number
        Arrays.sort(arr, (a, b) -> {
            int sumA = digitSum(a[0]);
            int sumB = digitSum(b[0]);

            if (sumA != sumB) {
                return sumA - sumB;
            }

            return a[0] - b[0];
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Count swaps using cycles
        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][1] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][1];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
