/*
Question:
You are given an array nums1 of n distinct integers.

Construct nums2 such that all elements of nums2 are either
all odd or all even.

For each nums1[i], we can choose:
1. nums1[i]
2. nums1[i] - nums1[j], where j != i

Return true if it is possible.

Key Idea:
It is ALWAYS possible.

- If there are no odd numbers, keep all elements -> all even.
- If there is exactly one odd number:
  Keep the odd number.
  For every even number, subtract the odd number -> odd.
- If there are at least two odd numbers:
  For every odd number, subtract another odd number -> even.

Example:
nums1 = [2, 3]

Choose:
2 - 3 = -1  -> odd
3           -> odd

So nums2 = [-1, 3].
Answer = true.
*/

class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}
