
/*
 * LeetCode 1295. Find Numbers with Even Number of Digits
 *
 * Problem:
 * Count how many numbers contain an even number of digits.
 *
 * Approach:
 * 1. Iterate through each number.
 * 2. Count digits by repeatedly dividing by 10.
 * 3. Check whether the digit count is even.
 * 4. Return the total count.
 *
 * Time Complexity: O(n * d)
 * Space Complexity: O(1)
 */

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            int digits = 0;

            while (num > 0) {
                digits++;
                num /= 10;
            }

            if (digits % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
