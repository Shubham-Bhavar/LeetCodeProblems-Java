/**
 * 🧠 Problem:
 * Count triplets (i, j, k) such that:
 * i < j < k
 * nums[j] - nums[i] == diff
 * nums[k] - nums[j] == diff
 *
 * 📥 Input:
 * nums = [0,1,4,6,7,10], diff = 3
 *
 * 📤 Output:
 * 2
 *
 * ⚡ Approach (Best):
 * - Use HashSet for quick lookup
 * - For each num:
 *     check if (num + diff) and (num + 2*diff) exist
 *
 * ⏱ Time: O(n)
 * ⏱ Space: O(n)
 */

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {

        java.util.Set<Integer> set = new java.util.HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int count = 0;

        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + 2 * diff)) {
                count++;
            }
        }

        return count;
    }
}
