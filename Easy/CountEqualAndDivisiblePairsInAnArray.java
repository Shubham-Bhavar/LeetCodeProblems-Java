/**
 * 🧠 Problem:
 * Count pairs (i, j) such that:
 * - nums[i] == nums[j]
 * - (i * j) % k == 0
 *
 * 📥 Input:
 * nums = [3,1,2,2,2,1,3], k = 2
 *
 * 📤 Output:
 * 4
 *
 * ⚡ Approach:
 * - Iterate over all pairs (i < j)
 * - Check:
 *      nums[i] == nums[j]
 *      (i * j) % k == 0
 *
 * ⏱ Time: O(n^2)
 * ⏱ Space: O(1)
 */

class Solution {
    public int countPairs(int[] nums, int k) {

        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
