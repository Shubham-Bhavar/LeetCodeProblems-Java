/*
Problem: Shuffle the Array

Description:
Given an array nums of the form:
[x1,x2,...,xn,y1,y2,...,yn]

Return the array in the form:
[x1,y1,x2,y2,...,xn,yn]

Approach:
- Create a new result array.
- Traverse the first half of the array.
- Alternately place xi and yi into the result array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] result = new int[2 * n];
        int index = 0;

        for (int i = 0; i < n; i++) {

            // Add xi
            result[index++] = nums[i];

            // Add yi
            result[index++] = nums[i + n];
        }

        return result;
    }
}
