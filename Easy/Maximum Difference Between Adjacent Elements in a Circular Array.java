
/*
 * Problem: 3423. Maximum Difference Between Adjacent Elements in a Circular Array
 * Difficulty: Easy
 * Approach: Single Pass
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxAdjacentDistance(int[] nums) {

        int maxDiff = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int next = (i + 1) % n;

            int diff = Math.abs(nums[i] - nums[next]);

            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}
