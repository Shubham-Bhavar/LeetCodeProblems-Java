/**
 * Find the maximum value of k that allows the permutation
 * to be sorted using swaps where (nums[i] & nums[j]) == k.
 *
 * Approach:
 * Bitwise AND of two numbers equals k only if both numbers
 * contain every set bit present in k.
 *
 * Therefore, every element that is not already in its
 * correct position must be included in the bitwise AND
 * of the answer.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = (1 << 30) - 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                k &= nums[i];
            }
        }

        return k == (1 << 30) - 1 ? 0 : k;
    }
}
