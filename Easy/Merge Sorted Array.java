/*
LeetCode 88 - Merge Sorted Array

Problem:
Given two sorted arrays nums1 and nums2, merge nums2 into nums1
so that nums1 becomes sorted.

nums1 has size m + n:
- First m elements are actual values.
- Last n elements are empty space (0).

Example:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Output:
[1,2,2,3,5,6]


Approach:
Use three pointers:

i = m - 1       -> last actual element of nums1
j = n - 1       -> last element of nums2
k = m + n - 1   -> last position of nums1

Compare nums1[i] and nums2[j].
Put the larger value at nums1[k].

Move the corresponding pointer backward.

Why from the end?
If we merge from the beginning, we may overwrite elements
of nums1 that we still need.
The empty positions are at the end, so merging backwards
avoids this problem.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge from the end
        while(i >= 0 && j >= 0)
        {
            if(nums1[i] > nums2[j])
            {
                nums1[k] = nums1[i];
                i--;
            }
            else
            {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // If nums2 still has elements
        while(j >= 0)
        {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
