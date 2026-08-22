/*
 * Question: Count Pairs That Form a Complete Day
 *
 * Given an integer array hours, count the number of pairs
 * (i, j) where i < j and:
 *
 * (hours[i] + hours[j]) is a multiple of 24.
 *
 * A complete day can be:
 * 24 hours, 48 hours, 72 hours, etc.
 *
 * Example:
 * Input:  hours = [12, 12, 30, 24, 24]
 * Output: 2
 *
 * Valid pairs:
 * 12 + 12 = 24
 * 24 + 24 = 48
 *
 * Approach:
 * Use nested loops to check every possible pair.
 * If the sum is divisible by 24, increment the count.
 *
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 */

class Solution {

    public int countCompleteDayPairs(int[] hours) {
        int count = 0;

        // Check every pair
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {

                int sum = hours[i] + hours[j];

                // Check if sum forms a complete day
                if (sum % 24 == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
