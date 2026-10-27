/*
 * LeetCode 1980: Find Unique Binary String
 *
 * Question:
 * Find a binary string of length n that is not present in nums.
 *
 * Approach:
 * 1. Use the diagonalization technique.
 * 2. Flip the i-th character of nums[i].
 * 3. The resulting string differs from every nums[i]
 *    at least at position i, so it is guaranteed to be unique.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < nums.length; i++)
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');

        return ans.toString();
    }
}
