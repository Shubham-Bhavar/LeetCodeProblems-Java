
/*
 * LeetCode 15: 3Sum
 *
 * Problem:
 * Given an integer array nums, find all unique triplets
 * whose sum is equal to zero.
 *
 * Approach:
 * Sorting + Two Pointers.
 *
 * Step-by-Step Explanation:
 * 1. Sort the array.
 * 2. Fix one element using the index i.
 * 3. Use two pointers:
 *      left = i + 1
 *      right = nums.length - 1
 * 4. Calculate the sum of the three elements.
 * 5. If sum == 0:
 *      Add the triplet to the result.
 *      Move both pointers.
 *      Skip duplicate values.
 * 6. If sum < 0, move left forward.
 * 7. If sum > 0, move right backward.
 * 8. Skip duplicate fixed elements to avoid duplicate triplets.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) auxiliary space, excluding sorting
 * and the output list.
 */

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix the first element
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Find the remaining two elements
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    // Store the valid triplet
                    result.add(Arrays.asList(
                        nums[i], nums[left], nums[right]
                    ));

                    left++;
                    right--;

                    // Skip duplicate left values
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    // Increase the sum
                    left++;

                } else {

                    // Decrease the sum
                    right--;
                }
            }
        }

        return result;
    }
}
