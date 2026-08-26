/*
Question:
Apply operations sequentially on adjacent elements.

Rules:
1. If nums[i] == nums[i + 1]:
   - nums[i] = nums[i] * 2
   - nums[i + 1] = 0
2. Otherwise, do nothing.
3. After all operations, shift all zeros to the end.

Approach:
1. Process adjacent elements from left to right.
2. Move all non-zero elements to the front.
*/

class Solution {
    public int[] applyOperations(int[] nums) {

        // Apply operations sequentially
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Move non-zero elements to the front
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        // Fill remaining positions with 0
        while (index < nums.length) {
            nums[index++] = 0;
        }

        return nums;
    }
}
