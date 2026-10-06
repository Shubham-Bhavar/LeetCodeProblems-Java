/*
 * LeetCode 42: Trapping Rain Water
 *
 * Problem:
 * Given an array height where each value represents the height
 * of a vertical bar, calculate how much rain water can be trapped.
 *
 * Example 1:
 * Input:  height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Example 2:
 * Input:  height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Approach:
 * Use two pointers: left and right.
 *
 * Keep track of:
 * - leftMax  = maximum height from the left
 * - rightMax = maximum height from the right
 *
 * If height[left] <= height[right]:
 *   Water at left depends on leftMax.
 * Otherwise:
 *   Water at right depends on rightMax.
 *
 * Formula:
 * Water = maxHeight - currentHeight
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }
}
