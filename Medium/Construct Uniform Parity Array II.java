/**
 * LeetCode 3876: Construct Uniform Parity Array II
 *
 * Approach:
 * If the minimum element is even, every element must be even.
 * If the minimum element is odd, every element can be made odd
 * by subtracting the minimum from larger elements.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];

        for (int num : nums1) {
            min = Math.min(min, num);
        }

        if (min % 2 == 0) {
            for (int num : nums1) {
                if (num % 2 != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
