/*
 * LeetCode: 167. Two Sum II - Input Array Is Sorted
 *
 * Problem:
 * Given a 1-indexed array of integers numbers that is sorted in
 * non-decreasing order, find two numbers that add up to target.
 *
 * Return their 1-based indices [index1, index2].
 *
 * Conditions:
 *   1 <= index1 < index2 <= numbers.length
 *
 * The array contains exactly one solution.
 *
 * Example 1:
 * Input:
 * numbers = [2,7,11,15], target = 9
 *
 * Output:
 * [1,2]
 *
 * Explanation:
 * 2 + 7 = 9
 *
 * Example 2:
 * Input:
 * numbers = [2,3,4], target = 6
 *
 * Output:
 * [1,3]
 *
 * Explanation:
 * 2 + 4 = 6
 *
 * Example 3:
 * Input:
 * numbers = [-1,0], target = -1
 *
 * Output:
 * [1,2]
 *
 * Explanation:
 * -1 + 0 = -1
 *
 * ---------------------------------------------------------
 * Approach: Two Pointers
 * ---------------------------------------------------------
 *
 * Since the array is already sorted:
 *
 * left  -> starts from the beginning
 * right -> starts from the end
 *
 * Calculate:
 * numbers[left] + numbers[right]
 *
 * If sum == target:
 *     Return the indices.
 *
 * If sum < target:
 *     Move left forward to increase the sum.
 *
 * If sum > target:
 *     Move right backward to decrease the sum.
 *
 * ---------------------------------------------------------
 * Complexity:
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            // Found the required pair
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }

            // Need a larger sum
            if (sum < target) {
                left++;
            }

            // Need a smaller sum
            else {
                right--;
            }
        }

        // Exactly one solution is guaranteed
        return new int[] {};
    }
}
