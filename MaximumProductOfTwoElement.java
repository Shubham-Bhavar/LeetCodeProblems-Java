/**
 * 🧠 Problem:
 * Choose two different indices i and j such that:
 * maximize (nums[i] - 1) * (nums[j] - 1)
 *
 * 📥 Input:
 * nums = [3,4,5,2]
 *
 * 📤 Output:
 * 12
 *
 * ⚡ Approach:
 * - To maximize product, pick two largest numbers
 * - Let max1 = largest, max2 = second largest
 * - Answer = (max1 - 1) * (max2 - 1)
 *
 * ⏱ Time: O(n)
 * ⏱ Space: O(1)
 */

class Solution {
    public int maxProduct(int[] nums) {

        int max1 = 0, max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
