/*
 * LeetCode 152: Maximum Product Subarray
 *
 * Problem:
 * Given an integer array nums, find a contiguous subarray
 * that has the largest product and return that product.
 *
 * Example 1:
 * Input:  nums = [2,3,-2,4]
 * Output: 6
 *
 * Explanation:
 * [2,3] has the largest product:
 * 2 * 3 = 6
 *
 * Example 2:
 * Input:  nums = [-2,0,-1]
 * Output: 0
 *
 * Explanation:
 * [-2,-1] is not a contiguous subarray.
 *
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 *
 * The product of any subarray fits in a 32-bit integer.
 */

class Solution {

    public int maxProduct(int[] nums) {

        // Maximum product ending at the current position
        int maxProduct = nums[0];

        // Minimum product ending at the current position
        int minProduct = nums[0];

        // Overall maximum product found so far
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int current = nums[i];

            /*
             * A negative number can swap the roles of maximum
             * and minimum products.
             */
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Either start a new subarray or extend the previous one.
            maxProduct = Math.max(current, maxProduct * current);

            // Track the minimum because it may become maximum
            // after multiplication by a negative number.
            minProduct = Math.min(current, minProduct * current);

            // Update global answer.
            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}
