/*
Q: Replace even → 0, odd → 1 and return sorted array (0s first, 1s later)
*/

class Solution {
    public int[] transformArray(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int index = 0;   // where to place next 0

        // first pass → place all 0s (even numbers)
        for (int num : nums) {

            // why num % 2 == 0? → check even
            if (num % 2 == 0) {
                ans[index++] = 0;
            }
        }

        // second pass → fill remaining with 1s (odd numbers)
        while (index < n) {
            ans[index++] = 1;
        }

        return ans;
    }
}
