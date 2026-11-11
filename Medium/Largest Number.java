
/*
 * LeetCode 179. Largest Number
 *
 * Description:
 * Arrange the given non-negative integers to form the
 * largest possible number and return it as a string.
 *
 * Approach: Greedy + Custom Sorting
 * Time Complexity: O(n log n * k)
 * Space Complexity: O(n * k)
 * k = maximum number of digits in an integer
 */

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {

        // Convert integers into strings
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort based on which concatenation gives a larger number
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Handle the case where all numbers are zero
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the largest possible number
        StringBuilder result = new StringBuilder();

        for (String num : arr) {
            result.append(num);
        }

        return result.toString();
    }
}
