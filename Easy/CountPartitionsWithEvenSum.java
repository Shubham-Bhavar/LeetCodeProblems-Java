/**
 * 🧠 Problem:
 * Count partitions where (leftSum - rightSum) is even.
 *
 * 📥 Input:
 * nums = [10,10,3,7,6]
 *
 * 📤 Output:
 * 4
 *
 * ⚡ Approach:
 * - Let totalSum = sum of array
 * - At index i:
 *      leftSum = prefix sum
 *      rightSum = totalSum - leftSum
 *
 * - Condition:
 *      (leftSum - rightSum) % 2 == 0
 *
 * - Simplify:
 *      leftSum - (totalSum - leftSum)
 *      = 2 * leftSum - totalSum
 *
 * - So condition becomes:
 *      (2 * leftSum - totalSum) % 2 == 0
 *
 * - Since 2 * leftSum is always even:
 *      Answer depends on totalSum
 *
 * 👉 FINAL INSIGHT:
 * If totalSum is EVEN → ALL partitions valid
 * If totalSum is ODD → NO partition valid
 *
 * ⏱ Time: O(n)
 * ⏱ Space: O(1)
 */

class Solution {
    public int countPartitions(int[] nums) {

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        // if total sum is odd → no valid partitions
        if (totalSum % 2 != 0) {
            return 0;
        }

        // if total sum is even → all (n-1) partitions valid
        return nums.length - 1;
    }
}
