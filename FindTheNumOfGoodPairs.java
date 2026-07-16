/**
 * 🧠 Problem:
 * Count pairs (i, j) such that:
 * nums1[i] % (nums2[j] * k) == 0
 *
 * 📥 Input:
 * nums1 = [1,3,4], nums2 = [1,3,4], k = 1
 *
 * 📤 Output:
 * 5
 *
 * ⚡ Approach:
 * - Iterate all pairs (i, j)
 * - Check divisibility condition
 *
 * ⏱ Time: O(n * m)
 * ⏱ Space: O(1)
 */

class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {

        int count = 0;

        for (int a : nums1) {
            for (int b : nums2) {

                if (a % (b * k) == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
