/*
 * LeetCode 3727: Maximum Alternating Sum of Squares
 *
 * Problem:
 * Rearrange nums to maximize:
 * arr[0]^2 - arr[1]^2 + arr[2]^2 - ...
 *
 * Approach:
 * 1. Square every element.
 * 2. Sort the squared values in ascending order.
 * 3. Subtract the smaller half from the answer.
 * 4. Add the larger half to the answer.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];

        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long answer = 0;
        int mid = n / 2;

        for (int i = 0; i < mid; i++) {
            answer -= squares[i];
        }

        for (int i = mid; i < n; i++) {
            answer += squares[i];
        }

        return answer;
    }
}