/*
PROBLEM: Sum of All Subset XOR Totals

Brute Force Idea:
- Generate all subsets
- Find XOR of each
- Add all results

But subsets = 2^n → expensive

Optimized Insight:
- Each bit (0/1) contributes independently
- If a bit appears in any number → it contributes in half of subsets

Why half?
- For each subset, that bit is either included or excluded
- So it appears in 2^(n-1) subsets

Steps:
1. Take OR of all elements → captures all bits that appear
2. Multiply by 2^(n-1)

Example:
nums = [1,3]
OR = 3
n = 2
Answer = 3 * 2^(1) = 6

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int subsetXORSum(int[] nums) {

        int or = 0;

        // Step 1: compute OR
        for (int num : nums) {
            or |= num;
        }

        // Step 2: multiply with 2^(n-1)
        return or * (1 << (nums.length - 1));
    }
}
