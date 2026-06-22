/*
Question:
Given an integer array nums, find the smallest and largest
elements in the array and return their average.

The average is calculated as:
(smallest + largest) / 2.0

Example:
Input: nums = [1, 3, 5, 7]
Output: 4.0

Explanation:
Smallest = 1
Largest = 7
Average = (1 + 7) / 2.0 = 4.0
*/

class Solution {
    public double minimumAverage(int[] nums) {

        // Assume first element is both smallest and largest
        int smallest = nums[0];
        int largest = nums[0];

        // Find the smallest element
        for (int num : nums) {
            if (num < smallest) {
                smallest = num;
            }
        }

        // Find the largest element
        for (int num : nums) {
            if (num > largest) {
                largest = num;
            }
        }

        // Return the average as a double
        return (smallest + largest) / 2.0;
    }
}
