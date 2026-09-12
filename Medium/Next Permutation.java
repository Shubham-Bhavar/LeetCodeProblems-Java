/*
========================================================
LeetCode 31 - Next Permutation
========================================================

Problem:
--------
Given an array of integers, find the next lexicographically
greater permutation.

If no greater permutation exists, rearrange the array into
the lowest possible order (ascending order).

The solution must work IN-PLACE and use O(1) extra space.

Examples:
----------
Input:  [1,2,3]
Output: [1,3,2]

Input:  [3,2,1]
Output: [1,2,3]

Input:  [1,1,5]
Output: [1,5,1]

--------------------------------------------------------
Approach:
--------------------------------------------------------

STEP 1: Find the pivot
----------------------
Start from the right and find the first index i where:

nums[i] < nums[i + 1]

This is the position that we need to increase.

STEP 2: Find the next greater element
-------------------------------------
Again start from the right and find the first element
greater than nums[i].

Swap nums[i] and nums[j].

STEP 3: Reverse the remaining part
----------------------------------
Reverse the elements from i + 1 to the end.

Why?
----
After the swap, the remaining part is in descending
order. Reversing it makes it the smallest possible
arrangement.

--------------------------------------------------------
Example:
--------------------------------------------------------

nums = [1,2,3]

STEP 1:
Find pivot:
2 < 3

pivot = 1

STEP 2:
Find element greater than 2:
3

Swap:
[1,3,2]

STEP 3:
Reverse remaining part:
[1,3,2]

Answer = [1,3,2]

--------------------------------------------------------
Complexity:
--------------------------------------------------------

Time Complexity  : O(n)
Space Complexity : O(1)

========================================================
*/

class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // STEP 1: Find the pivot
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // STEP 2: Find the next greater element
        if (i >= 0) {

            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap pivot with next greater element
            swap(nums, i, j);
        }

        // STEP 3: Reverse the remaining part
        reverse(nums, i + 1, n - 1);
    }

    // Swap two elements
    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse array from left to right
    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            swap(nums, left, right);

            left++;
            right--;
        }
    }
}
