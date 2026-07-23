/*
Question:
Return true if every pair of adjacent elements in the array has different parity
(one even and one odd). Otherwise, return false.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                return false;
            }
        }
        return true;
    }
}
