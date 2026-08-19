/*
LeetCode: Minimum Operations to Make Binary Array Elements Equal to One

Problem:
You are given a binary array nums.

In one operation:
- Choose any 3 consecutive elements.
- Flip all 3 elements.
- 0 becomes 1 and 1 becomes 0.

Return the minimum number of operations required to make all
elements equal to 1. If impossible, return -1.

Example:
Input: nums = [0,1,1,1,0,0]
Output: 3

Explanation:
1. Flip indices 0,1,2 → [1,0,0,1,0,0]
2. Flip indices 1,2,3 → [1,1,1,0,0,0]
3. Flip indices 3,4,5 → [1,1,1,1,1,1]
*/

class Solution {
    public int minOperations(int[] nums) {
        int count = 0;

        // Check every possible group of 3 consecutive elements
        for (int i = 0; i <= nums.length - 3; i++) {

            // If current element is 0, flip it with the next 2 elements
            if (nums[i] == 0) {

                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;

                count++;
            }
        }

        // Check if all elements are 1
        for (int num : nums) {
            if (num == 0) {
                return -1;
            }
        }

        return count;
    }
}
