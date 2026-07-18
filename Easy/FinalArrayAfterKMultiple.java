/*
Problem: Final Array State After K Multiplication Operations

Description:
Perform k operations on the array.
In each operation:
1. Find the minimum element.
2. If multiple minimum elements exist, choose the first one.
3. Replace it with element * multiplier.

Return the final array.

Approach:
- Repeat k times.
- Find the index of the minimum element.
- Multiply it by multiplier.

Time Complexity: O(k * n)
Space Complexity: O(1)
*/

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        // Perform k operations
        while (k-- > 0) {

            int minIndex = 0;

            // Find index of minimum element
            for (int i = 1; i < nums.length; i++) {

                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            // Multiply the minimum element
            nums[minIndex] *= multiplier;
        }

        return nums;
    }
}
