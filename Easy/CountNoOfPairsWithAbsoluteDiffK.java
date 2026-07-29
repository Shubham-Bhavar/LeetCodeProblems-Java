/**
 * Problem: Count Number of Pairs With Absolute Difference K
 * Platform: LeetCode
 *
 * Description:
 * Given an integer array nums and an integer k,
 * return the number of pairs (i, j) such that:
 * i < j and |nums[i] - nums[j]| == k
 *
 * Approach:
 * - Use frequency array (since nums[i] <= 100)
 * - For each number, check if (num + k) exists
 *
 * Time Complexity: O(n + range)
 * Space Complexity: O(1)
 */

class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] freq = new int[101];
        int count = 0;

        for (int num : nums) {
            if (num + k <= 100) {
                count += freq[num + k];
            }
            if (num - k >= 1) {
                count += freq[num - k];
            }
            freq[num]++;
        }

        return count;
    }
}
