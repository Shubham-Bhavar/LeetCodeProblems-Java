/*
    LeetCode 33 - Search in Rotated Sorted Array

    Problem:
    --------
    Given an integer array nums sorted in ascending order with
    distinct values, the array is possibly rotated at an unknown index.

    Return the index of target if it exists in nums.
    Otherwise, return -1.

    Example 1:
    Input:
    nums = [4,5,6,7,0,1,2], target = 0

    Output:
    4

    Example 2:
    Input:
    nums = [4,5,6,7,0,1,2], target = 3

    Output:
    -1

    Example 3:
    Input:
    nums = [1], target = 0

    Output:
    -1

    Approach:
    ---------
    Use Binary Search.

    In a rotated sorted array, at least one half of the array
    is always sorted.

    1. Find the middle element.
    2. If nums[mid] == target, return mid.
    3. Check which half is sorted.
    4. Check if target lies in that sorted half.
    5. Search only the required half.

    Time Complexity: O(log n)
    Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) 
    {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target)
            {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid])
            {
                // Target lies in the sorted left half
                if (nums[left] <= target && target < nums[mid])
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }

            // Right half is sorted
            else
            {
                // Target lies in the sorted right half
                if (nums[mid] < target && target <= nums[right])
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
