/*
========================================================
LeetCode 11 - Container With Most Water
========================================================

Problem:
--------
Given an integer array height, find two vertical lines
that together with the x-axis form a container.

Return the maximum amount of water the container can
store.

The container cannot be slanted.

Example 1:
----------
Input:
height = [1,8,6,2,5,4,8,3,7]

Output:
49

Example 2:
----------
Input:
height = [1,1]

Output:
1

--------------------------------------------------------
Approach: Two Pointers
--------------------------------------------------------

1. Start with two pointers:
       left  = 0
       right = n - 1

2. Calculate the area:

       width = right - left

       height = minimum of
                height[left] and height[right]

       area = width * height

3. Update the maximum area.

4. Move the pointer having the smaller height.

   Why?
   The water level is limited by the smaller line.
   Moving the taller line cannot increase the height,
   while the width becomes smaller.

5. Continue until left and right meet.

--------------------------------------------------------
Complexity:
--------------------------------------------------------

Time Complexity  : O(n)
Space Complexity : O(1)

========================================================
*/

class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxWater = 0;

        while (left < right) {

            // Width between the two lines
            int width = right - left;

            // Water height is limited by smaller line
            int minHeight = Math.min(height[left], height[right]);

            // Calculate current area
            int area = width * minHeight;

            // Update maximum area
            maxWater = Math.max(maxWater, area);

            // Move the smaller height pointer
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
