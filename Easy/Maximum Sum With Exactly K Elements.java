/*
 * LeetCode 2656: Maximum Sum With Exactly K Elements
 *
 * Problem:
 * Perform exactly k operations.
 * Select an element m, add m to the score, and replace
 * that element with m + 1.
 * Return the maximum possible score.
 *
 * Example 1:
 * Input:  nums = [1,2,3,4,5], k = 3
 * Output: 18
 *
 * Example 2:
 * Input:  nums = [5,5,5], k = 2
 * Output: 11
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 *
 * Approach:
 * 1. Find the maximum element.
 * 2. Add it to the score.
 * 3. Increase it by 1.
 * 4. Repeat k times.
 *
 * Time Complexity: O(n + k)
 * Space Complexity: O(1)
 */

class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int score = 0;

        for (int i = 0; i < k; i++) {
            score += max;
            max++;
        }

        return score;
    }
}
