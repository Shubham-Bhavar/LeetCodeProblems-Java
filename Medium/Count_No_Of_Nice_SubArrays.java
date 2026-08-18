/*
Question:
Given an array nums and an integer k, count the number of
continuous subarrays containing exactly k odd numbers.

Example:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int count = 0;
        int odd = 0;

        // Frequency of each prefix odd count
        int[] freq = new int[nums.length + 1];
        freq[0] = 1;

        for (int num : nums) {

            // Count odd numbers
            if (num % 2 != 0) {
                odd++;
            }

            // Need previous prefix with odd - k
            if (odd >= k) {
                count += freq[odd - k];
            }

            freq[odd]++;
        }

        return count;
    }
}
