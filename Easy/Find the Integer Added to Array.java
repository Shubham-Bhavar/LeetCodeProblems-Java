/*
===========================================================
LeetCode - Find the Integer Added to Array
===========================================================

PROBLEM:
Given two arrays nums1 and nums2 of the same length.

The same integer x is added to every element of nums1.
After adding x, nums1 becomes equal to nums2.

Return x.

-----------------------------------------------------------
EXAMPLE:
-----------------------------------------------------------

nums1 = [2, 6, 4]
nums2 = [9, 7, 5]

After sorting:

nums1 = [2, 4, 6]
nums2 = [5, 7, 9]

Difference:

5 - 2 = 3
7 - 4 = 3
9 - 6 = 3

Therefore:
x = 3

-----------------------------------------------------------
LOGIC:
-----------------------------------------------------------

1. Sort both arrays.

2. After sorting, corresponding elements will match.

3. Find the difference between the first elements:

       x = nums2[0] - nums1[0]

4. The problem guarantees that the same x works
   for every element.

-----------------------------------------------------------
TIME COMPLEXITY:
-----------------------------------------------------------

Sorting nums1  -> O(n log n)
Sorting nums2  -> O(n log n)

Overall -> O(n log n)

SPACE:
O(1) extra space (ignoring sorting implementation).

===========================================================
*/

class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return nums2[0] - nums1[0];
    }
}
